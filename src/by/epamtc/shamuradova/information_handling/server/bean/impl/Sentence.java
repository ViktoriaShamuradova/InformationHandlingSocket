package by.epamtc.shamuradova.information_handling.server.bean.impl;

import by.epamtc.shamuradova.information_handling.server.bean.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Sentence extends Component {

    private List<PartOfSentence> partOfSentences;


    public Sentence(List<PartOfSentence> partOfSentences) {
        this.partOfSentences = partOfSentences;
    }

    public Sentence() {
        partOfSentences = new ArrayList<>();
    }

    public Sentence(String partOfSentences) {
        this.partOfSentences = new ArrayList<>();
        String[] parts = partOfSentences.trim().split(" ");
        for (int i = 0; i < parts.length; i++) {
            this.partOfSentences.add(i, new PartOfSentence(parts[i]));
        }
    }


    public List<PartOfSentence> getSentencePart() {
        return new ArrayList<>(partOfSentences);
    }

    public void add(PartOfSentence component) {
        partOfSentences.add(component);
    }

    public void add(List<PartOfSentence> partOfSentences) {
        this.partOfSentences.addAll(partOfSentences);
    }

    public void add(int index, PartOfSentence partOfSentence) {
        partOfSentences.add(index, partOfSentence);
    }

    public void remove(PartOfSentence partOfSentence) {
        partOfSentences.remove(partOfSentence);
    }

    public int size() {
        return partOfSentences.size();
    }

    @Override
    public int compareTo(Component component) {
        if (component.getClass() == this.getClass()) {
            Sentence sentence = (Sentence) component;
            int size = this.size();
            if (size < sentence.size()) return -1;
            if (size > sentence.size()) return 1;
            return 0;
        }
        return 0;
    }


    @Override
    public String getComponent() {
        StringBuilder sb = new StringBuilder();
        for (Component partOfSentence : partOfSentences) {
            sb.append(partOfSentence.getComponent()).append(" ");
        }
        return new String(sb);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(partOfSentences, sentence.partOfSentences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partOfSentences);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "partOfSentences=" + partOfSentences;
    }


}
