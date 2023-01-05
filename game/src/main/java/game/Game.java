package game;

import java.util.ArrayList;

public class Game {

    String word_to_guess;
    public Integer guesses;
    Masker masker1;
    public ArrayList<Character> guessedLetters = new ArrayList<>();

    public Boolean turn;

    public Game(WordChooser wChooser) {
        this.word_to_guess = wChooser.getRandomWordFromDictionary();
        this.guesses = 10;
        this.masker1 = new Masker();
        this.turn = true;
    }

    public Boolean guessLetter(Character letter) {
        if (this.word_to_guess.indexOf(letter) != -1) {
            guessedLetters.add(letter);
//            System.out.println(this.guessedLetters);
            return true;

        } else {
            this.guesses--;
            return false;
        }
    }

    public String getWordToGuess() {
        return masker1.getMaskedWord(word_to_guess, guessedLetters);
    }

    public Boolean isGameLost () {
        if (this.guesses > 0) return false;
        else {
            return true;
        }
    }

    public Boolean isGameWon () {
        if (this.getWordToGuess().contains("_")) {
            return false;
        } else {
            return true;
        }
    }
    public Integer getRemainingAttempts () {
        return this.guesses;
    }
}



//    public String getWordToGuess() {
//        String this.word_to_guess = word;
//        String hidden_word = "";
//        public static void main(String[] args)
//        {
//            String string1 = word_to_guess;
//            for (int i = 0; i < string1.length(); i++) system.out.print(string1.charAt(i));
//        }
//        return hidden_word;
//    }


//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < this.word_to_guess.length(); i++) {
//            Character currentLetter = word_to_guess.charAt(i);
//            if (i == 0) {
//                builder.append(currentLetter);
//            } else {
//                if (guessedLetters.indexOf(currentLetter) != -1) {
//                    builder.append(currentLetter);
//                } else {
//                    builder.append("_");
//                }
//            }
//        }
//        return builder.toString();



//    public String getRandomWordFromDictionary() {
//        Random rand = new Random();
//        return DICTIONARY[rand.nextInt(DICTIONARY.length)];
//    }

//    public String getWordToGuess() {
//        StringBuilder builder = new StringBuilder();
//        for (int i = 0; i < this.word_to_guess.length(); i++) {
//            Character currentLetter = word_to_guess.charAt(i);
//            if (i == 0) {
//                builder.append(currentLetter);
//            } else {
//                builder.append("_");
//            }
//        }
//        return builder.toString();
//    }
// FINAL COPY HERE MOVED TO MASKER