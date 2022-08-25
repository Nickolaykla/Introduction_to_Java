package basics_of_software_code_development.cycles._3;

// Найти сумму квадратов первых 100 чисел.

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(100));
    }

    public static long sumOfSquares(int num) {
        long sum = 0;
        for (int i = 1; i <= num ; i++) {
            sum += Math.pow(i, 2);
        }
        return sum;
    }
}
