package programming_with_classes.agregation_and_composition.task1;

public class Main {
    public static void main(String[] args) {
        Word word1 = new Word("hi");
        Sentence sentence1 = new Sentence();
        sentence1.addWord(word1);

        System.out.println(sentence1.getSen());

        Word word2 = new Word("hello");
        Word word3 = new Word("hey");

        Text text = new Text(sentence1);
        text.addText(word2);
        text.addText(word3);

        text.printText();
    }
}
