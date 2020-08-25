package by.epamtc.shamuradova.information_handling.client;

import java.io.*;
import java.net.Socket;

public class ClientSocket {

    private int port;
    private String ip;
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ClientSocket(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() throws IOException {
        socket = new Socket(ip, port);
        System.out.println("Client: connection established");

        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String requestText = createRequest();
        sendRequestToServer(requestText);

        String menuAnswer = readAnswerFromServer();
        showAnswerFromServerInConsole(menuAnswer);
        String numberOfOperation = createRequest();
        sendRequestToServer(numberOfOperation);
        String result = readAnswerFromServer();
        showAnswerFromServerInConsole(result);

        reader.close();
        writer.close();
        socket.close();
    }

    private void showAnswerFromServerInConsole(String menuAnswer) {
        System.out.println(menuAnswer);
    }

    private String readAnswerFromServer() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.readLine() != null) {
            stringBuilder.append(reader.readLine());
        }
        return stringBuilder.toString();
    }

    private String createRequest() throws IOException {
        StringBuilder request = new StringBuilder();
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferReader.readLine();

        while (!line.isEmpty()) { //здесь баг. в тексте может быть пустая строка
            request.append(line).append("\n");
            line = bufferReader.readLine();
        }
        bufferReader.close();
        return request.toString();
    }

    private void sendRequestToServer(String request) throws IOException {
        writer.write(request);
        writer.flush();
    }

    public static void main(String[] args) throws IOException {
        StringBuilder request = new StringBuilder();
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

        String line = bufferReader.readLine();

        while (!line.isEmpty()) { //здесь баг. в тексте может быть пустая строка
            request.append(line).append("\n");
            line = bufferReader.readLine();
        }
        bufferReader.close();
        System.out.println(request);
    }
}
