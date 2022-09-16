package strings_and_basics_of_text_proccessing.work_with_regExpressions;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом три различных
операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать слова по длине;
отсортировать лексемы в предложении по убыванию количества вхождений заданного символа, а в случае равенства -
по алфавиту.
*/
public class Task1 {
    public static void main(String[] args) {
        String text = getText();
        System.out.println("Исходный текст:" + "\n");
        System.out.println(text);
        System.out.println("=========================================================================================");

        System.out.println("Выводим абзацы по количеству предложений:" + "\n");
        sortParagr(text);
        System.out.println("=========================================================================================");

        System.out.println("Выводим предложения с отсортированными по длине словами:" + "\n");
        System.out.println(sortWordsByLength(text));
        System.out.println("=========================================================================================");

        System.out.println("Сортируем слова в предложении по убыванию количества заданного символа:" + "\n");
        sortSentenceByLetters(getText(), 'в');
    }

    // Получаем текст из файла
    public static String getText() {
        try (BufferedReader reader = new BufferedReader(new FileReader("/home/nickolay/task1.txt"))) {
            StringBuilder sb = new StringBuilder();
            String str;
            while ((str = reader.readLine()) != null) {
                if (!str.isBlank())
                    sb.append(str).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // считаем предложения
    public static int getSentencesCount(String s) {
        Pattern pattern = Pattern.compile("[?!.]+");
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    // Переводим текст в массив абзацев, проверяем количество предложений в абзацах, сортируем по возрастанию.
    public static void sortParagr(String s) {
        String[] text = s.split("\n");

        Arrays.stream(text)
                .sorted(Comparator.comparing(Task1::getSentencesCount))
                .forEach(System.out::println);
    }

    // сортировка слов по длине в предложениях
    public static String sortWordsByLength(String s) {
        Pattern pattern = Pattern.compile("([^\n][^.!?]+[.!?])");
        Matcher matcher = pattern.matcher(s);

        List<String> startSentences = new ArrayList<>();
        while (matcher.find()) {
            startSentences.add(matcher.group()); // ищем предложения и добавляем их в лист
        }

        List<String> sortedSentences = new ArrayList<>();
        for (String str : startSentences) {
            str = str.replaceAll("\\pP", "").trim(); // удаляем все знаки
            sortedSentences.add(Arrays.stream(str.split(" ")) // разбиваем предложение и сортируем слова
                    .sorted(Comparator.comparing(String::length))
                    .collect(Collectors.toList())
                    .toString());
        }
        StringBuilder sb = new StringBuilder();
        for (String strs : sortedSentences) {
            strs = strs.replaceAll("\\pP", " ").trim();
            sb.append(strs).append("\n");
        }
        return sb.toString();
    }

    // сортировка слов по количеству вхождений заданного символа
    public static void sortSentenceByLetters(String text, char c) {
        List<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile("([^\n][^.!?]+[.!?])");
        Matcher matcher = pattern.matcher(text);

        //Добавляем в лист все найденные предложения из текста
        while (matcher.find()) sentences.add(matcher.group());

        // Создаём компаратор для сортировки слов по количеству вхождения заданной буквы
        Comparator<String> comparator = (str1, str2) -> letterCount(str2, c) - letterCount(str1, c);

        // Создаём лист и добавляем в него отсортированные предложения
        List<String> sortedSentence = new ArrayList<>();
        for (String sent : sentences) {
            sortedSentence.add(Arrays.stream(sent.split(" "))
                    .sorted(comparator.thenComparing(Comparator.naturalOrder())) // если число вхождений одинаковое
                    .collect(Collectors.toList())                                // то сортируем по алфавиту
                    .toString());
        }
        sortedSentence.forEach(System.out::println);
    }

    //считаем количество вхождения символа в слово
    public static int letterCount(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) count++;
        }
        return count;
    }
}