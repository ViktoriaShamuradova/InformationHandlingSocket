package by.epamtc.shamuradova.information_handling.server.dao.parse;

import by.epamtc.shamuradova.information_handling.server.bean.Component;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;

import java.io.File;
import java.util.List;

public abstract class Parser {

   // private Parser parser;

    private static final File FILE = new File("resources/regex.properties");

//    public Parser(Parser parser) {
//        this.parser = parser;
//    }

    public Parser (){}

    abstract List<Component> parse(String text) throws DAOException;

    public static File getFile() {
        return FILE;
    }
}
