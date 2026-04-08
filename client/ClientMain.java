import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class ClientMain {
    private Socket socket;
    private ClientSender sender;
    private String username;

    // UI References
    private LoginWindow loginWindow;
    private QuizWindow quizWindow;
    private ResultWindow resultWindow;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClientMain().start());
    }

    public void start() {
        try {
            socket = new Socket("localhost", ServerConfig.PORT);
            
            // Init sender and listener
            sender = new ClientSender(new PrintWriter(socket.getOutputStream(), true));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            new Thread(new ClientListener(this, in)).start();

            // Show Login
            loginWindow = new LoginWindow(this);
            loginWindow.setVisible(true);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to server.");
            e.printStackTrace();
        }
    }
    
    // Actions triggered by UI
    public void sendLogin(String user, String pass) {
        this.username = user;
        sender.sendLogin(user, pass);
    }

    public void sendRegister(String user, String pass, String fullname) {
        this.username = user;
        sender.sendRegister(user, pass, fullname);
    }
    
    public void sendAnswer(String answer) {
        sender.sendAnswer(username, answer);
    }

    // Callbacks from Listener
    public void onLoginSuccess(String fullname) {
        if(loginWindow != null) loginWindow.dispose();
        quizWindow = new QuizWindow(this, fullname);
        quizWindow.setVisible(true);
    }

    public void onLoginFail() {
        JOptionPane.showMessageDialog(loginWindow, "Login Failed.");
    }

    public void onQuestionReceived(String questionData) {
        if(quizWindow != null) {
            quizWindow.displayQuestion(questionData);
        }
    }

    public void onScoreReceived(String scoreText) {
        if(quizWindow != null) quizWindow.dispose();
        resultWindow = new ResultWindow(scoreText);
        resultWindow.setVisible(true);
    }
}