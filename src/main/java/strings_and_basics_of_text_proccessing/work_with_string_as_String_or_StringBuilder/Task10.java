package strings_and_basics_of_text_proccessing.work_with_string_as_String_or_StringBuilder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Строка Х состоит из нескольких предложений, каждое из которых кончается точкой, восклицательным
или вопросительным знаком. Определить количество предложений в строке Х.
* */
public class Task10 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            String s = in.nextLine();
            System.out.println(sentenceCount(s));
        }
    }
    public static int sentenceCount(String s) {
        Pattern pattern = Pattern.compile("[?!.]");
        Matcher matcher = pattern.matcher(s);

        int sentenceCount = 0;

        while (matcher.find()) {
            sentenceCount++;
        }
        return sentenceCount;
    }
}
