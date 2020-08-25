package by.epamtc.shamuradova.information_handling.server.dao.parse;

import by.epamtc.shamuradova.information_handling.server.bean.Component;
import by.epamtc.shamuradova.information_handling.server.bean.impl.PartOfSentence;
import by.epamtc.shamuradova.information_handling.server.dao.reader.ReaderProperty;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartOfSentenceParser extends Parser {

    private String regexNamePartOfSentence = PropertiesKeysRegex.PART_OF_SENTENCE;


    public PartOfSentenceParser() {
    }

    @Override
    List<Component> parse(String text) throws DAOException {
        List<Component> partsOfSentence = new ArrayList<>();

        String regexValuePartOfSentence = getRegexValue(regexNamePartOfSentence);

        Pattern patternPartOfSentence = Pattern.compile(regexValuePartOfSentence);
        Matcher matcher = patternPartOfSentence.matcher(text);

        while (matcher.find()) {
            partsOfSentence.add(new PartOfSentence(matcher.group().intern()));
        }

        return partsOfSentence;
    }

    private String getRegexValue(String regexName) throws DAOException {
        ReaderProperty readerProperty = new ReaderProperty();
        return readerProperty.getProperty(getFile(), regexName);
    }

}
