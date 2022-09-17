package basics_of_oop.task1;

public class Main {
    public static void main(String[] args) {
        Directory directory = new Directory("/home/downloads");
        File file = new File("testfile.txt");

        System.out.println("Создаём текстовый файл");
        TextFile textFile = TextFile.createFile(directory, file);
        System.out.println(textFile);

        System.out.println("\n" + "Переименовываем файл");
        textFile.renameFile("test.txt");
        System.out.println(textFile);

        System.out.println("\n" + "Добавляем содержимое:");
        textFile.addToFile("Some important content");
        textFile.addToFile("More important content");
        textFile.printFileContext();

        System.out.println("\n" + "Удаляем файл");
        textFile.deleteFile();
        System.out.println(textFile);
        textFile.printFileContext();
    }
}