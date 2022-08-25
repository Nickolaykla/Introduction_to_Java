package basics_of_software_code_development.line_programs._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах.
Вывести данное значение длительности в часах, минутах и секундах в следующем формате:
ННч ММмин SSс.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int sec = Integer.parseInt(reader.readLine());

            int hours = sec / 60 / 60;
            int minutes = (sec % 3600) / 60;
            int seconds = (sec % 3600) % 60;

            System.out.printf("%02d" + "ч " + "%02d" + "мин " + "%02d" + "c", hours, minutes, seconds);

        }
    }
}
