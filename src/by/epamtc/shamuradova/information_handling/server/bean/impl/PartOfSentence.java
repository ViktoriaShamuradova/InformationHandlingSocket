package by.epamtc.shamuradova.information_handling.server.bean.impl;

import by.epamtc.shamuradova.information_handling.server.bean.Component;

import java.util.Objects;


public class PartOfSentence extends Component {

    private String partOfSentence;

    public PartOfSentence(String partOfSentence) {
        this.partOfSentence = partOfSentence;
    }

    public PartOfSentence() {
    }

    public String getValue() {
        return partOfSentence;
    }

    public void setValue(String partOfSentence) {
        this.partOfSentence = partOfSentence;
    }


    public String getComponent() {
        return partOfSentence + " ";
    }

    public int size() {
        return partOfSentence.length();
    }

    @Override
    public int compareTo(Component component) {
        if (component.getClass() == this.getClass()) {
            PartOfSentence partOfSentence = (PartOfSentence) component;
            int size = this.size();
            if (size < partOfSentence.size()) return -1;
            if (size > partOfSentence.size()) return 1;
            return 0;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartOfSentence that = (PartOfSentence) o;

        if (this.getValue().equals(that.getValue())) {
            return true;
        } else {
            return false;
        }

        //return Objects.equals(partOfSentence, that.partOfSentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partOfSentence);
    }

    @Override
    public String toString() {
        return "PartOfSentence{  " +
                "partOfSentence='" + partOfSentence +
                '}';
    }
}
