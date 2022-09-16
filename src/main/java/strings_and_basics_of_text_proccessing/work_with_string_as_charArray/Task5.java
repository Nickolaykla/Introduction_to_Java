package strings_and_basics_of_text_proccessing.work_with_string_as_charArray;

import java.util.Scanner;

/*
Удалить в строке все лишние пробелы, то есть серии подряд идущих пробелов
заменить на одиночные пробелы. Крайние пробелы в строке удалить.
*/
public class Task5 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();
            System.out.println("Введенная строка:");
            System.out.println(s);

            System.out.println("Измененная строка:");
            System.out.println(replaceSpaces(s));
        }
    }
    public static String replaceSpaces(String s) {
        return s.trim().replaceAll("\\s+", " ");
    }
}