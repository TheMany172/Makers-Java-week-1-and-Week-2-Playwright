package game;

import java.util.ArrayList;

public class Masker {


    public String getMaskedWord(String word_to_guess, ArrayList<Character> guessedLetters) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < word_to_guess.length(); i++) {
            Character currentLetter = word_to_guess.charAt(i);
            if (i == 0) {
                builder.append(currentLetter);
            } else {
                if (guessedLetters.indexOf(currentLetter) != -1) {
                    builder.append(currentLetter);
                } else {
                    builder.append("_");
                }
            }
        }
        return builder.toString();
    }
}
