package strings_and_basics_of_text_proccessing.work_with_string_as_charArray;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
В строке найти количество чисел.
*/
public class Task4 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();

            int numbersCount = getNumsCount(s);
            System.out.println("Количество чисел в строке = " + numbersCount);
        }
    }
    public static int getNumsCount (String s) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
