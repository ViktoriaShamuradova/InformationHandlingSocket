package by.epamtc.shamuradova.information_handling.server.dao.impl.factory;

import by.epamtc.shamuradova.information_handling.server.dao.TextDAO;
import by.epamtc.shamuradova.information_handling.server.dao.impl.TextDAOImpl;

public class DAOFactory {

    private static final DAOFactory INSTANCE = new DAOFactory();

    private final TextDAO textDAO = new TextDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return INSTANCE;
    }

    public TextDAO getTextDAO() {
        return textDAO;
    }
}
