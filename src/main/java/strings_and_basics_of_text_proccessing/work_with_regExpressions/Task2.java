package strings_and_basics_of_text_proccessing.work_with_regExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его
тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
* */
public class Task2 {
    public static void main(String[] args) {
        String xml = "<notes>" + "\n\t" +
                        "<note id = '1'>" + "\n\t\t" +
                             "<to>Вася</to>" + "\n\t\t" +
                             "<from>Света</from>" + "\n\t\t" +
                             "<heading>Напоминание</heading>" + "\n\t\t" +
                             "<body>Позвони мне завтра!</body>" + "\n\t" +
                         "</note>" + "\n\t\t" +
                         "<note id = '2'>" + "\n\t\t" +
                             "<to>Петя</to>" + "\n\t\t" +
                             "<from>Маша</from>" + "\n\t\t" +
                             "<heading>Важное напоминание</heading>" + "\n\t\t" +
                             "<body/>" + "\n\t" +
                        "</note>" + "\n" +
                "</notes>";
        System.out.println(numOfOpenTegs(xml));
        System.out.println(numOfClosingTegs(xml));
        parseXML(xml);

    }

    public static int numOfOpenTegs(String s) {
        Pattern pattern = Pattern.compile("<[^/].+?[^/]>");
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    public static int numOfClosingTegs(String s) {
        Pattern pattern = Pattern.compile("</.+?>");
        Matcher matcher = pattern.matcher(s);
        int count = 0;
        while (matcher.find()) count++;
        return count;
    }

    public static boolean checkTagsCount(String s) {
        return numOfOpenTegs(s) == numOfClosingTegs(s);
    }
    public static String getCloseTag(String s) {
        if(s.isEmpty()) return null;
        Pattern pattern = Pattern.compile("\\b\\w+?\\b");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()) {
            return "</" + matcher.group() + ">";
        } else return " ";
    }

    public static void parseXML(String s) {
        Pattern pattern = Pattern.compile("<[^/].+?>");
        Matcher matcher = pattern.matcher(s);
        String open;
        String close;
        int start;
        int end;

        while (matcher.find()) {
           open = matcher.group();
           close = getCloseTag(open);

           start = s.indexOf(open);
           end = s.indexOf(close);

           if (end != -1) {
               end += close.length();
               String result = s.substring(start, end);
               System.out.println(result);

               start += open.length();
           }


        }
    }
}
