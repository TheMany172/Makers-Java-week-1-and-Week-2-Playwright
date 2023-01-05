package org.example;

public class App {

    public static void main(String[] args) {
        Fizzbuzz fizzbuzz = new Fizzbuzz();

        for (int i = 1 ; i < 100 ; i ++) {
            System.out.println(fizzbuzz.play(i));
        }}
    public static class Fizzbuzz {
        public String play(Integer number) {
            Integer otherNumber = number - 50;

            if (this.isDivisibleBy(15, number)) {
                return "FizzBuzz";
            } else if (this.isDivisibleBy(5, number)) {
                return "Buzz";
            } else if (this.isDivisibleBy(3, number)) {
                return "Fizz";
            } else {
                return number.toString();
            }
        }

        public Boolean isDivisibleBy(Integer divisor, Integer number) {
            return number % divisor == 0;
        }
    }


    }
