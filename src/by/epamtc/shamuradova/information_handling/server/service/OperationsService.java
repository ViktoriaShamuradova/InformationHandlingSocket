package by.epamtc.shamuradova.information_handling.server.service;

import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.service.exception.ServiceException;

public interface OperationsService {

    Text maxCountOfEqualWords(String textStr) throws ServiceException;

    Text sortSentencesInAscendingOrder(String textStr)throws ServiceException;

    Text swapFirstAndLastWords(String textStr)throws ServiceException;

}
