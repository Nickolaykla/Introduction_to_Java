package basics_of_oop.task1;

/*
Создать объект класса Текстовый файл, используя классы Файл, Директория. Методы: создать, переименовать,
вывести на консоль содержимое, дополнить, удалить.
*/

public class TextFile {
    Directory directory;
    File file;

    public TextFile(Directory directory, File file) {
        if (directory != null && file != null) {
            this.directory = directory;
            this.file = file;
        } else throw new IllegalArgumentException("Некорректные данные");
    }

    public static TextFile createFile(Directory directory, File file) {
        if (directory != null && file != null) {
            return new TextFile(directory, file);
        } else throw new IllegalArgumentException("Заданы неверные значения");
    }

    public void renameFile(String name) {
        if (file != null && name != null) {
            file.setName(name);
        }
    }

    public void printFileContext() {
        file.getContent().forEach(System.out::println);
    }

    public void addToFile(String text) {
        if (file != null && text != null) {
            file.getContent().add(text);
        }
    }

    public void deleteFile() {
        file.getContent().clear();
        file.setName("");
    }

    @Override
    public String toString() {
        return  directory + "/" + file;
    }
}