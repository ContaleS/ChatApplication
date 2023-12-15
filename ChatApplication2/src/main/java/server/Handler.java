package server;

import server.service.*;
import service.splitService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;



public class Handler implements Runnable {
    private Socket clientSocket;
    BufferedReader in;
    PrintWriter out;
    String message;
    splitService splitService = service.splitService.getInstance();
    CheckLoginService checkLoginService = server.service.CheckLoginService.getInstance();
    CheckSignUpService checkSignUpService = server.service.CheckSignUpService.getInstance();
    ViewListFriendService viewListFriendService = server.service.ViewListFriendService.getInstance();
    SendFriendRequestService sendFriendRequestService = server.service.SendFriendRequestService.getInstance();

    public Handler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run(){
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(),true);
            while (true){
               message = in.readLine();
               String[] messages = message.split(";");
               for (int i = 0; i <messages.length; i++){
                   messages[i] = splitService.splitMessage(messages[i]);
                   System.out.println(messages[i]);
               }
               switch (messages[0]){
                   case "LOGIN":
                       checkLoginService.checkLogin(messages[1],messages[2]);
                       out.println(checkLoginService.response());
                       break;
                   case "SIGNUP":
                       checkSignUpService.CheckSignUp(messages[1],messages[2]);
                       out.println(checkSignUpService.response());
                       break;
                   case "VIEWLISTFRIEND":
                       viewListFriendService.ViewListFriend(messages[1]);
                       break;
                   case "SENDFRIENDREQUEST":
                        sendFriendRequestService.SendFriendRequest(messages[1],messages[2],messages[3]);
                        break;
                   case "ACCEPTFRIENDREQUEST":

               }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
