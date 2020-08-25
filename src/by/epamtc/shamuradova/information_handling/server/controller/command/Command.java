package by.epamtc.shamuradova.information_handling.server.controller.command;

import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.controller.exception.ControllerException;

public interface Command {

    Text execute(String textStr) throws ControllerException;
}
