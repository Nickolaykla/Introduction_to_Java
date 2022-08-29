package algorithmization.multidimensional_arrays;
/* Матрицу 10х20 заполнить случайными числами от 0 до 15. Вывести на экран саму матрицу и номера
строк, в которых число 5 встречается 3 и более раз.
* */
public class Task11 {
    public static void main(String[] args) {
        int[][] arr = initArray();
        printArray(arr);
        checkFrequency5(arr);
    }

    public static int[][] initArray() {
        int[][] array = new int[10][20];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) (Math.random() * 15);
            }
        }
        return array;
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void checkFrequency5(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 5) count++;
            }
            if (count >= 3) {
                System.out.println("Номер строки, в которой 5 встречается 3 и более раз = " + (i+1));
            }
            count = 0;
        }
    }
}
