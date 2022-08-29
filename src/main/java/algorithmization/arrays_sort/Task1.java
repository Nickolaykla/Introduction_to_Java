package algorithmization.arrays_sort;

import java.util.Arrays;
import java.util.Scanner;

/*
Объединить 2 массива в один массив, включив второй массив между k-м и (k+1)-м элементами первого.
* */
public class Task1 {
    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        int[] first = initArray();
        int[] second = initArray();

        System.out.println("Введите элемент: ");
        int k = IN.nextInt();

        System.out.println("Первый массив: ");
        System.out.println(Arrays.toString(first));

        System.out.println("Второй массив: ");
        System.out.println(Arrays.toString(second));

        System.out.println("Итоговый массив: ");
        System.out.println(Arrays.toString(mergeArrays(first, second, k)));
    }

    public static int[] initArray() {
        System.out.println("Введите длину массива: ");
        int len = IN.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100 - 50);
        }
        return arr;
    }

    public static int[] mergeArrays(int[] arr1, int[] arr2, int k) {
        int[] result = new int[arr1.length+arr2.length];
        int index = k;
        for (int i = 0; i < k; i++) {
            result[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            result[k] = arr2[i];
            k++;
        }

        for (int i = k; i < result.length; i++, index++) {
            result[i] = arr1[index];
        }
        return result;
    }
}
