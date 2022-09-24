package algorithmization.multidimensional_arrays;

import java.util.Scanner;

/*
Построить магический квадрат
*/

public class Task16 {
    public static void main(String[] args) {
        System.out.println("Введите размерность матрицы, начиная с 3: ");
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            if (n < 3) {
                throw new IllegalArgumentException("Некорректная размерность");
            } else {
                if (n % 2 != 0) {
                    printArray(createOddMagicSquare(n));
                } else if (n % 4 == 0) {
                    printArray(createDoubleEvenMagicSquare(n));

                } else printArray(createSingleEvenMagicSquare(n));
            }
        }
    }

    // double even order magic square
    public static int[][] createDoubleEvenMagicSquare(int n) {
        int[][] arr = new int[n][n];
        int start = 1;
        int end = n * n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (((i % 4 == j % 4) || ((i + j) % 4 == 3))) {
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

    // odd magic square
    public static int[][] createOddMagicSquare(int n) {
        int[][] arr = new int[n][n];
        int midInd = n / 2;
        int line = 0;
        for (int number = 1; number <= n * n; number++) {

            arr[line][midInd] = number;

            if (number % n == 0) {
                line++;
            } else {
                line--;
                midInd++;
                if (line < 0) line = n - 1;
                if (midInd > n - 1) midInd = 0;
            }
        }
        return arr;
    }

    // single even order magic square
    public static int[][] createSingleEvenMagicSquare(int n) {
        int arrSize = n * n;
        int mid = n / 2;
        int subArrSize = arrSize / 4;

        int[][] subArr = createOddMagicSquare(mid);
        int[] quadFactors = {0, 2, 3, 1};
        int[][] resArr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int quadr = (i / mid) * 2 + (j / mid);
                resArr[i][j] = subArr[i % mid][j % mid];
                resArr[i][j] += quadFactors[quadr] * subArrSize;
            }
        }

        int nColomsLeft = mid / 2;
        int nColomsRight = nColomsLeft - 1;

        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < n; j++) {
                if (j < nColomsLeft || j >= n - nColomsRight
                        || (j == nColomsLeft && i == nColomsLeft)) {
                    if (j == 0 && i == nColomsLeft)
                        continue;

                    int temp = resArr[i][j];
                    resArr[i][j] = resArr[i + mid][j];
                    resArr[i + mid][j] = temp;
                }
            }

        }
        return resArr;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}