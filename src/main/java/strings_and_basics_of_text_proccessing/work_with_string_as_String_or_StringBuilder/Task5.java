package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;

/*
Подсчитать, сколько раз среди символов заданной строки встречается буква "а".
* */
public class Task5 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();

            int count = countA(s);
            System.out.println("Буква 'а' встречается " + count + " раз");
        }
    }

    public static int countA(String s) {
        s = s.toLowerCase();
        return s.length() - s.replaceAll("а", "").length();
    }
}
