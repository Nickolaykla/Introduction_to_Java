package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;

/*
Из заданной строки получить новую, повторив каждый символ дважды.
* */
public class Task6 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();

            System.out.println(repeatLetters(s));
        }
    }
    public static String repeatLetters(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append(s.charAt(i));
        }
       return sb.toString();
    }
}
