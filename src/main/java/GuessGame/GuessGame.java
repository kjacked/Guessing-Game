package GuessGame;

import javax.swing.*;
import java.awt.*;

public class GuessGame {
    public static void main(String[] args) {
        GuessGame gg = new GuessGame();
        int secretNum = randint(1, 10);
        int tries = 0;
        int previousGuess = -1;
        boolean isCorrect = false;
        while (!isCorrect) {
            int guess = intInput("Guess the secret number between 1 and 10");
            if (guess != previousGuess) {
                tries++;
            }
            previousGuess = guess;
            isCorrect = gg.checkGuess(secretNum, guess, tries);
        }
    }


    public boolean checkGuess(int secretNum, int guess, int tries) {
        if (guess == secretNum) {
            output("You got it! It took " + tries + " tries");
            return true;
        } else if (guess > secretNum) {
            output("That's too high!");
        } else {
            output("That's too low!");
        }
        return false;
    }


    public static int randint(int min, int max) {
        return min + (int) (Math.random() * max);
    }

    // displays frame requesting and returning user's input
    public static String input(String message) {
        return JOptionPane.showInputDialog(message);
    }

    // displays frame requesting and returning user's input & converts to integer
    public static int intInput(String message) {
        String userInput = input(message);
        int numericInput = Integer.parseInt(userInput);
        return numericInput;
    }


    // displays frame with specified output message
    public static void output(String message) {
        JOptionPane.showMessageDialog(new JFrame("Output"), message);
    }
}