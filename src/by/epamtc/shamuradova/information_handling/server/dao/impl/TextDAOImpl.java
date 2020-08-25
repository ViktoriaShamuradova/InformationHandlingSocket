package by.epamtc.shamuradova.information_handling.server.dao.impl;

import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.dao.TextDAO;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;
import by.epamtc.shamuradova.information_handling.server.dao.parse.TextParser;
import by.epamtc.shamuradova.information_handling.server.dao.reader.ReaderFile;

import java.io.File;

public class TextDAOImpl implements TextDAO {

    private ReaderFile readerFile;
    private TextParser textParser;

    public TextDAOImpl() {
        readerFile = new ReaderFile();
        textParser = new TextParser();
    }

    @Override
    public Text getText(File file) throws DAOException {
        String textStr = readerFile.readAll(file);
        return textParser.createText(textStr);
    }

    @Override
    public Text getText(String textStr) throws DAOException {
        return textParser.createText(textStr);
    }
}
