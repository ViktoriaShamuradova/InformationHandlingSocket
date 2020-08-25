package by.epamtc.shamuradova.information_handling.server.service.impl;

import by.epamtc.shamuradova.information_handling.server.bean.Component;
import by.epamtc.shamuradova.information_handling.server.bean.impl.PartOfSentence;
import by.epamtc.shamuradova.information_handling.server.bean.impl.Sentence;
import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.dao.TextDAO;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;
import by.epamtc.shamuradova.information_handling.server.dao.impl.factory.DAOFactory;
import by.epamtc.shamuradova.information_handling.server.service.OperationsService;
import by.epamtc.shamuradova.information_handling.server.service.exception.ServiceException;
import by.epamtc.shamuradova.information_handling.server.service.impl.util.SentencesOperation;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsServiceImpl implements OperationsService {

    private DAOFactory daoFactory;
    private TextDAO textDAO;

    public OperationsServiceImpl() {
        daoFactory = DAOFactory.getInstance();
        textDAO = daoFactory.getTextDAO();
    }

    //найти  предложения текста, в которых есть наибольшее количество одинаковых слов
    @Override
    public Text maxCountOfEqualWords(String textStr) throws ServiceException {
        Text result;
        try {
            Text text = textDAO.getText(textStr);
            result = new Text();

            List<Sentence> sentences = SentencesOperation.getSentences(text);

            Map<Sentence, Integer> hashMap = new HashMap<>();

            for (Sentence sentence : sentences) {
                int maxCountOfEqualsWords = SentencesOperation.getMaxCountOfEqualsWords(sentence);
                hashMap.put(sentence, maxCountOfEqualsWords);
            }
            //берем все максимальныя колчиства слов предложений и ищем mаксимальное со всех предложений
            int maxCount = findMaxCountOfEqualsWordFromAllSentences(hashMap);

            //идем по мэпу и отбираем предложения
            for (Map.Entry<Sentence, Integer> sentenceWithMaxCount : hashMap.entrySet()) {
                if (sentenceWithMaxCount.getValue().equals(maxCount)) {
                    result.add(sentenceWithMaxCount.getKey());
                }
            }
            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    //вывести все предложения заданного текста в порядке возрастания количества слов в каждом из них
    @Override
    public Text sortSentencesInAscendingOrder(String textStr) throws ServiceException {
        try {
            Text text = textDAO.getText(textStr);
            List<Component> partsOfText = text.getComponents();
            Collections.sort(partsOfText);
            return new Text(partsOfText);
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    //оменять местами первое и последнее слово
    @Override
    public Text swapFirstAndLastWords(String textStr) throws ServiceException {
        try {
            Text text = textDAO.getText(textStr);
            Text result = new Text();
            List<Sentence> sentences = SentencesOperation.getSentences(text);

            for (Sentence sentence : sentences) {
                List<PartOfSentence> sentencePart = sentence.getSentencePart();
                PartOfSentence first = sentencePart.get(0);
                PartOfSentence last = sentencePart.get(sentencePart.size() - 1);
                sentencePart.set(0, last);
                sentencePart.remove(sentencePart.size() - 1);
                sentencePart.add(first);
                result.add(sentence);

            }

            return result;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    private int findMaxCountOfEqualsWordFromAllSentences(Map<Sentence, Integer> hashMap) {
        int maxCount = 1;
        for (Integer count : hashMap.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }


}
