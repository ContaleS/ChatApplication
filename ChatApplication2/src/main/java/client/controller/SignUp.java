package client.controller;

public class SignUp {
    private final String header = "SIGNUP";
    private static final SignUp SignUp = new SignUp();

    private SignUp(){}

    public static SignUp getInstance(){
        return SignUp;
    }
    public String sendSignUp(String username,String password){
        return   "header: " + header +";"
                + "username: " + username + ";"
                + "password: " + password;
    }

}
