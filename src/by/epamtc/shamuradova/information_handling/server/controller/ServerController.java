package by.epamtc.shamuradova.information_handling.server.controller;

import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.controller.command.Command;
import by.epamtc.shamuradova.information_handling.server.controller.command.CommandProvider;
import by.epamtc.shamuradova.information_handling.server.controller.exception.ControllerException;
import by.epamtc.shamuradova.information_handling.server.view.Printer;
import by.epamtc.shamuradova.information_handling.server.view.View;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {

    private CommandProvider commandProvider;
    private int port = 8080;
    private ServerSocket server;
    private static final int ANSWER_CLIENT_WAIT_TIME = 1000;

    private BufferedReader reader;
    private BufferedWriter writer;

    public ServerController() {
        commandProvider = new CommandProvider();
    }

    public void start() throws IOException, ControllerException, InterruptedException {
        server = new ServerSocket(port);

        while (true) {
            System.out.println("Server start ");

            Socket clientSocket = server.accept();

            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            Printer.print(View.start());

            //Thread.sleep(ANSWER_CLIENT_WAIT_TIME);
            String text = readAnswerStringFromClient();
            showAnswerFromClient(text);
            sendResponse(View.menu());


            int numberOfOperation = readAnswerIntFromClient();
            showAnswerFromClient(numberOfOperation);
            String result = createResponse(numberOfOperation, text);
            sendResponse(result);
            showAnswerFromClient(result);

            reader.close();
            writer.close();
            clientSocket.close();
        }
    }

    private void showAnswerFromClient(String text) {
        System.out.println(text);
    }

    private void showAnswerFromClient(int num) {
        System.out.println(num);
    }

    private String readAnswerStringFromClient() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        while (reader.readLine() != null) {
            stringBuilder.append(reader.readLine());
        }
        return stringBuilder.toString();
    }

    private String createResponse(int numberOfOperation, String text) throws ControllerException, IOException {
        Command command = commandProvider.getCommandOperation(numberOfOperation);
        Text result = command.execute(text);
        return result.getComponent();
    }

    private void sendResponse(String string) throws IOException {
        writer.write(string);
        writer.flush();
    }

    private int readAnswerIntFromClient() throws IOException {
        String request = reader.readLine();
        return Integer.valueOf(request); //предусмотреть невалидный ввод
    }
}
