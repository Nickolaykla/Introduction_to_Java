package basics_of_software_code_development.cycles._7;

/*
Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
m и n вводятся с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int m = Integer.parseInt(reader.readLine());
            int n = Integer.parseInt(reader.readLine());
            allDividers(m, n);
        }
    }

    public static void allDividers(int m, int n) {
        if (m <= 3 || n <= 3) return;
        for (int i = m; i <= n; i++) {
            if(!isPrime(i)) {
                System.out.print("Делители " + i + ": ");
            } else System.out.print(i + " простое число");

            for (int j = 2; j <= i / 2; j++) {
                if ((i % j) == 0) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }
    // проверка простое ли число
    public static boolean isPrime(int i) {
        for (int j = 2; j <= i / 2; j++) {
            if ((i % j) == 0) return false;
        }
        return true;
    }
}
