import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {
    public static void main(String[] args) {
        System.out.println("QuizMasterNet Server starting on port " + ServerConfig.PORT + "...");
        try (ServerSocket serverSocket = new ServerSocket(ServerConfig.PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client: " + clientSocket.getInetAddress());
                new ServerWorker(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}