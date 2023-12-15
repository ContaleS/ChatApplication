package client.view;

import javax.swing.*;
import java.awt.*;

public class FriendListPage extends JFrame {
    private DefaultListModel<String> friendsListModel;
    private JList<String> friendsList;

    public FriendListPage() {
        setTitle("Friend List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo danh sách bạn bè
        String[] friends = {"Friend 1", "Friend 2", "Friend 3", "Friend 4"};
        friendsListModel = new DefaultListModel<>();
        for (String friend : friends) {
            friendsListModel.addElement(friend);
        }

        // Tạo JList để hiển thị danh sách bạn bè
        friendsList = new JList<>(friendsListModel);
        friendsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Tạo giao diện chính sử dụng GridBagLayout
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(new JScrollPane(friendsList), constraints);

        // Hiển thị giao diện
        setContentPane(mainPanel);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FriendListPage());
    }
}