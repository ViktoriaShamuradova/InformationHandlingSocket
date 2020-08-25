package by.epamtc.shamuradova.information_handling.server.service.factory;

import by.epamtc.shamuradova.information_handling.server.service.OperationsService;
import by.epamtc.shamuradova.information_handling.server.service.impl.OperationsServiceImpl;

public class ServiceFactory {

    private static final ServiceFactory INSTANCE = new ServiceFactory();

    private OperationsService operationsService;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return INSTANCE;
    }

    public OperationsService getOperationsService() {

        if (operationsService == null) {
            synchronized (INSTANCE) {
                if (operationsService == null) {
                    operationsService = new OperationsServiceImpl();
                }
            }
        }
        return operationsService;
    }

}
