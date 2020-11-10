package sep3.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import sep3.db.mediator.ClientConnector;
import sep3.db.model.Model;
import sep3.db.model.ModelManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection {
    public static void main(String[] args) throws IOException {

        ClientConnector clientConnector = new ClientConnector();
        Thread serverThread = new Thread(clientConnector);
        serverThread.start();
    }
}
