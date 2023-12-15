package client;

import client.controller.SignUp;
import client.view.SignUpForm;
import service.splitService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
     splitService splitService = service.splitService.getInstance();
     public static BufferedReader in;
     public static PrintWriter out;
     String message;

    public void start() throws Exception{
        Socket socket = new Socket("localhost",2403);
        socket.isConnected()
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        while (true){
            message = in.readLine();
            String[] messages = message.split(";");
            for (int i = 0; i <messages.length;i++){
                messages[i] = splitService.splitMessage(messages[i]);
                System.out.println(messages[i]);
            }
            switch (messages[0]){
                case "CheckLogin":
                    client.view.LoginForm.getInstance().announce(messages[1]);
                    break;

                case "CheckSignUp":
                    client.view.SignUpForm.getInstance().announce(messages[1]);
                    break;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        client.view.LoginForm.getInstance(); // login view
        Client client = new Client();
        client.start();
    }


}
