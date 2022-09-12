package tasks.task2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Note {
    private String topic;
    private String date;
    private String eMail;
    private String message;

    public Note(String topic, String date, String eMail, String message) {
        if (topic != null && date != null && isEmailValid(eMail) && message != null) {
            this.topic = topic;
            this.date = date;
            this.eMail = eMail;
            this.message = message;
        } else throw new IllegalArgumentException("Некорректные данные.");
    }

    public Note() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        if (topic != null && !topic.isEmpty()) {
            this.topic = topic;
        } else throw new IllegalArgumentException("Некорректно задана тема заметки");
    }

    public String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM y, HH:mm:ss");
        this.date = dtf.format(LocalDateTime.now());
        return date;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        if (isEmailValid(eMail)) {
            this.eMail = eMail;
        } else throw new IllegalArgumentException("E-mail is not valid");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        if (message != null && !message.isEmpty()) {
            this.message = message;
        } else throw new IllegalArgumentException("Добавьте сообщение в заметку");
    }

    public static boolean isEmailValid(String email) {
        if (email != null && !email.isEmpty()) {
            return Pattern.matches(
                    "^(\\w+([-.][A-Za-z0-9]+)*){3,25}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$",
                    email);
        } else {
            System.out.println("E-mail is not valid");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Note{" +
                "topic='" + topic + '\'' +
                ", date=" + getDate() +
                ", eMail='" + eMail + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}