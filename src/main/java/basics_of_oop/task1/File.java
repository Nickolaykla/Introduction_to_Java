package basics_of_oop.task1;

import java.util.ArrayList;
import java.util.List;

public class File {
    private String name;
    private List<String> content = new ArrayList<>();

    public File(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }
    public List<String> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return name;
    }
}