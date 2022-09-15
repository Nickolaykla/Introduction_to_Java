package basics_of_software_code_development.cycles;

// Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера.
public class Task6 {
    public static void main(String[] args) {
        for (int i = 0; i <= Character.MAX_VALUE; i++) {
            System.out.println(i + " = " + (char) i);
        }
    }
}
