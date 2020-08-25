package by.epamtc.shamuradova.information_handling.server.dao.reader;

import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;
import by.epamtc.shamuradova.information_handling.server.dao.exception.ReaderException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReaderProperty {

    private Properties properties;

    public ReaderProperty() {
        properties = new Properties();
    }

    public String getProperty(File file, String regexName) throws DAOException {
        try {
            properties.load(new FileInputStream(file));
            return properties.getProperty(regexName);
        } catch (IOException e) {
            throw new ReaderException(e);
        }
    }

}
