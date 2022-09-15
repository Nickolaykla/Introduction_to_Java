package algorithmization.multidimensional_arrays;

/* В числовой матрице поменять местами два любых столбца, т.е. все элементы одного столбца поставить на
соответствующие им позиции другого, а его элементы переместить в первый. Номера столбцов вводит пользователь
с клавиатуры.
*/

import java.io.IOException;
import java.util.Scanner;

public class Task8 {
    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int[][] arr = initialArray();

        System.out.println("Исходный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("Введите номера колонок, которые нужно заменить");
        int first = IN.nextInt();
        int second = IN.nextInt();

        exchangeColumns(arr, first, second);
        IN.close();
    }
    public static int[][] initialArray() {
        System.out.println("Введите количество строк:");
        int n = IN.nextInt();
        System.out.println("Введите количество столбцов: ");
        int k = IN.nextInt();
        if (n <= 0 || k <= 0) {
            throw new IllegalArgumentException("Задан некорректный размер матрицы.");
        }
        int[][] arr = new int[n][k];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 131);
            }
        }
        return arr;
    }

    public static void exchangeColumns(int[][] arr, int first, int second) {
        if (first < 1 || second < 1 || first > arr.length || second > arr[0].length) {
            System.out.println("Введены некорректные данные.");
            throw new IllegalArgumentException();
        }
        // меняем местами колонки
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i][first-1];
            arr[i][first-1] = arr[i][second-1];
            arr[i][second-1] = temp;
        }

        System.out.println("Измененный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}