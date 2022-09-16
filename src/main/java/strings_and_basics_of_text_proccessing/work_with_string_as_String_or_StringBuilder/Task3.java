package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;

/*
Проверить, является ли заданное слово палиндромом
*/
public class Task3 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите слово:");
            String s = in.nextLine();

            System.out.println("Является ли заданное слово палиндромом? " + isPalindrome(s));
        }
    }
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}