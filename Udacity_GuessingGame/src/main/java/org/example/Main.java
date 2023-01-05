package org.example;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static Boolean game_ended;

    public Main() throws FileNotFoundException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        game_ended = false;

        Reader reader1 = new Reader();
        Guessing game1 = new Guessing();
        System.out.println("Hello, and welcome to this movie guesser game :-)");

        while (!game_ended) {
            System.out.println("Here is the hidden movie to guess: ");
            System.out.println(game1.movie_to_guess);

            Scanner player_guess = new Scanner(System.in);
            Character guess = player_guess.nextLine().charAt(0);

            Boolean result = game1.guessLetter(guess);
            System.out.println(String.format("You have %s guesses remaining", game1.guesses));
            System.out.println(String.format("You have already guessed the following letters: ", reader1.guessedLetters));

            if (result == true) {
                System.out.println("Right!");
                reader1.guessedLetters.add(guess);
            } else {
                System.out.println("Wrong...");
                reader1.guessedLetters.add(guess);
            }
        }
    }
}