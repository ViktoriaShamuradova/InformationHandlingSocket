package by.epamtc.shamuradova.information_handling.server.dao.parse;

import by.epamtc.shamuradova.information_handling.server.bean.Component;
import by.epamtc.shamuradova.information_handling.server.bean.impl.CodeBlock;
import by.epamtc.shamuradova.information_handling.server.dao.reader.ReaderProperty;
import by.epamtc.shamuradova.information_handling.server.dao.exception.DAOException;
import by.epamtc.shamuradova.information_handling.server.dao.parse.factory.ParserFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeParser extends Parser {

    private final String regexName = PropertiesKeysRegex.CODE;
    private ParserFactory parserFactory;
    private Parser partOfSentenceParser;

    public CodeParser() {
        parserFactory = ParserFactory.getInstance();
        partOfSentenceParser = parserFactory.getPartOfSentenceParser();

    }

    @Override
    List<Component> parse(String text) throws DAOException {
        List<Component> codeBlocks = new ArrayList<>();

        String regexValue = getRegexValue(regexName);
        Pattern pattern = Pattern.compile(regexValue);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            CodeBlock codeBlock = new CodeBlock();

            String codeBlockStr = matcher.group();
            List<Component> parse = partOfSentenceParser.parse(codeBlockStr);

            codeBlock.add(parse);

            codeBlocks.add(codeBlock);
        }
        return codeBlocks;
    }

    private String getRegexValue(String regexName) throws DAOException {
        ReaderProperty readerProperty = new ReaderProperty();
        return readerProperty.getProperty(getFile(), regexName);
    }

    public static void main(String[] args) throws DAOException {
        CodeParser codeParser = new CodeParser();
        String reg = ".*\\{\\s(.*\\n)+?\\n*}";
        String reg2 = "[A-Za-z0-9,.?!'\"=>>\\[\\](){}:;\\-]+";

        String string = "Deciding when to omit the braces is a matter of personal taste. Omitting them can make the code more brittle. If a second statement is later added \n" +
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

        List<Component> parse = codeParser.parse(string);
        for (Component c : parse) {
            System.out.println(c.getComponent());
        }
////        Pattern pattern = Pattern.compile(reg);
////        Matcher matche = pattern.matcher(string);
////        while (matche.find()){
////            String s = matche.group();
////            Pattern pattern1 = Pattern.compile(reg2);
////            Matcher matcher = pattern1.matcher(s);
////            while(matcher.find()){
////                System.out.print(matcher.group()+" ");
////            }
////        }


    }
}
