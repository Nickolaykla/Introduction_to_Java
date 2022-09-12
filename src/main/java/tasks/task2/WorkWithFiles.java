package tasks.task2;

import java.io.*;
import java.util.Scanner;

public class WorkWithFiles {
    private static final String READ_PATH =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task2/read.txt";
    private static final String WRITE_PATH =
            "/home/nickolay/IdeaProjects/Introduction_to_Java/src/main/java/tasks/task2/write.txt";

    public static void loadFromFile() {
        try (Scanner in = new Scanner(new FileReader(READ_PATH))) {
            in.useDelimiter("(\\s*);(\\s*)");
            while (in.hasNext()) {
                Notebook.notes.add(
                        new Note(
                                in.next(),
                                new Note().getDate(),
                                in.next(),
                                in.next()
                        ));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addToFile(Note note) {
        try (FileWriter fw = new FileWriter(WRITE_PATH, true)) {
            fw.write( "Дата: " + note.getDate() + "\n" +
                    "Тема: " + note.getTopic() + "\n" +
                    "e-mail: " + note.geteMail() + "\n" +
                    "Сообщение: " + note.getMessage() + "\n\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}