package algorithmization.decomposition;

/*
Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9
*/
public class Task7 {
    public static void main(String[] args) {
        int result = sumOfFactorials();

        System.out.println("Сумма факториалов нечетных чисел от 1 до 9:");
        System.out.println(result);
    }

    public static int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
    public static int sumOfFactorials() {
        int sum = 0;
        for (int i = 1; i <= 9; i+=2) {
            sum += getFactorial(i);
        }
        return sum;
    }
}
