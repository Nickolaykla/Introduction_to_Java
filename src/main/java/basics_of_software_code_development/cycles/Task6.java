package basics_of_software_code_development.cycles;

// Вывести на экран соответствий между символами и их чесленными обозначениями в памяти компьютера.
public class Task6 {
    public static void main(String[] args) {
        for (int i = 32; i < 127; i++) {
            System.out.println(i + " " + (char) i);
        }
    }
}
