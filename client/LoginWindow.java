import javax.swing.*;
import java.awt.*;

public class LoginWindow extends JFrame {
    private ClientMain controller;
    private JTextField userField = new JTextField(15);
    private JPasswordField passField = new JPasswordField(15);
    private JTextField nameField = new JTextField(15); 
    private JButton loginBtn = new JButton("Login");
    private JButton registerBtn = new JButton("Register New");

    public LoginWindow(ClientMain controller) {
        this.controller = controller;
        setTitle("QuizMasterNet - Login");
        setSize(320, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.add(new JLabel("Username (CNE):"));
        panel.add(userField);
        panel.add(new JLabel("Password:"));
        panel.add(passField);
        panel.add(new JLabel("Full Name (Reg only):"));
        panel.add(nameField);
        
        panel.add(loginBtn);
        panel.add(registerBtn);
        
        add(panel, BorderLayout.CENTER);

        loginBtn.addActionListener(e -> {
            String u = userField.getText();
            String p = new String(passField.getPassword());
            if(!u.isEmpty() && !p.isEmpty()) controller.sendLogin(u, p);
        });
        
        registerBtn.addActionListener(e -> {
            String u = userField.getText();
            String p = new String(passField.getPassword());
            String n = nameField.getText();
             if(!u.isEmpty() && !p.isEmpty() && !n.isEmpty()) controller.sendRegister(u, p, n);
             else JOptionPane.showMessageDialog(this, "Fill all fields for registration");
        });
    }
}