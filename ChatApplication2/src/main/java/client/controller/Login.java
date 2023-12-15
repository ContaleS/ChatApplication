package client.controller;

import client.Client;
import server.database.User;

public class Login {
    private static String header = "LOGIN";
    private static final Login login = new Login();
    private Login(){

    }

    public static Login getInstance(){
        return login;
    }
    public String sendLogin(String username, String password){
        return   "header: " + header +";"
                + "username: " + username + ";"
                + "password: " + password;
    }

}
