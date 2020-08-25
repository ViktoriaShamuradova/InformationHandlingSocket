package by.epamtc.shamuradova.information_handling.server.dao.parse.factory;

import by.epamtc.shamuradova.information_handling.server.dao.parse.CodeParser;
import by.epamtc.shamuradova.information_handling.server.dao.parse.Parser;
import by.epamtc.shamuradova.information_handling.server.dao.parse.PartOfSentenceParser;
import by.epamtc.shamuradova.information_handling.server.dao.parse.SentenceParser;

public final class ParserFactory {

    private static final ParserFactory INSTANCE = new ParserFactory();

    private Parser PART_OF_SENTENCE;
    private Parser CODE_PARSER;
    private Parser SENTENCE_PARSER;

    private ParserFactory() {
    }

    public static ParserFactory getInstance() {
        return INSTANCE;
    }

    public Parser getPartOfSentenceParser() {
        if (PART_OF_SENTENCE == null) {
            synchronized (INSTANCE) {
                if (PART_OF_SENTENCE == null) {
                    PART_OF_SENTENCE = new PartOfSentenceParser();
                }
            }
        }
        return PART_OF_SENTENCE;
    }

    public Parser getCodeParser() {
        if (CODE_PARSER == null) {
            synchronized (INSTANCE) {
                if (CODE_PARSER == null) {
                    CODE_PARSER = new CodeParser();
                }
            }
        }
        return CODE_PARSER;
    }

    public Parser getSentenceParser() {
        if (SENTENCE_PARSER == null) {
            synchronized (INSTANCE) {
                if (SENTENCE_PARSER == null) {
                    SENTENCE_PARSER = new SentenceParser();
                }
            }
        }
        return SENTENCE_PARSER;
    }
}
