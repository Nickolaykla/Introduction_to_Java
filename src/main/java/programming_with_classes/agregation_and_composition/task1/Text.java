package programming_with_classes.agregation_and_composition.task1;
/*
Создать объект класса Текст, используя классы Предложение, Слово.
Методы: дополнить текст, вывести на консоль текст, заголовок текста.
* */
public class Text {
    String header;
    String txt = "";

    public Text(Word word) {
        header = word.getWord();
    }

    public Text(Sentence sentence) {
        header = sentence.getSen();
    }

    public String getHeader() {
        return header;
    }

    public String getTxt() {
        return txt;
    }

    public void addText(Word word) {
        txt += " " + word.getWord();
    }

    public void addText(Sentence sentence) {
        txt += " " + sentence.getSen();
    }
    public void printText() {
        System.out.println(getHeader());
        System.out.println(getTxt());
    }
}