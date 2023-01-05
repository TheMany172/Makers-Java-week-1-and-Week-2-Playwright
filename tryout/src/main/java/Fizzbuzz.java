// For: src/main/java/Fizzbuzz.java
public class Fizzbuzz {
    public String generate(Integer number1) {
        String final_list = "1";
        for (int i = 2; i <= number1; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                final_list += ", " + (i);
            } else if (i % 3 == 0 && i % 5 == 0) {
                final_list += ", FizzBuzz";
            } else if (i % 3 == 0) {
                final_list += ", Fizz";
            } else {
                final_list += ", Buzz";
            }
        }
        return final_list;
    }}

