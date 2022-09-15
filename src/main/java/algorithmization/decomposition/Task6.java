package algorithmization.decomposition;

import java.util.Scanner;

/*
Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми.
*/
public class Task6 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите 3 числа: ");
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int num3 = in.nextInt();

            System.out.println("Являются ли числа " + num1 + " " + num2 + " " + num3 + " взаимно простыми?");
            System.out.println(check3Numbers(num1, num2, num3));
        }
    }
    // Если НОД 3 чисел = 1, то числа взаимно простые
    public static boolean check3Numbers(int num1, int num2, int num3) {
        return gcd(gcd(num1, num2), num3) == 1;
    }

    // НОД
    public static long gcd(long num1, long num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }
}