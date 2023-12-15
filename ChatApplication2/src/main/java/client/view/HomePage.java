package client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private static HomePage instance;
    private JList<String> friendList;
    private JTextArea chatTextArea;
    private JTextField messageTextField;

    public HomePage() {
        // Set up the user interface
        setTitle("Chat Application");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        friendList = new JList<>(new String[] {"Friend 1", "Friend 2", "Friend 3"}); // Replace with your friend list data
        friendList.setBackground(Color.LIGHT_GRAY);
        JScrollPane friendListScrollPane = new JScrollPane(friendList);
        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        chatTextArea.setBackground(Color.WHITE);
        JScrollPane chatScrollPane = new JScrollPane(chatTextArea);
        messageTextField = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(Color.BLUE);
        sendButton.setForeground(Color.WHITE);

        // Set layout
        setLayout(new BorderLayout());
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, friendListScrollPane, chatScrollPane);
        add(splitPane, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(messageTextField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);
        add(bottomPanel, BorderLayout.SOUTH);

        // Event handling for the send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = messageTextField.getText();
                appendMessage("User: " + message);
                messageTextField.setText("");
            }
        });
    }

    public static HomePage getInstance(){
        if(instance == null) instance = new HomePage();
        return instance;
    }
    public void appendMessage(String message) {
        chatTextArea.append(message + "\n");
    }
}
