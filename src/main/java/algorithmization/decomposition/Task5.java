package algorithmization.decomposition;

import java.util.Arrays;
import java.util.Scanner;

/*
Составить программу, которая в массиве А[N] находит второе по величине число
(вывести на печать число, которое меньше максимального элемента массива, но
больше всех других элементов)
*/
public class Task5 {
    public static void main(String[] args) {
        int[] arr = initArray();
        System.out.println("Изначальный массив: ");
        System.out.println(Arrays.toString(arr));

        int secondMaxNumber = getNumber(arr);
        System.out.println("Второе по величине число: " + secondMaxNumber);
    }

    public static int[] initArray() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Введите размер массива: ");
            int len = in.nextInt();
            if (len < 2) {
                throw new IllegalArgumentException("Неверная длина массива");
            }
            int[] arr = new int[len];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 - 50);
            }
            return arr;
        }
    }

    public static int getNumber(int[] arr) {
        Arrays.sort(arr);
        System.out.println("Отсортированный массив: ");
        System.out.println(Arrays.toString(arr));

        int secondMaxNum = 0;
        int tempNum = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] != tempNum) {
                secondMaxNum = arr[i];
                break;
            }
        }
        return secondMaxNum;
    }
}