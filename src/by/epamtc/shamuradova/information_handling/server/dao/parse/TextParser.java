package by.epamtc.shamuradova.information_handling.server.dao.parse;

import by.epamtc.shamuradova.information_handling.server.bean.Component;
import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;
import by.epamtc.shamuradova.information_handling.server.dao.reader.ReaderProperty;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;
import by.epamtc.shamuradova.information_handling.server.dao.parse.factory.ParserFactory;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TextParser {
    private final String regexName = PropertiesKeysRegex.TEXT;
    private ParserFactory parserFactory;
    private Parser sentenceParser;
    private Parser codeParser;

    public TextParser() {
        parserFactory = ParserFactory.getInstance();
        sentenceParser = parserFactory.getSentenceParser();
        codeParser = parserFactory.getCodeParser();

    }


    public Text createText(String allText) throws DAOException {
        Text text = new Text();

        String regexValueText = getRegexValue(regexName);
        Pattern pattern = Pattern.compile(regexValueText);
        Matcher matcher = pattern.matcher(allText);

        while (matcher.find()) {
            String partOfText = matcher.group();

            List<Component> codeParse = codeParser.parse(partOfText);

            if (codeParse.isEmpty()) {
                text.add(sentenceParser.parse(partOfText));
            } else {
                text.add(codeParse);
            }
        }
        return text;
    }

    private String getRegexValue(String regexName) throws DAOException {
        ReaderProperty readerProperty = new ReaderProperty();
        return readerProperty.getProperty(Parser.getFile(), regexName);
    }

    public static void main(String[] args) throws DAOException {
        String text = "Deciding when to omit the braces is a matter of personal taste. Omitting them can make the code more brittle. If a second statement is later added \n" +
                "to the \"then\" clause, a common mistake would be forgetting to add the newly required braces. The compiler cannot catch this sort of error; you'll \n" +
                "just get the wrong results. \n" +
                "1.2.  The if-then-else Statement \n" +
                "The if-then-else statement provides a secondary path of execution when an \"if\" clause evaluates to false. You could use an if-then-else statement \n" +
                "in the applyBrakes method to take some action if the brakes are applied when the bicycle is not in motion. In this case, the action is to simply print \n" +
                "an error message stating that the bicycle has already stopped. \n" +
                "void applyBrakes() { \n" +
                "    if (isMoving) { \n" +
                "        currentSpeed--; \n" +
                "    } else { \n" +
                "        System.err.println(\"The bicycle has already stopped!\"); \n" +
                "    }  \n" +
                "} \n" +
                "The following program, IfElseDemo, assigns a grade based on the value of a test score: an A for a score of 90% or above, a B for a score of 80% \n" +
                "or above, and so on. \n" +
                " \n" +
                "class IfElseDemo { \n" +
                "    public static void main(String[] args) { \n" +
                " \n" +
                "        int testscore = 76; \n" +
                "        char grade; \n" +
                " \n" +
                "        if (testscore >= 90) { \n" +
                "            grade = 'A'; \n" +
                "        } else if (testscore >= 80) { \n" +
                "            grade = 'B'; \n" +
                "        } else if (testscore >= 70) { \n" +
                "            grade = 'C'; \n" +
                "        } else if (testscore >= 60) { \n" +
                "            grade = 'D'; \n" +
                "        } else { \n" +
                "            grade = 'F'; \n" +
                "        } \n" +
                "        System.out.println(\"Grade = \" + grade); \n" +
                "    } \n" +
                "} \n" +
                "The output from the program is: \n" +
                "    Grade = C \n" +
                "You may have noticed that the value of testscore can satisfy more than one expression in the compound statement: 76 >= 70 and 76 >= 60. However, \n" +
                "once a condition is satisfied, the appropriate statements are executed (grade = 'C';) and the remaining conditions are not evaluated.";
        TextParser textParser = new TextParser();
        Text text1 = textParser.createText(text);

        System.out.println(text1.getComponent());


    }
}
