package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;

/*
Вводится строка. Требуется удалить из нее повторяющиеся символы и все пробелы.
* */
public class Task7 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();

            System.out.println(removeSpacesAndRepeatableLetters(s));
        }
    }
    public static String removeSpacesAndRepeatableLetters(String s) {
        return s.replaceAll("\\s+", "")
                .chars()
                .distinct()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
