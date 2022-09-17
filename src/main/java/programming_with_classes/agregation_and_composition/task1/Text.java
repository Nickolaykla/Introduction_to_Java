package programming_with_classes.agregation_and_composition.task1;

/*
Создать объект класса Текст, используя классы Предложение, Слово.
Методы: дополнить текст, вывести на консоль текст, заголовок текста.
*/
public class Text {
    private String header;
    private String txt = "";

    public Text(String header) {
        this.header = header;
    }

    public void addToText(Sentence sentence) {
        txt += " " + sentence.getSentence();
        txt = txt.trim();
    }

    public void addToText(Word word) {
        txt += " " + word.getWord();
    }

    public String getHeader() {
        return header;
    }

    public String getTxt() {
        return txt;
    }
}