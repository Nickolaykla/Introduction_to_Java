package algorithmization.multidimensional_arrays;

import java.util.Scanner;

/*
Построить магический квадрат
*/
public class Task16 {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        printArray(initArray());
    }
    // построение магического квадрата двойного четного порядка
    public static int[][] initArray() {
        System.out.println("Введите размерность матрицы: ");
        int n = IN.nextInt();

        int[][] arr = new int[n][n];
        if (n % 4 != 0){
            throw new IllegalArgumentException("Некорректная размерность");
        }
        int start = 1;
        int end = n*n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(((i % 4 == j % 4) || ((i + j) % 4 == 3))) {
                    arr[i][j] = end;
                } else {
                    arr[i][j] = start;
                }
                end--;
                start++;
            }
        }
        return arr;
    }
    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}
