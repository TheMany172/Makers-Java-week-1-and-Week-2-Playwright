package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Reader {

    String randomLine;
    String randomLineHidden;
    ArrayList<String> movieLines = new ArrayList<>();
    String wholeList;

    public ArrayList<Character> guessedLetters = new ArrayList<>();
    public int guesses;
    String movie_to_guess;

    public Reader() throws FileNotFoundException {
        this.randomLine = "";
        this.wholeList = "";
        this.movieLines = movieLines;
        this.movie_to_guess = wordGetter();
        this.guesses = 10;
    }

    public String wordGetter() throws FileNotFoundException {
        File file1 = new File ("movies_list.txt");
        Scanner scanner1 = new Scanner(file1);


        while(scanner1.hasNextLine()) {
    //        System.out.println(scanner1.nextLine());
            String line = scanner1.nextLine();
            this.movieLines.add(Arrays.toString(line.split( "\n")));
        }
        int randomNumber1 = (int) (Math.random() * 25) + 1;
        this.randomLine = this.movieLines.get(randomNumber1);

        //WORKING HERE------------------
        StringBuilder builder1 = new StringBuilder();
        for (int i = 0; i < randomLine.length(); i++) {
            Character currentLetter = randomLine.charAt(i);
            if (i == 0 || i == 1) {
                builder1.append(currentLetter);
            } else {
                if (guessedLetters.indexOf(currentLetter) != -1) {
                    builder1.append(currentLetter);
            } else {
                builder1.append("_");
            }

        }
        }
        return builder1.toString();}


    public String movieGuesser(Character guess1, String movie_to_guess) throws FileNotFoundException {
        //WORKING HERE------------------
        StringBuilder builder1 = new StringBuilder();
        for (int i = 0; i < movie_to_guess.length(); i++) {
            Character currentLetter = movie_to_guess.charAt(i);
            if (i == 0 || i == 1) {
                builder1.append(currentLetter);
            } else {
                if (guessedLetters.indexOf(currentLetter) != -1) {
                    builder1.append(currentLetter);
                } else {
                    builder1.append("_");
                }

            }
        }
        return builder1.toString();}
}

