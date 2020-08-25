package by.epamtc.shamuradova.information_handling.server.bean.impl;

import by.epamtc.shamuradova.information_handling.server.bean.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CodeBlock extends Component {

    private List<Component> codeBlockList;

    public CodeBlock() {
        codeBlockList = new ArrayList<>();
    }


    public void add(PartOfSentence partOfSentence) {
        codeBlockList.add(partOfSentence);
    }

    public void add(int index, PartOfSentence partOfSentence) {
        codeBlockList.add(index, partOfSentence);
    }

    public void add(List<Component> components) {
        codeBlockList.addAll(components);
    }

    public void remove(PartOfSentence partOfSentence) {
        codeBlockList.remove(partOfSentence);
    }

    public int size() {
        return codeBlockList.size();
    }

    @Override
    public int compareTo(Component component) {
        if (component.getClass() == this.getClass()) {
            CodeBlock codeBlock = (CodeBlock) component;
            int size = this.size();
            if (size < codeBlock.size()) return -1;
            if (size > codeBlock.size()) return 1;
            return 0;
        }
        return 0;
    }


    @Override
    public String getComponent() {
        StringBuilder sb = new StringBuilder();
        for (Component component : codeBlockList) {
            sb.append(component.getComponent()).append(" ");
        }
        return new String(sb);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeBlock codeBlock = (CodeBlock) o;
        return Objects.equals(codeBlockList, codeBlock.codeBlockList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBlockList);
    }


}
