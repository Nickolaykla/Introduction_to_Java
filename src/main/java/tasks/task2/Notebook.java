package tasks.task2;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
Блокнот. Разработать консольное приложение, работающее с Заметками в Блокноте. Каждая заметка это:
Заметка(тема, дата создания, e-mail, сообщение).
    - В начале работы приложения данные должны считываться из файла, в конце работы - сохраняться в файл.
    - У пользователя должна быть возможность найти запись по любому параметру или по группе параметров
      (группу параметров можно определить самостоятельно), получить требуемые записи в отсортированном виде,
      найти записи, текстовое поле которой содержит определенное слово, а также добавить новую запись.
    - Особое условие: поиск, сравнение и валидацию вводимой информации осуществлять с использованием
      регулярных выражений.
    - Особое условие: проверку введенной информации на валидность должен осуществлять код, непосредственно
      добавляющий информацию.
*/

public class Notebook {
    public static List<Note> notes = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    // Поиск по теме
    public List<Note> findByTopic(String topic) {
        List<Note> result = new ArrayList<>();
        if (!topic.isEmpty()) {
            Pattern pattern = Pattern.compile("\\Q" + topic + "\\E");

            result = notes.stream()
                    .filter(note -> pattern.matcher(note.getTopic()).find())
                    .collect(Collectors.toList());

            result.forEach(WorkWithFiles::addToFile);
        }
        if (result.isEmpty()) System.out.println("По данному запросу ничего не найдено.");
        return result;
    }

    // Поиск по дате
    public List<Note> findByDate(String date) {
        List<Note> result = new ArrayList<>();
        if (!date.isEmpty()) {
            for (Note n : notes) {
                String[] split = n.getDate().split(",");
                if (split[0].equals(date))
                    result.add(n);
            }
            result = result.stream().sorted(Comparator.comparing(Note::getDate)).collect(Collectors.toList());
            result.forEach(WorkWithFiles::addToFile);

            if (result.isEmpty()) System.out.println("Заметки отсутствуют.");
        }
        return result;
    }

    // Поиск по e-mail, сортировка по Теме и добавление в файл
    public List<Note> findByEmail(String email) {
        List<Note> result = new ArrayList<>();
        if (!email.isEmpty()) {
            Pattern pattern = Pattern.compile("\\Q" + email + "\\E");
            result = notes.stream()
                    .filter(note -> pattern.matcher(note.geteMail()).find())
                    .sorted(Comparator.comparing(Note::getTopic))
                    .collect(Collectors.toList());

            result.forEach(WorkWithFiles::addToFile);
            if (result.isEmpty()) System.out.println("Заметок с заданным e-mail не найдено.");
        }
        return result;
    }

    // Поиск по слову и сортировка по Теме заметки
    public List<Note> findByWordInMessage(String word) {
        List<Note> result = new ArrayList<>();
        if (!word.isEmpty()) {
            Pattern pattern = Pattern.compile("\\Q" + word + "\\E");

            result = notes.stream()
                    .filter(note -> pattern.matcher(note.getMessage()).find())
                    .sorted(Comparator.comparing(Note::getTopic))
                    .collect(Collectors.toList());

            result.forEach(WorkWithFiles::addToFile);
            if(result.isEmpty()) System.out.println("Заметок с таким словом не найдено.");
        }
        return result;
    }

    // Поиск по теме и е-мэйлу, сортировка по теме, если темы совпадают, то по е-мэйлу
    public List<Note> findByTopicAndEmail(String topic, String email) {
        List<Note> result = new ArrayList<>();
        if (!topic.isEmpty() && !email.isEmpty()) {
            Pattern pattern1 = Pattern.compile("\\Q" + topic + "\\E");
            Pattern pattern2 = Pattern.compile("\\Q" + email + "\\E");
            result = notes.stream()
                    .filter(note -> pattern1.matcher(note.getTopic()).find() &&
                            pattern2.matcher(note.geteMail()).find())
                    .sorted(Comparator.comparing(Note::getTopic).thenComparing(Note::geteMail))
                    .collect(Collectors.toList());

            result.forEach(WorkWithFiles::addToFile);
            if(result.isEmpty()) System.out.println("По данному запросу заметок не найдено.");
        }
        return result;
    }

    // Добавление заметки
    public void addNote() {
            System.out.println("Enter topic name:");
            String topic = in.nextLine();
            String date = new Note().getDate();
            System.out.println("Enter email:");
            String email = in.nextLine();
            System.out.println("Enter message:");
            String message = in.nextLine();

            if (topic != null && Note.isEmailValid(email) && message != null) {
                Note note = new Note(topic, date, email, message);
                notes.add(note);
                System.out.println("Добавлена заметка:");
                System.out.println(note);
                WorkWithFiles.addToFile(note);
            } else {
                throw new IllegalArgumentException("При добавлении заметки введены некорректные данные.");
            }
        }

    public void viewAllNotes() {
        notes.forEach(System.out::println);
    }
}