package programming_with_classes.simple_classes_and_objects.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Васильков Д.В.", 112, new int[]{7, 6, 5, 7, 6});
        Student student2 = new Student("Петров А.С.", 112, new int[]{8, 8, 9, 10, 9});
        Student student3 = new Student("Иванова Н.П.", 113, new int[]{7, 7, 8, 7, 7});
        Student student4 = new Student("Соколова С.С.", 113, new int[]{9, 10, 10, 10, 10});
        Student student5 = new Student("Меньшиков О.Е.", 111, new int[]{4, 5, 3, 5, 4});
        Student student6 = new Student("Сидоров С.И.", 111, new int[]{10, 9, 9, 9, 9});
        Student student7 = new Student("Камышов И.Л.", 112, new int[]{8, 8, 8, 7, 7});
        Student student8 = new Student("Деточкина Д.С.", 113, new int[]{6, 6, 5, 6, 6});
        Student student9 = new Student("Корнилова Е.Е.", 111, new int[]{10, 10, 9, 9, 10});
        Student student10 = new Student("Ситников Ф.Ф.", 112, new int[]{9, 9, 10, 9, 10});

        Student[] students = new Student[]{
                student1, student2, student3, student4, student5,
                student6, student7, student8, student9, student10};

        Student student = new Student();
        Student[] studsWithMaxGPA = student.getStudentsWithMaxGPA(students);
        Arrays.stream(studsWithMaxGPA).forEach(System.out::println);
    }
}