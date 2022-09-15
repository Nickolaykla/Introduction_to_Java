package basics_of_software_code_development.cycles;

/*
Даны два числа. Определить цифры, входящие в запись как первого, так и второго числа.
*/

import java.util.*;

public class Task8 {
    public static void main(String[] args) {
        sameDigits(1233, 1233);
    }
    public static void sameDigits(int num1, int num2) {
        char[] number1 = String.valueOf(num1).toCharArray();
        char[] number2 = String.valueOf(num2).toCharArray();

        List<Character> list = new ArrayList<>();

        for (char value1 : number1) {
            for (char value2 : number2) {
                if (value1 == value2)
                    list.add(value1);
            }
        }

        System.out.println(list);
    }
}
