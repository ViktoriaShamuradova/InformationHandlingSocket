package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static String names = "Ivanov       Ivan, Russia,   Lenin  street, 51, Flat 48," +
            "email: vika@gmail.com, Kiev,+3752966219025, email: vika@mail.ru, Phone number: +375296621902";

    public static void main(String[] args) {
       String symbols = "abcdf ab7c.";
//\\w+, \\W+ , \\w{4}, \\b\\d{2}\b, \\+\\d{12}\\b, \\w+@\\w+\\.(com|ru), \\w\\S+\\w, \\D{2,}, D(AB)*
//\\Aabce, abc\\Z
       Pattern pattern = Pattern.compile("[abc][efdgh3-8]");//"AB[C-F]OP", abc[^e-g0-5],abc(e|5), "c$"
       Matcher matcher = pattern.matcher(symbols);

       while (matcher.find()){
           System.out.println(matcher.start() + " " + matcher.group());
       }
    }
}
