package by.epamtc.shamuradova.information_handling.client;

import java.io.IOException;

public class MainClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClientSocket clientSocket = new ClientSocket("127.0.0.1", 8080);
        clientSocket.start();
    }
}
