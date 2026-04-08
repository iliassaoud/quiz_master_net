import javax.swing.*;
import java.awt.*;

public class QuizWindow extends JFrame {
    private ClientMain controller;
    private JTextArea questionText;
    private JButton btnA, btnB, btnC, btnD;
    
    public QuizWindow(ClientMain controller, String studentName) {
        this.controller = controller;
        setTitle("Quiz - " + studentName);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        questionText = new JTextArea();
        questionText.setEditable(false);
        questionText.setLineWrap(true);
        questionText.setWrapStyleWord(true);
        questionText.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        JPanel btnPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        btnA = new JButton();
        btnB = new JButton();
        btnC = new JButton();
        btnD = new JButton();
        
        btnPanel.add(btnA);
        btnPanel.add(btnB);
        btnPanel.add(btnC);
        btnPanel.add(btnD);
        
        add(new JScrollPane(questionText), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
        
        btnA.addActionListener(e -> controller.sendAnswer("A"));
        btnB.addActionListener(e -> controller.sendAnswer("B"));
        btnC.addActionListener(e -> controller.sendAnswer("C"));
        btnD.addActionListener(e -> controller.sendAnswer("D"));
    }

    public void displayQuestion(String rawData) {
        String[] parts = rawData.split(";");
        if(parts.length >= 5) {
            questionText.setText(parts[0]);
            btnA.setText("A: " + parts[1]);
            btnB.setText("B: " + parts[2]);
            btnC.setText("C: " + parts[3]);
            btnD.setText("D: " + parts[4]);
        }
    }
}