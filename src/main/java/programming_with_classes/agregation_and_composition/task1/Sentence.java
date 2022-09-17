package programming_with_classes.agregation_and_composition.task1;

public class Sentence {
    private String sentence = "";

    public void addWord(Word word) {
        sentence += " " + word.getWord();
    }

    public String getSentence() {
        return sentence;
    }
}