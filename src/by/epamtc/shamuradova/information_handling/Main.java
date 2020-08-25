package by.epamtc.shamuradova.information_handling;

import by.epamtc.shamuradova.information_handling.server.controller.ServerController;
import by.epamtc.shamuradova.information_handling.server.controller.exception.ControllerException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, ControllerException, InterruptedException {
        ServerController server = new ServerController();
        server.start();

    }

}
