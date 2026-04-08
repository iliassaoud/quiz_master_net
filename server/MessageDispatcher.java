import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MessageDispatcher {
    private static List<PrintWriter> clients = new ArrayList<>();

    public static synchronized void addClient(PrintWriter out) {
        clients.add(out);
    }

    public static synchronized void removeClient(PrintWriter out) {
        clients.remove(out);
    }

    public static synchronized void broadcast(String message) {
        for (PrintWriter writer : clients) {
            writer.println(message);
        }
    }
}