package tasks.task1.models;

import java.util.ArrayList;
import java.util.List;

public class Email {
    private String email;
    private List<String> messages = new ArrayList<>();

    public Email(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null) {
            this.email = email;
        }
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        if (messages != null) {
            this.messages = messages;
        }
    }
}