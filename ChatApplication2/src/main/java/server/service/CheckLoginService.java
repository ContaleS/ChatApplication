package server.service;

import server.respositories.UserInfoRepository;

import java.sql.SQLException;

public class CheckLoginService {
    private final String type = "CheckLogin";
    private static final CheckLoginService checkLoginService = new CheckLoginService();
    private UserInfoRepository userInfoRepository = server.respositories.UserInfoRepository.getInstance();
    private String message;

    private CheckLoginService() {
    }
    public String response(){
        return "Type: "+ type +";" + "Message: " + message;
    }
    public static CheckLoginService getInstance(){
        return checkLoginService;
    }
    public void checkLogin(String username, String password) throws SQLException {
        if(userInfoRepository.getUserList().get(username).equals(password)){
            message = "1";
        }
        else
            message = "0";

    }
}
