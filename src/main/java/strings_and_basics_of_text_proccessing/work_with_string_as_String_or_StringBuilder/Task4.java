package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

/*
С помощью функции копирования и операции конкатенации составить из частей слова
"информатика" слово "торт".
*/
public class Task4 {
    public static void main(String[] args) {
        String s = "информатика";
        s = makeTOPT(s);

        System.out.println("Результат: " + s);
    }

    public static String makeTOPT(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(s.indexOf("т")))
                .append(s.charAt(s.indexOf("о")))
                .append(s.charAt(s.indexOf("р")))
                .append(s.charAt(s.indexOf("т")));
        return sb.toString();
    }
}