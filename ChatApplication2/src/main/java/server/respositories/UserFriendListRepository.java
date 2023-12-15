package server.respositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static server.database.database.connection;

public class UserFriendListRepository {
    private final String readQuery = "SELECT * FROM Friend where username = ?";
    private String createQuery;

    List<String> getFriendList(String username) throws SQLException {
        PreparedStatement readStatement = connection.prepareStatement(readQuery);
        readStatement.setString(1,username);
        ResultSet resultSet = readStatement.executeQuery();
        List<String> FriendList = new ArrayList<>();
        while (resultSet.next()){
            FriendList.add(resultSet.getString("friend_name"));
        }
    }
}
