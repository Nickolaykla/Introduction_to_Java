package strings_and_basics_of_text_proccessing;

import java.util.Scanner;

/*
В строке найти количество цифр
* */
public class Task3 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите строку:");
            String s = in.nextLine();

            int numOfDigits = getCountOfDigits(s);
            System.out.println("Количество цифр в строке = " + numOfDigits);
        }
    }
    public static int getCountOfDigits(String s) {
        int count = 0;
        char[] c = s.toCharArray();
        for (char ch : c) {
            if(Character.isDigit(ch)) count++;
        }
        return count;
    }
}
