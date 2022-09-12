package tasks.task2;

import static tasks.task2.Notebook.in;

public class Main {
    public static void main(String[] args) {
        WorkWithFiles.loadFromFile();

        System.out.println("Нажмите '0' для выхода");
        System.out.println("Нажмите '1' для просмотра заметок");
        System.out.println("Нажмите '2' для добавления заметки");
        System.out.println("Нажмите '3' для поиска заметки по Теме");
        System.out.println("Нажмите '4' для поиска заметки по Дате");
        System.out.println("Нажмите '5' для поиска заметки по E-mail");
        System.out.println("Нажмите '6' для поиска заметки по Слову");
        System.out.println("Нажмите '7' для поиска заметки по Теме и E-mail");

        int num = -1;
        while (num != 0) {
            num = Integer.parseInt(in.nextLine());
            switch (num) {
                case 0:
                    System.out.println("Всего хорошего!");
                    break;
                case 1:
                    Notebook.viewAllNotes();
                    break;
                case 2:
                    Notebook.addNote();
                    break;
                case 3:
                    System.out.println("Введите Тему заметки:");
                    Notebook.findByTopic(in.nextLine())
                            .forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Введите Дату, пример: 1 октября 2020:");
                    Notebook.findByDate(in.nextLine())
                            .forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Введите e-mail или его часть:");
                    Notebook.findByEmail(in.nextLine())
                            .forEach(System.out::println);
                    break;
                case 6:
                    System.out.println("Введите слово для поиска:");
                    Notebook.findByWordInMessage(in.nextLine())
                            .forEach(System.out::println);
                    break;
                case 7:
                    System.out.println("Введите Тему и E-mail:");
                    Notebook.findByTopicAndEmail(in.nextLine(), in.nextLine())
                            .forEach(System.out::println);
                    break;
                default:
                    throw new IllegalArgumentException("Ошибка ввода.");
            }
        }
        in.close();
    }
}

