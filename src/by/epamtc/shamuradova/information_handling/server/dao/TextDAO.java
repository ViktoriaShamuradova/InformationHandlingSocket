package by.epamtc.shamuradova.information_handling.server.dao;

import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;

import java.io.File;

public interface TextDAO {

    Text getText(File file) throws DAOException;
    Text getText (String string) throws DAOException;

}
