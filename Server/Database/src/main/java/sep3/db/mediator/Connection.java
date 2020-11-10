package sep3.db.mediator;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import sep3.db.model.UserDAOImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Connection {
    public static void main(String[] args) throws IOException {
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://user:0JdyNe9bmUyZzK8S@cluster.efwee.mongodb.net/cluster?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("sep3");

        UserDAOImpl userDAOImpl = new UserDAOImpl(database);
        userDAOImpl.ValidateUser("hllo", "gooodbye");


        final int PORT = 5678;

        System.out.println("Starting Server...");

        ServerSocket welcomeSocket = new ServerSocket(PORT);

        while (true) {
            System.out.println("Waiting for a client...");

            Socket socket = welcomeSocket.accept();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String client = socket.getInetAddress().getHostAddress();

            String request = in.readLine();

            System.out.println("Client> " + request);
            if (request.equals("hello")) {
                out.println("ZAIBISI");
                System.out.println("Server> " + "ZAIBISI");

//                request = in.readLine();
//
//                System.out.println(client + " " + request);
//                out.println("Password?");
//                System.out.println("Server> " + "Password?");

            } else {
                out.println("Disconnected");
                System.out.println("Server> " + "Disconnected");
                break;
            }

        }

    }
}
