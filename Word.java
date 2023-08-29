package HangmanGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class Word {
    
    char[] currentLetters;
    char[] values;

    Word(BufferedReader wordList) {

        ArrayList<String> words = new ArrayList<>();
        String word = null;
        try {
            word = wordList.readLine();
        } catch (IOException e1) {
        }

        while (word != null) {
            words.add(word);
            try {
                word = wordList.readLine();
            } catch (IOException e) {
                System.out.println("Here is exception problem");
            }
        }
        

        Random r = new Random();
        String chosenword = words.get(r.nextInt(words.size()));
        
        String value = "", category = "";
        char x[] = chosenword.toCharArray();
       
        int i = 0;
        while (i < chosenword.length() && x[i] != '-') {
            value += x[i++];
        }
        
       
        values = value.toCharArray();
        currentLetters = new char[values.length];
        System.out.println("First letter <"+values[0]+"> Last letter <"+values[i-1]+">");
        
        int ind = i;
        i++;
        
        while (i < chosenword.length()) {
            category += x[i++];
        }

        obfuscate(values, ind);
        System.out.println(category);
        System.out.println(currentLetters);
        
        
    }

    public void obfuscate(char[] letters, int ind) {
        for (int i = 0; i < ind; i++) {
            currentLetters[i] = '#';
        }
    }

    public void reveal() {
        System.out.println("The word is " + new String(values));
    }
      
    public boolean compare(String input) {
        char[] inputChar = input.toCharArray();
        boolean correctLetter = false;
        for (int i = 0; i < values.length; i++) { 
           if (inputChar[0] == values[i]) {
                currentLetters[i] = inputChar[0];
                correctLetter = true;
            }
        }
        return correctLetter;
    }

    public void display() {
        System.out.println(currentLetters);
    }

    public void winCheck(int Score) {
        if (Arrays.equals(values, currentLetters)) {
            Game.win(Score);
        }
    }

    boolean hasPlayerWonLevel() {
        return Arrays.equals(values, currentLetters);
    }

    boolean levelCompleted() {
     return Arrays.equals(values, currentLetters);
    }

    void reveal1() {
        reveal();
    }

    String getWord() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
