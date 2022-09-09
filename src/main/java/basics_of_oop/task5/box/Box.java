package basics_of_oop.task5.box;

public class Box {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type != null) {
            this.type = type;
        }
    }

    @Override
    public String toString() {
        return type;
    }
}