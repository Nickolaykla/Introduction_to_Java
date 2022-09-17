package basics_of_oop.task1;

public class Directory {
    String directory;

    public Directory(String directory) {
        if (directory != null) {
            this.directory = directory;
        }
    }

    @Override
    public String toString() {
        return directory;
    }
}