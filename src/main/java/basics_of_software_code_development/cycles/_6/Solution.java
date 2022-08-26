package basics_of_software_code_development.cycles._6;

// Вывести на экран соответствий между символами и их чесленными обозначениями в памяти компьютера.
public class Solution {
    public static void main(String[] args) {
        for (int i = 32; i < 127; i++) {
            System.out.println(i + " " + (char) i);
        }
    }
}
