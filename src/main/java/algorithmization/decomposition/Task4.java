package algorithmization.decomposition;

import java.util.Scanner;

/*
На плоскости заданы своими координатами n точек. Написать методы, определяющие,
между какими из пар точек самое большое расстояние. Координаты точек занести в массив.
* */
public class Task4 {
    public static void main(String[] args) {
        try(Scanner in = new Scanner(System.in)) {
            System.out.println("Введите количество точек: ");
            int n = in.nextInt();
            double[] x = new double[n];
            double[] y = new double[n];
            getRandomCoordinates(x, y);
            showCoordinates(x, y);

            int[] resultArray = get2CoordsWithMaxDistance(x, y);
            double maxDistance = findDistance(x[resultArray[0]], y[resultArray[0]],
                                              x[resultArray[1]], y[resultArray[1]]);

            System.out.printf("Максимальное расстояние: %.2f  \n", maxDistance);
            System.out.println("Координаты: ");
            System.out.printf("%.2f, " + "%.2f \n", x[resultArray[0]], y[resultArray[0]]);
            System.out.printf("%.2f, " + "%.2f", x[resultArray[1]], y[resultArray[1]]);
        }
    }

    public static double findDistance(double x1, double x2, double y1, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static void getRandomCoordinates(double[] x, double[] y) {
        for (int i = 0; i < x.length; i++) {
            x[i] = Math.random() * 100 - 50;
            y[i] = Math.random() * 100 - 50;
        }
    }
    public static void showCoordinates(double[] x, double[] y) {
        System.out.println("Список координат: ");
        for (int i = 0; i < x.length; i++) {
            System.out.println(x[i] + "\t" + y[i]);
        }
    }
    public static int[] get2CoordsWithMaxDistance(double[] x, double[] y) {
        double maxDistance = 0;
        double tempDistance;
        int[] result = new int[2];

        for (int i = 0; i < x.length; i++) {
            for (int j = i+1; j < x.length; j++) {
               tempDistance = findDistance(x[i], y[i], x[j], y[j]);
               if(tempDistance > maxDistance) {
                   maxDistance = tempDistance;
                   result[0] = i;
                   result[1] = j;
               }
            }
        }
        return result;
    }
}
