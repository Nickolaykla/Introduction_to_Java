package algorithmization.arrays_sort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/*
Даны дроби p1/q1, p2/q2...pn/qn(p, q - натуральные). Составить программу, которая
приводит эти дроби к общему знаменателю и упорядочивает их в порядке возрастания.
* */
public class Task8 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите диапазон значений 1 массива(числители): ");
            int start1 = in.nextInt();
            int end1 = in.nextInt();

            System.out.println("Введите диапазон значений 2 массива(знаменатели): ");
            int start2 = in.nextInt();
            int end2 = in.nextInt();

            int[] numer = initArray(start1, end1);
            int[] denom = initArray(start2, end2);
            if (numer.length != denom.length) {
                System.out.println("Массивы не совпадают по длине");
                throw new IllegalArgumentException();
            }
            System.out.println("Массив числителей: ");
            System.out.println(Arrays.toString(numer));
            System.out.println("Массив знаменателей: ");
            System.out.println(Arrays.toString(denom));

            System.out.println("Общий знаменатель равен: ");
            int commonDenom = lcm(denom);
            System.out.println(commonDenom);

            numeratorToDenom(numer, denom, commonDenom);
        }
    }

    // создаем массив натуральных чисел в заданном промежутке
    public static int[] initArray(int start, int end) {
        return IntStream.rangeClosed(start, end).toArray();
    }

    //НОД
    public static int gcd(int num1, int num2) {
        return num2 == 0 ? num1 : gcd(num2, num1 % num2);
    }

    //НОК
    public static int lcm(int[] arr) {
        int nok = arr[0];
        for (int i = 1; i < arr.length; i++) {
            nok = (nok * arr[i]) / gcd(nok, arr[i]);
        }
        return nok;
    }

    // приводим числители к знаменателю
    public static void numeratorToDenom(int[] numerator, int[] denominator, int denomCommon) {
        for (int i = 0; i < numerator.length; i++) {
            numerator[i] = (denomCommon / denominator[i]) * numerator[i];
        }
        System.out.println("После приведения числители равны: ");
        System.out.println(Arrays.toString(numerator));
    }
}

