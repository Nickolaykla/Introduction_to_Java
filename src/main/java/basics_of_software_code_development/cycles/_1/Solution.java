package basics_of_software_code_development.cycles._1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Напишите программу, где пользователь вводит любое целое положительное число. А программа
суммирует все числа от 1 до введенного пользователем числа.
* */

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = Integer.parseInt(reader.readLine());
            System.out.println(sum(i));
        }
    }

    public static int sum(int i) {
        if (i <= 0) {
            System.out.println("Введите целое положительное число.");
            throw new IllegalArgumentException();
        }
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;
    }
}
