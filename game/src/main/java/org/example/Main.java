package org.example;
import game.Game;
import game.WordChooser;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static Boolean player_one;
    public static Boolean game_ended;
    public static String name1;
    public static String name2;




    public static void main(String[] args) {
        System.out.println("Enter name for player 1:");
        Scanner myObj = new Scanner(System.in);
        name1 = myObj.nextLine();

        System.out.println("Enter name for player 2:");
        Scanner myObj2 = new Scanner(System.in);
        name2 = myObj2.nextLine();


        System.out.println("Welcome! Today the word to guess is:");
        Game game1 = new Game(new WordChooser());
        Game game2 = new Game(new WordChooser());
        ArrayList<Game> game_list = new ArrayList<>();
        game_list.add(game1);
        game_list.add(game2);

        player_one = true;
        game_ended = false;

        Random rand = new Random();
        int upperbound = 100;
        int int_random = rand.nextInt(upperbound);

        if (int_random % 2 == 0) {
            player_one = true;
        } else {
                player_one = false;
            }



//        game_list.forEach((G)-> {
        while (!game_ended) {
            if (player_one) {
                System.out.println(game1.getWordToGuess());
                System.out.println(game2.getWordToGuess());

                System.out.println(String.format("%s: Enter one letter to guess: (%s attempts remaining)",name1, game1.guesses));
                System.out.println(String.format("You have already guessed: %s", game1.guessedLetters));
                Scanner player1_guess = new Scanner(System.in);
                Character guess = player1_guess.nextLine().charAt(0);
                Boolean result = game1.guessLetter(guess);

                if (result == true) {
                    System.out.println("Right!");
                    if (game1.isGameWon() == true) {
                        System.out.println((String.format("Well Done... you have passed this simple test. --> %s wins", name1)));
                        game_ended = !game_ended;
                        break;
                    }
                } else {
                    System.out.println("Wrong...");

                    if (game1.isGameLost()) {
                        System.out.println((String.format("You are done... Nice try :-( --> %s loses", name1)));
                        game_ended = !game_ended;
                        break;
                    }
                }
                player_one = !player_one;
            }

            else {
                System.out.println(game1.getWordToGuess());
                System.out.println(game2.getWordToGuess());

                System.out.println(String.format("%s: Enter one letter to guess: (%s attempts remaining)",name2, game2.guesses));
                System.out.println(String.format("You have already guessed: %s", game2.guessedLetters));
                Scanner player2_guess = new Scanner(System.in);
                Character guess = player2_guess.nextLine().charAt(0);
                Boolean result = game2.guessLetter(guess);

                if (result == true) {
                    System.out.println("Right!");
                    if (game2.isGameWon() == true) {
                        System.out.println((String.format("Well Done... you have passed this simple test. --> %s wins", name2)));
                        game_ended =!game_ended;
                        break;
                    }
                } else {
                    System.out.println("Wrong...");

                    if (game2.isGameLost()) {
                        System.out.println((String.format("You are done... Nice try :-( --> %s loses", name2)));
                        game_ended =!game_ended;
                        break;
                    }
                }
                player_one = !player_one;
            }
        }
}}