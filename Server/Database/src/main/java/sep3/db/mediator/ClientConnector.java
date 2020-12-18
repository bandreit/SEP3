package sep3.db.mediator;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import sep3.db.model.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Client connector.
 */
public class ClientConnector implements Runnable {
    /**
     * The Port.
     */
    final int PORT = 9876;
    private ServerSocket welcomeSocket;
    private UserModel modelManager;
    private BusinessModel businessModel;
    private ServiceModel serviceModel;
    private AppointmentModel appointmentModel;

    /**
     * Instantiates a new Client connector
     * Connecting to database
     *
     * @throws IOException the io exception
     */
    public ClientConnector() throws IOException {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.WARNING);
        this.welcomeSocket = new ServerSocket(PORT);
        MongoClient mongoClient = MongoClients.create(
                "mongodb+srv://user:7olkRK2xZV6pPp1a@cluster.efwee.mongodb.net/Cluster?retryWrites=true&w=majority");
        MongoDatabase database = mongoClient.getDatabase("sep3");
        this.modelManager = new UserModelManager(database);
        this.businessModel = new BusinessModelManager(database);
        this.serviceModel = new ServiceModelManager(database);
        this.appointmentModel = new AppointmentModelManager(database);
    }

    @Override
    public void run() {
        System.out.println("Waiting for a client");
        while (true) {
            try {
                Socket socket = welcomeSocket.accept();
                System.out.println("Tier 2 connected");
                ClientHandler clientHandler = new ClientHandler(socket, modelManager, businessModel, serviceModel, appointmentModel);
                Thread t = new Thread(clientHandler);
                t.setDaemon(true);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

