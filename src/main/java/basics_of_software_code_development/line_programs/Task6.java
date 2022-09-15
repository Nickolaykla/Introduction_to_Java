package basics_of_software_code_development.line_programs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Для данной области составить линейную программу, которая печатает true, если точка с
координатами (x, y) принадлежит закрашенной области, и false - в противном случае.
*/
public class Task6 {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.parseInt(reader.readLine());
            int y = Integer.parseInt(reader.readLine());

            System.out.println(isInArea(x,y));
        }
    }

    public static boolean isInArea(int x, int y) {
        return  ((x <= 4 && x >= -4) && (y >= -3 && y <= 0)) ||    //проверяем нижнюю часть графика
                 ((x <= 2 && x >= -2) && (y >= 0 && y <= 4));      // проверяем верхнюю часть графика
    }
}
