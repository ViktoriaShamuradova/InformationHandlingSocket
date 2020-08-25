package by.epamtc.shamuradova.information_handling.server.dao.parse;

import by.epamtc.shamuradova.information_handling.server.bean.Component;
import by.epamtc.shamuradova.information_handling.server.bean.impl.PartOfSentence;
import by.epamtc.shamuradova.information_handling.server.bean.impl.Sentence;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;
import by.epamtc.shamuradova.information_handling.server.dao.parse.factory.ParserFactory;
import by.epamtc.shamuradova.information_handling.server.dao.reader.ReaderProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parser {

    private final String regexName = PropertiesKeysRegex.SENTENCE;
    private ParserFactory parserFactory;
    private Parser partOfSentenceParser;

    public SentenceParser() {
        parserFactory = ParserFactory.getInstance();
        partOfSentenceParser = parserFactory.getPartOfSentenceParser();

        //super(partOfSentenceParser);
    }

    @Override
    public List<Component> parse(String text) throws DAOException {

        List<Component> sentences = new ArrayList<>();

        String regexValue = getRegexValue();
        Pattern pattern = Pattern.compile(regexValue);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            Sentence sentence = new Sentence();
            String sentenceStr = matcher.group();

            List<Component> partOfSentence = partOfSentenceParser.parse(sentenceStr);

            for (Component component : partOfSentence) {
                sentence.add((PartOfSentence) component);
            }

            sentences.add(sentence);
        }
        return sentences;
    }

    private String getRegexValue() throws DAOException {
        ReaderProperty readerProperty = new ReaderProperty();
        return readerProperty.getProperty(getFile(), regexName);
    }

    public static void main(String[] args) throws DAOException {
        //ParserFactory parserFactory = ParserFactory.getInstance();
        Parser sentenceParser = new SentenceParser();
        String reg = "[*A-Za-z0-9,()\"':;\\s%=><-]+[.:]";
        String reg2 = "[A-Za-z0-9,.?!:;%'\"=>>\\[\\](){}\\-]+[.:;\\n]?";
        String text = "    Пример текста для разбора.\n" +
                " \n" +
                "1.  The if-then and if-then-else Statements \n" +
                "1.1.  The if-then Statement \n" +
                "The if-then statement is the most basic of all the control flow statements. It tells your program to execute a certain section of code only if a particular \n" +
                "test evaluates to true. For example, the Bicycle class could allow the brakes to decrease the bicycle's speed only if the bicycle is already in motion. \n" +
                "One possible implementation of the applyBrakes method could be as follows: \n" +
                "void applyBrakes() { \n" +
                "    // the \"if\" clause: bicycle must be moving \n" +
                "    if (isMoving){  \n" +
                "        // the \"then\" clause: decrease current speed \n" +
                "        currentSpeed--; \n" +
                "    } \n" +
                "} \n" +
                "If this test evaluates to false (meaning that the bicycle is not in motion), control jumps to the end of the if-then statement. \n" +
                "In addition, the opening and closing braces are optional, provided that the \"then\" clause contains only one statement: \n" +
                "void applyBrakes() { \n" +
                "    // same as above, but without braces  \n" +
                "    if (isMoving) \n" +
                "        currentSpeed--; \n" +
                "} ";
////        Pattern pattern = Pattern.compile(reg);
////        Matcher matcher = pattern.matcher(text);
////        while (matcher.find()) {
////            String st = matcher.group();
////            Pattern pattern1 = Pattern.compile(reg2);
////            Matcher matcher1 = pattern1.matcher(st);
////
////            while (matcher1.find()) {
////                System.out.print(matcher1.group() + " ");
////            }
////            System.out.println();
        //}
        List<Component> parse = sentenceParser.parse(text);
        for (Component c : parse) {
            System.out.println(c.getComponent());
        }
//
    }
}
