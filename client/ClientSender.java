import java.io.PrintWriter;

public class ClientSender {
    private PrintWriter out;

    public ClientSender(PrintWriter out) {
        this.out = out;
    }

    public void sendLogin(String u, String p) {
        out.println(Protocol.LOGIN + Protocol.SEPARATOR_CHAR + u + Protocol.SEPARATOR_CHAR + p);
    }

    public void sendRegister(String u, String p, String n) {
        out.println(Protocol.REGISTER + Protocol.SEPARATOR_CHAR + u + Protocol.SEPARATOR_CHAR + p + Protocol.SEPARATOR_CHAR + n);
    }
    
    public void sendAnswer(String user, String ans) {
        out.println(Protocol.ANSWER + Protocol.SEPARATOR_CHAR + user + Protocol.SEPARATOR_CHAR + ans);
    }
}