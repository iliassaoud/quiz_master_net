import java.io.BufferedReader;
import java.io.IOException;

public class ClientListener implements Runnable {
    private ClientMain controller;
    private BufferedReader in;

    public ClientListener(ClientMain controller, BufferedReader in) {
        this.controller = controller;
        this.in = in;
    }

    @Override
    public void run() {
        String line;
        try {
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(Protocol.SEPARATOR);
                String command = parts[0];

                if (Protocol.AUTH_SUCCESS.equals(command)) {
                    String fullname = (parts.length > 1) ? parts[1] : "Student";
                    controller.onLoginSuccess(fullname);
                } else if (Protocol.AUTH_FAIL.equals(command)) {
                    controller.onLoginFail();
                } else if (Protocol.QUESTION.equals(command)) {
                    if(parts.length > 2) controller.onQuestionReceived(parts[2]);
                } else if (Protocol.SCORE.equals(command)) {
                    if(parts.length > 2) controller.onScoreReceived(parts[2]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}