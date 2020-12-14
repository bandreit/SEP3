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
        byte[] toSendBytes = message.getBytes();
        int toSendLen = toSendBytes.length;
        byte[] toSendLenBytes = new byte[4];
        toSendLenBytes[0] = (byte) (toSendLen & 0xff);
        toSendLenBytes[1] = (byte) ((toSendLen >> 8) & 0xff);
        toSendLenBytes[2] = (byte) ((toSendLen >> 16) & 0xff);
        toSendLenBytes[3] = (byte) ((toSendLen >> 24) & 0xff);
        outputStream.write(toSendLenBytes);
        outputStream.write(toSendBytes);
    }

    @Override
    public String readFromServer() throws IOException {
        byte[] lenBytes = new byte[4];
        inputStream.read(lenBytes, 0, 4);
        int len = (((lenBytes[3] & 0xff) << 24) | ((lenBytes[2] & 0xff) << 16) |
                ((lenBytes[1] & 0xff) << 8) | (lenBytes[0] & 0xff));
        byte[] receivedBytes = new byte[len];
        inputStream.read(receivedBytes, 0, len);

        return new String(receivedBytes, 0, len);
    }
}
