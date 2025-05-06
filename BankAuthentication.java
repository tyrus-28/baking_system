import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BankAuthentication extends JFrame {

    public BankAuthentication() {
        // Set up the frame
        setTitle("Authentication");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Create a panel for input fields
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setBackground(new Color(245, 245, 245)); // light gray

        // Add components to the panel
        JLabel accountLabel = new JLabel("Account number:");
        accountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        JTextField accountField = new JTextField();
        accountField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JLabel pinLabel = new JLabel("Pin:");
        pinLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        JPasswordField pinField = new JPasswordField();
        pinField.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        panel.add(accountLabel);
        panel.add(accountField);
        panel.add(pinLabel);
        panel.add(pinField);

        // Create Log In button
        JButton loginButton = new JButton("Log in");
        loginButton.setBackground(new Color(30, 144, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Log In action
                String accountNumber = accountField.getText();
                String pin = new String(pinField.getPassword());
                // Authentication logic here
                if (accountNumber.isEmpty() || pin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter account number and pin.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                // For demo, accept any non-empty input as successful login
                JOptionPane.showMessageDialog(null, "Logging in with Account: " + accountNumber);
                BankingSystem bankingSystem = new BankingSystem();
                bankingSystem.setVisible(true);
                dispose();
            }
        });

        // Create New Account button
        JButton newAccountButton = new JButton("New Account");
        newAccountButton.setBackground(new Color(100, 149, 237));
        newAccountButton.setForeground(Color.WHITE);
        newAccountButton.setFocusPainted(false);
        newAccountButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
        newAccountButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        newAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle New Account action
                CreateAccountFrame createAccountFrame = new CreateAccountFrame();
                createAccountFrame.setVisible(true);
                dispose();
            }
        });

        // Title label
        JLabel titleLabel = new JLabel("LiLa Bank", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.GRAY);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Add components to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 245, 245));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        buttonPanel.add(loginButton);
        buttonPanel.add(newAccountButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BankAuthentication authFrame = new BankAuthentication();
            authFrame.setVisible(true);
        });
    }
}
