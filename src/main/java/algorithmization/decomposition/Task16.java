package algorithmization.decomposition;

import java.util.Scanner;

/*
Написать программу, определяющую сумму n-значных чисел, содержащих только нечетные цифры.
Определить также, сколько четных цифр в найденной сумме.
* */
public class Task16 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите количество цифр:");
            int n = in.nextInt();
            long sum = findSum(n);

            System.out.println("Сумма равна:");
            System.out.println(sum);

            System.out.println("Количество четных цифр в сумме:");
            countEvenDigitsInSum(sum);
        }
    }
    //проверяет цифры на нечетность
    public static boolean isOddDigitsInNumber(int num) {
        int digit;
        while (num != 0) {
            digit = num % 10;
            num /= 10;
            if(digit % 2 == 0) return false;
        }
        return true;
    }
    // находим сумму в заданном диапазоне
    public static long findSum(int n) {
        long sum = 0;
        int start = (int) Math.pow(10, n-1);
        int end = (int) Math.pow(10, n) - 1;
        for (int i = start; i <= end; i++) {
            if(isOddDigitsInNumber(i)) {
                sum += i;
            }
        }
        return sum;
    }
    // Находит количество четных цифр в сумме
    public static void countEvenDigitsInSum(long sum) {
        int count = 0;
        long digit;
        while (sum != 0) {
            digit = sum % 10;
            sum /= 10;
            if (digit % 2 == 0) count++;
        }
        System.out.println(count);
    }
}
