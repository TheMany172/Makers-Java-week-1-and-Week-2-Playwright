package org.example;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Guessing {
    public ArrayList<Character> guessedLetters = new ArrayList<>();
    public int guesses;
    String movie_to_guess;

    public Guessing() throws FileNotFoundException {
        this.movie_to_guess = movieGuesser();
        this.guesses = 10;
    }
    public Boolean guessLetter(Character letter) {
        if (this.movie_to_guess.indexOf(letter) != -1) {
            guessedLetters.add(letter);
//            System.out.println(this.guessedLetters);
            return true;

        } else {
            this.guesses--;
            return false;
        }
    }
    public Boolean isGameLost () {
        if (this.guesses > 0) return false;
        else {
            return true;
        }
    }

    public Boolean isGameWon () {
        if (this.movie_to_guess.contains("_")) {
            return false;
        } else {
            return true;
        }
    }






}
