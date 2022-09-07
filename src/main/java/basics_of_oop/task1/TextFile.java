package basics_of_oop.task1;

import java.io.File;
import java.nio.file.Files;

/*
Создать объект класса Текстовый Файл, используя классы Файл, Директория.
Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
*/
public class TextFile {
    private Directory directory;
    private SimpleFile simpleFile;
    private File file;

    public TextFile(File file) {
        this.file = file;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public SimpleFile getFile() {
        return simpleFile;
    }

    public void setSimpleFile(SimpleFile simpleFile) {
        this.simpleFile = simpleFile;
    }
}
