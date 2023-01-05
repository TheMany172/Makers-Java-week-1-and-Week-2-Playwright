package game;

import java.util.Random;

public class WordChooser {

    public static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

    String randword;

//    public ArrayList<Character> guessedLetters;

    public WordChooser(){
        this.randword = getRandomWordFromDictionary();
    }


    public String getRandomWordFromDictionary() {
        Random rand = new Random();
        return DICTIONARY[rand.nextInt(DICTIONARY.length)];
    }

}
