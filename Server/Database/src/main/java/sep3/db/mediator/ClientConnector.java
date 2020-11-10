package sep3.db.mediator;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import sep3.db.model.Model;
import sep3.db.model.ModelManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientConnector implements Runnable {
    final int PORT = 9876;
    private ServerSocket welcomeSocket;
    private Model modelManager;

    public ClientConnector() throws IOException {
        this.welcomeSocket = new ServerSocket(PORT);
        MongoClient mongoClient = MongoClients.create("mongodb+srv://user:0JdyNe9bmUyZzK8S@cluster.efwee.mongodb.net/Cluster?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("sep3");
        this.modelManager = new ModelManager(database);
    }

    @Override
    public void run() {
        System.out.println("Waiting for a client");
        while (true) {
            try {
                Socket socket = welcomeSocket.accept();
                ClientHandler clientHandler = new ClientHandler(socket, modelManager);
                Thread t = new Thread(clientHandler);
                t.setDaemon(true);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

