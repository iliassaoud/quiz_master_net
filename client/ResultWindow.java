import javax.swing.*;
import java.awt.*;

public class ResultWindow extends JFrame {
    public ResultWindow(String score) {
        setTitle("Final Score");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel lbl = new JLabel("Your Score: " + score, SwingConstants.CENTER);
        lbl.setFont(new Font("SansSerif", Font.BOLD, 24));
        
        add(lbl, BorderLayout.CENTER);
    }
}