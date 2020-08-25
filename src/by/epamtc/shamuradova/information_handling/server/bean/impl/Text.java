package by.epamtc.shamuradova.information_handling.server.bean.impl;

import by.epamtc.shamuradova.information_handling.server.bean.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Text extends Component {

    private List<Component> components;

    public Text(List<Component> components) {
        this.components = components;
    }

    public Text() {
        components = new ArrayList<>();
    }

    public List<Component> getComponents() {
        return new ArrayList<>(components);
    }

    public void add(Component component) {
        components.add(component);
    }


    public void add(List<Component> components) {
        this.components.addAll(components);
    }

    public void add(int index, Component component) {
        components.add(index, component);
    }

    public void remove(Component component) {
        components.remove(component);
    }

    public Component remove(int index, Component component) {
        return components.remove(index);
    }

    public int size(){
        return components.size();
    }

    @Override
    public int compareTo(Component o) {
        return 0;
    }

    @Override
    public String getComponent() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : components) {
            stringBuilder.append(component.getComponent()).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(components, text1.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }


}
