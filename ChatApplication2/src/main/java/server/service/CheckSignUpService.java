package server.service;

import server.database.User;
import server.respositories.UserInfoRepository;

import java.sql.SQLException;

public class CheckSignUpService {

    private static final CheckSignUpService checkSignUpService = new CheckSignUpService();
    private final String type = "CheckSignUp";
    private String message;
    UserInfoRepository userInfoRepository = server.respositories.UserInfoRepository.getInstance();
    private CheckSignUpService(){

    }
    public static CheckSignUpService getInstance(){
        return checkSignUpService;
    }

    public String response(){
        return "Type: "+ type +";" + "Message: " + message;
    }
    public void CheckSignUp(String username, String password) throws SQLException {
        if(!userInfoRepository.getUserList().containsKey(username)){
            userInfoRepository.createUser(username,password);
            message = "1";
        }
        else message = "0";
    }

}
