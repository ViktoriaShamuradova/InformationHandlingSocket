package by.epamtc.shamuradova.information_handling.server.service.impl.util;

import by.epamtc.shamuradova.information_handling.server.bean.Component;
import by.epamtc.shamuradova.information_handling.server.bean.impl.PartOfSentence;
import by.epamtc.shamuradova.information_handling.server.bean.impl.Sentence;
import by.epamtc.shamuradova.information_handling.server.bean.impl.Text;

import java.util.ArrayList;
import java.util.List;

public class SentencesOperation {
    public static List<Sentence> getSentences(Text text) {

        List<Component> partsOfText = text.getComponents();
        List<Sentence> sentences = new ArrayList<>();

        for (int i = 0; i < partsOfText.size(); i++) {
            if (partsOfText.get(i).getClass().getSimpleName().equals("Sentence")) {

                sentences.add((Sentence) partsOfText.get(i));

            }
        }
        return sentences;
    }

    public static int getMaxCountOfEqualsWords(Sentence sentence) {
        List<PartOfSentence> sentenceParts = sentence.getSentencePart();

        int[] countsOfWords = new int[sentenceParts.size()];

        for (int indexOfWord = 0; indexOfWord < sentenceParts.size(); indexOfWord++) {
            PartOfSentence partOfSentence1 = sentenceParts.get(indexOfWord);

            int count = 1;
            for (int indexOfNextWord = indexOfWord + 1; indexOfNextWord < sentenceParts.size(); indexOfNextWord++) {
                PartOfSentence partOfSentence2 = sentenceParts.get(indexOfNextWord);

                if (partOfSentence1.equals(partOfSentence2)) {
                    count++;
                }
            }
            countsOfWords[indexOfWord] = count;
        }

        int max = 1;
        for (int indexOfCount = 0; indexOfCount < countsOfWords.length - 1; indexOfCount++) {

            if (max < countsOfWords[indexOfCount + 1]) {
                max = countsOfWords[indexOfCount + 1];
            }
        }
        return max;
    }
}
