package basics_of_software_code_development.cycles;

/*
Даны два числа. Определить цифры, входящие в запись как первого, так и второго числа.
*/

import java.util.HashSet;
import java.util.Set;

public class Task8 {
    public static void main(String[] args) {
        findSameDigits(12345691, 1234449);
    }

    public static void findSameDigits(int num1, int num2) {
        char[] number1 = String.valueOf(num1).toCharArray();
        char[] number2 = String.valueOf(num2).toCharArray();

        Set<Character> set = new HashSet<>();
        for (char c1 : number1) {
            for (char c2 : number2) {
                if (c1 == c2)
                    set.add(c1);
            }
        }
        System.out.println(set);
    }
}