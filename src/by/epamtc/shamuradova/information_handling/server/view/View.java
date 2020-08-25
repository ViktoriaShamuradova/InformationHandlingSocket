package by.epamtc.shamuradova.information_handling.server.view;

public class View {

    public static String start() {
        return "Please, enter text. \n";
    }
    public static String menu() {
        return "Please, choose an action. press: \n"
                + "1 - find sentences of the text that have the largest number of identical words \n"
                + "2 - display all sentences of a given text in ascending order of the number of words in each of them \n"
                + "3 - swap first and last word \n";
    }
}
