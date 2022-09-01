package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;

/*
В строке вставить после каждого символа 'a' символ 'b'.
* */
public class Task2 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();
            System.out.println("Введенная строка:");
            System.out.println(s);

            System.out.println("Измененная строка:");
            System.out.println(addingBafterA(s));
        }
    }
    public static String addingBafterA(String s) {
       return s.replaceAll("a", "ab");
    }
}
