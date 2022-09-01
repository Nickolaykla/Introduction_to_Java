package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;

/*
Дан текст(строка). Найдите наибольшее количество подряд идущих пробелов в нем.
* */
public class Task1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();
            System.out.println("Введенная строка:");
            System.out.println(s);

            int maxCount = getMaxSpacesCount(s);
            System.out.println("Наибольшее количество подряд идущих пробелов = " + maxCount);
        }
    }

    public static int getMaxSpacesCount(String s) {
        int count = 0;
        int maxCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                count++;
                if(count > maxCount) {
                    maxCount = count;
                }
            } else count = 0;
        }
        return maxCount;
    }
}