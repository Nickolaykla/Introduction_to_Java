package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;

/*
Вводится строка слов, разделенных пробелами. Найти самое длинное слово и вывести его на экран.
Случай, когда самых длинных слов может быть несколько, не обрабатывать.
* */
public class Task8 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();
            System.out.println("Изначальная строка:" + "\n" + s + "\n");

            System.out.println("Самое длинное слово: ");
            System.out.println(getMaxLenWord(s));
        }
    }

    public static String getMaxLenWord(String s) {
        String[] strings = s.trim().split(" ");
        String res = "";
        for (String str : strings) {
            if (str.length() > res.length())
                res = str;
        }
        return res;
    }
}
