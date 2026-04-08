import java.io.*;
import java.net.Socket;

public class ServerWorker extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private User currentUser;
    private QuizManager quizManager;
    private ScoreManager scoreManager;

    public ServerWorker(Socket socket) {
        this.socket = socket;
        this.scoreManager = new ScoreManager();
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            MessageDispatcher.addClient(out);

            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Received: " + line);
                String[] parts = line.split(Protocol.SEPARATOR);
                String command = parts[0];

                if (Protocol.LOGIN.equals(command)) {
                    handleLogin(parts);
                } else if (Protocol.REGISTER.equals(command)) {
                    handleRegister(parts);
                } else if (Protocol.ANSWER.equals(command)) {
                    handleAnswer(parts);
                }
            }
        } catch (IOException e) {
            System.out.println("Client disconnected.");
        } finally {
            MessageDispatcher.removeClient(out);
            try { socket.close(); } catch (IOException e) {}
        }
    }

    private void handleLogin(String[] parts) {
        if (parts.length < 3) return;
        UserDAO dao = new UserDAO();
        // Uses CNE and Password
        currentUser = dao.authenticate(parts[1], parts[2]);

        if (currentUser != null) {
            out.println(Protocol.AUTH_SUCCESS + Protocol.SEPARATOR_CHAR + currentUser.getFullname());
            quizManager = new QuizManager();
            sendNextQuestion();
        } else {
            out.println(Protocol.AUTH_FAIL);
        }
    }
    
    private void handleRegister(String[] parts) {
        if (parts.length < 4) return;
        UserDAO dao = new UserDAO();
        // Register with CNE, Password, Fullname
        boolean success = dao.register(parts[1], parts[2], parts[3]);
        if(success) {
            out.println(Protocol.AUTH_SUCCESS + Protocol.SEPARATOR_CHAR + parts[3]);
            currentUser = dao.authenticate(parts[1], parts[2]);
            quizManager = new QuizManager();
            sendNextQuestion();
        } else {
            out.println(Protocol.AUTH_FAIL);
        }
    }

    private void handleAnswer(String[] parts) {
        if (currentUser == null || quizManager == null) return;
        
        String answer = parts[2]; 
        quizManager.checkAnswer(answer);
        
        if (quizManager.isFinished()) {
            finishQuiz();
        } else {
            sendNextQuestion();
        }
    }

    private void sendNextQuestion() {
        Question q = quizManager.getCurrentQuestion();
        // Send using CNE
        String msg = Protocol.QUESTION + Protocol.SEPARATOR_CHAR + currentUser.getCne() + Protocol.SEPARATOR_CHAR + q.toProtocolString();
        out.println(msg);
    }

    private void finishQuiz() {
        int finalScore = quizManager.getScore();
        int total = quizManager.getTotalQuestions();
        
        scoreManager.persistScore(currentUser.getId(), finalScore);

        String msg = Protocol.SCORE + Protocol.SEPARATOR_CHAR + currentUser.getCne() + Protocol.SEPARATOR_CHAR + finalScore + "/" + total;
        out.println(msg);
        out.println(Protocol.END + Protocol.SEPARATOR_CHAR + currentUser.getCne());
    }
}