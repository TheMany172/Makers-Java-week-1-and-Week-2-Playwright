package org.example;

import java.sql.SQLOutput;
import java.util.Scanner;

public class NumberGame {

    public static void main(String [] args) {
        int randomNumber = (int) (Math.random() * 100) + 1;
        System.out.println("I have randomly chosen a number between 1 and 100.");
        System.out.println("Try to guess it :-P");
//        Remove this next print to hide the answer!!
        System.out.println(randomNumber);

        Scanner scanner1 = new Scanner(System.in);
        boolean hasWon = false;
        for (int i = 10; i > 0; i--) {
            System.out.println("you have " + i + " guess(es) left. Choose again");
            int guess = scanner1.nextInt();

            if (randomNumber < guess) {
                System.out.println("It is smaller than " + guess + " guess.");
            } else if (randomNumber > guess) {
                System.out.println("It is greater than " + guess + " guess.");
            } else {
                hasWon = true;
                System.out.println("WELL DONE!");
                break;
            }
//            System.out.println("your guess was :" + guess);
        }
        if (hasWon) {
            System.out.println("You have WON!");
        }
        else {
            System.out.println("you SUUUCKK!");
            System.out.println("The number was :" + randomNumber);
        }
    }
}
