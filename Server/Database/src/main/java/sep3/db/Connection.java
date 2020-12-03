package sep3.db;

import sep3.db.mediator.ClientConnector;

import java.io.IOException;

public class Connection {
    public static void main(String[] args) throws IOException {
        ClientConnector clientConnector = new ClientConnector();
        Thread serverThread = new Thread(clientConnector);
        serverThread.start();
    }
}
