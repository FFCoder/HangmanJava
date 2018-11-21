import java.util.ArrayList;

public class WordGuesser {
    private String word;
    private int guessedLetters = 0;
    private static WordGuesser ourInstance = new WordGuesser();
    private ArrayList<Character> wordArray;

    public static WordGuesser getInstance() {
        return ourInstance;
    }

    private WordGuesser() {
        wordArray = new ArrayList<>();
    }
    public void setWord(String word) throws Exception {
        if (this.word != null){
            throw new Exception("Error: Word is Already Set");
        }
        else {
            if (word.length() > 10){
                throw new WordTooLongException();
            }
            this.word = word;
            for (int i = 0; i < this.getWordLength(); i++){
                wordArray.add('_');

            }
        }
    }
    public int getWordLength(){return this.word.length();}

    public int getGuessedLetters() {
        return guessedLetters;
    }
    private void updateArray(char letter){
        int index = word.indexOf(letter);
        while (index >= 0){
            wordArray.set(index,letter);
            index = word.indexOf(letter, index + 1);
        }
    }
    public boolean guessLetter(char letter){
        String letterLower = Character.toString(letter).toLowerCase();
        boolean correct_guess = this.word.contains(letterLower);
        if (correct_guess){

            updateArray(letterLower.toCharArray()[0]);
        }

        return correct_guess;
    }

    public ArrayList<Character> getWordArray() {
        return wordArray;
    }
    public String getStringResult(){
        String s = "";
        for (Character c : this.getWordArray()){
            s += c;
            s+= " ";
        }
        return s;
    }
    public boolean is_finished(){
        return !wordArray.contains('_');
    }

}
