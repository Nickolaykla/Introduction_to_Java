package programming_with_classes.agregation_and_composition.task1;

public class Sentence {
    private String sen = "";

    public void addWord(Word word) {
       sen += " " + word.getWord();
    }

    public String getSen() {
        return sen;
    }
}
