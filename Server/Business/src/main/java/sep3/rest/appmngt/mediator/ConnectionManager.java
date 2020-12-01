package sep3.rest.appmngt.mediator;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionManager implements ConnectionHandler {


    public static final String HOST = "localhost";
    public static final int PORT = 9876;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private static ConnectionManager instance;
    private static Object lock = new Object();

    private ConnectionManager() throws IOException {
        connect();
    }

    public static ConnectionManager getInstance() throws IOException {
        if(instance == null)
        {
            synchronized (lock)
            {
                if (instance == null)
                {
                    instance = new ConnectionManager();
                }
            }
        }
        return instance;
    }

    @Override
    public void connect() throws IOException {
        this.socket = new Socket(HOST, PORT);
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
    }

    @Override
    public void disconnect() throws IOException {
        socket.close();
    }

    @Override
    public void sendToServer(String message) throws IOException {
        byte[] responseAsBytes = message.getBytes();
        outputStream.write(responseAsBytes, 0, responseAsBytes.length);
    }

    @Override
    public String readFromServer() throws IOException {
        byte[] lenbytes = new byte[1024];
        int read = inputStream.read(lenbytes,0,lenbytes.length);
        String message = new String(lenbytes,0,read);
        return message;
    }
}
