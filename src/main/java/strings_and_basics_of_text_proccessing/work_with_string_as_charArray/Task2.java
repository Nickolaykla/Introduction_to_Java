package strings_and_basics_of_text_proccessing.work_with_string_as_charArray;
/*
Замените все вхождения 'word' на 'letter'
*/
public class Task2 {
    public static void main(String[] args) {
        String test = "This is a test word. We should change 'word' to 'letter'. Word, world, wrd.";
        System.out.println(replaceAll(test));
    }
    public static String replaceAll(String s) {
        return s.replaceAll("word", "letter");
    }
}