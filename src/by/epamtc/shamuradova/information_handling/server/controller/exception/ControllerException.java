package by.epamtc.shamuradova.information_handling.server.controller.exception;

public class ControllerException extends Exception {
    public ControllerException(String message) {
        super(message);
    }

    public ControllerException() {
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }
}
