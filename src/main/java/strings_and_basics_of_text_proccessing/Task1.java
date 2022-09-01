package strings_and_basics_of_text_proccessing;

import java.util.Arrays;

/*
Дан массив названий переменных в camelCase. Преобразовать названия в snake_case.
* */
public class Task1 {
    public static void main(String[] args) {
        String[] strings = {"camelCase", "caseCamel", "toCamelCase", "toCaseCamel"};
        System.out.println(toSnakeCase(strings));
    }

    public static String toSnakeCase(String[] strings) {
        String reg = "([a-z])([A-Z]+)";
        String replace = "$1_$2";
        StringBuilder sb = new StringBuilder();
        for(String str : strings) {
           sb.append(str.replaceAll(reg, replace).toLowerCase()).append(" ");
        }
        return sb.toString();
    }
}
