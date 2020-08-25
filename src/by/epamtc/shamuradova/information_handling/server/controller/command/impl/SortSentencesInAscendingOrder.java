package by.epamtc.shamuradova.information_handling.server.controller.command.impl;

import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.controller.command.Command;
import by.epamtc.shamuradova.information_handling.server.controller.exception.ControllerException;
import by.epamtc.shamuradova.information_handling.server.service.OperationsService;
import by.epamtc.shamuradova.information_handling.server.service.exception.ServiceException;
import by.epamtc.shamuradova.information_handling.server.service.factory.ServiceFactory;

public class SortSentencesInAscendingOrder implements Command {
    @Override
    public Text execute(String textStr) throws ControllerException {

        try {
            ServiceFactory instance = ServiceFactory.getInstance();
            OperationsService operationsService = instance.getOperationsService();
            Text text = operationsService.sortSentencesInAscendingOrder(textStr);
            return text;

        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
}
