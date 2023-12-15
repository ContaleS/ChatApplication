package server;

import server.database.database;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {






    public static void main(String[] args) throws IOException, SQLException {
        database database = server.database.database.getInstance();

        System.out.println("waiting for client...");

        ServerSocket serverSocket = new ServerSocket(2403);
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("established");
            Handler handler = new Handler(socket);
            handler.run();
        }

    }
}
