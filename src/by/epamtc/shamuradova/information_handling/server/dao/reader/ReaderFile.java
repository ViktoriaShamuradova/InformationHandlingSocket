package by.epamtc.shamuradova.information_handling.server.dao.reader;

import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;
import by.epamtc.shamuradova.information_handling.server.dao.exception.ReaderException;

import java.io.*;
//предусмотреть размр файла
public class ReaderFile {

    public String readAll(File file) throws DAOException {

        StringBuilder text = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {

            while ((line = bufferedReader.readLine()) != null) {
                text.append(line).append("\n");
            }

        } catch (FileNotFoundException e) {
            throw new ReaderException("File not found");
        } catch (IOException e) {
            throw new ReaderException(e);
        }
        return text.toString();
    }
}
