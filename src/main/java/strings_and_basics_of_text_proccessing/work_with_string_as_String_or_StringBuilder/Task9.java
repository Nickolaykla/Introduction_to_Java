package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Посчитать количество строчных(маленьких) и прописных(больших) букв во введенной строке.
Учитывать только английские буквы.
* */
public class Task9 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();
            System.out.println("Введенная строка:");
            System.out.println(s);

            System.out.println("Количество строчных букв = " + getLowerCaseCount(s));
            System.out.println("Количество прописных букв = " + getUpperCaseCount(s));
        }
    }

    public static int getLowerCaseCount(String s) {
        int count = 0;
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) count++;
        return count;
    }

    public static int getUpperCaseCount(String s) {
        int count = 0;
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) count++;
        return count;
    }
}
