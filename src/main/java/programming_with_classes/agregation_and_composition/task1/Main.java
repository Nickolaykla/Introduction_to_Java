package programming_with_classes.agregation_and_composition.task1;

public class Main {
    public static void main(String[] args) {
        Text text = new Text("Message");

        Word word1 = new Word("Hello");
        Word word2 = new Word("how");
        Word word3 = new Word("are");
        Word word4 = new Word("you?");

        Sentence sentence = new Sentence();
        sentence.addWord(word1);
        sentence.addWord(word2);
        sentence.addWord(word3);
        sentence.addWord(word4);

        text.addToText(sentence);
        text.addToText(word1);


        System.out.println(text.getHeader());
        System.out.println(text.getTxt());
    }
}