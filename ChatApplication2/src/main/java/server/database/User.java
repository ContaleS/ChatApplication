package server.database;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private int status;

    private ArrayList<String> listFriend;

    public User(String username, String password, int status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }
}
