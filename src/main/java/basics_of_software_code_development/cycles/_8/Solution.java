package basics_of_software_code_development.cycles._8;

/*
Даны два числа. Определить цифры, входящие в запись как первого, так и второго числа.
*/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        sameDigits(543789798, 432423123);
    }
    public static void sameDigits(int num1, int num2) { //123 , 461
        char[] number1 = String.valueOf(num1).toCharArray();
        char[] number2 = String.valueOf(num2).toCharArray();

        Set<Character> set = new HashSet<>();

        for (char value1 : number1) {
            for (char value2 : number2) {
                if (value1 == value2)
                    set.add(value1);
            }
        }

        System.out.println(set);
    }
}
