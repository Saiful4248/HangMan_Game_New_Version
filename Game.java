package HangmanGame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    static Hangman hangman = null;
    static Word word = null;
    static boolean running = true;
    static String input = null;
    static BufferedReader reader = null;
    static BufferedReader wordList = null;
    static int lev = 1;

    public static void main(String[] args) {
        initializeGame(args);

        while (running) {
            int Score = 0;
            while (running) {
                Score++;
                try {
                    input = reader.readLine();
                } catch (IOException e) {
                    // Handle the exception
                }
                if (input != null && !input.trim().equals("")) {
                    if (word.compare(input) == false)
                        hangman.next();
                    hangman.draw();
                    word.display();
                    word.winCheck(Score);
                    hangman.gameOverCheck();
                }
            }
   
            System.out.println("Do you want to play again? (yes/no)");
            try {
                input = reader.readLine();
            } catch (IOException e) {
                // Handle the exception
            }
            if (input != null && input.trim().equalsIgnoreCase("yes")) {
                lev++;
                initializeGame(args);
            } else {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }

    public static void gameOver() {
        running = false;
        hangman.draw();
        System.out.println("Sorry! You lost.");
        System.out.println("OPPS! You lost level " + lev);
        word.reveal();
    }

    public static void win(int Score) {
        running = false;
        Scoreboard s = new Scoreboard(Score);
        System.out.println("Congratulations! You won!");
        System.out.println("Congratulations! You completed level " + lev);
    }

    public static void initializeGame(String[] args) {
        if (args.length == 0) {
            try {
                wordList = new BufferedReader(new FileReader("C:\\Users\\WALTON\\OneDrive\\Desktop\\ccc.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            }
        } else {
            try {
                wordList = new BufferedReader(new FileReader(args[0]));
            } catch (FileNotFoundException e) {
                // Handle the exception
            }
        }

        hangman = new Hangman();
        word = new Word(wordList);
        reader = new BufferedReader(new InputStreamReader(System.in));
        running = true;
    }
}
