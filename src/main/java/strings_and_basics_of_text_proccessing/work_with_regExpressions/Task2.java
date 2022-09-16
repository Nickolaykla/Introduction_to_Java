package strings_and_basics_of_text_proccessing.work_with_regExpressions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его
тип (открывающий тег, закрывающий тег, содержимое тега, тег без тела).
*/
public class Task2 {
    public static void main(String[] args) {
        String path =
                "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/" +
                "strings_and_basics_of_text_proccessing/work_with_regExpressions/task2.xml";

        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                parseXML(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void parseXML(String s) {
        String openTag = "^<\\w+>$";
        String closeTag = "^</.+>";
        String emptyTag = "^<\\w+/>$";
        String groupTag = "(<.+>)(.+)(</.+>)";
        Pattern pattern = Pattern.compile(groupTag);
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            System.out.print(matcher.group(1) + " - открывающий тег, ");
            System.out.print(matcher.group(2) + " - содержимое тега ");
            System.out.println(matcher.group(3) + " - закрывающий тег");
        }
        Pattern pattern0 = Pattern.compile("<[^?/].+=.+>");
        Matcher matcher0 = pattern0.matcher(s);

        if(matcher0.find()) {
            System.out.println(matcher0.group() + " - открывающий тег с атрибутом");
        }

        Pattern pattern1 = Pattern.compile(openTag);
        Matcher matcher1 = pattern1.matcher(s);

        if(matcher1.find()) {
            System.out.println(matcher1.group() + " открывающий тег");
        }
        Pattern pattern2 = Pattern.compile(closeTag);
        Matcher matcher2 = pattern2.matcher(s);

        if(matcher2.find()) {
            System.out.println(matcher2.group() + " закрывающий тег");
        }

        Pattern pattern3 = Pattern.compile(emptyTag);
        Matcher matcher3 = pattern3.matcher(s);

        if(matcher3.find()) {
            System.out.println(matcher3.group() + " пустой тег");
        }
    }
}