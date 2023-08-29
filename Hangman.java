package HangmanGame;

public class Hangman {
    public int lives = 6;
    public String image =
        "   +---+\n" +
        "   |   |\n" +
        "       |\n" +
        "       |\n" +
        "       |\n" +
        "       |\n" +
        "=========\n";
    
 //private Scoreboard scoreboard;
    private Level level;

     public Hangman() {
        //scoreboard = new Scoreboard();
        level = new Level();
    }

    public void next() {
        lives--;
        switch (lives) {
            case 5:
                image =
                    "   +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "       |\n" +
                    "=========\n";
                break;
            case 4:
                image =
                    "   +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "   |   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "=========\n";
                break;
            case 3:
                image =
                    "   +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|   |\n" +
                    "       |\n" +
                    "       |\n" +
                    "=========\n";
                break;
            case 2:
                image =
                    "   +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\  |\n" +
                    "       |\n" +
                    "       |\n" +
                    "=========\n";
                break;
            case 1:
                image =
                    "   +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\  |\n" +
                    "  /    |\n" +
                    "       |\n" +
                    "=========\n";
                break;
            case 0:
                image =
                    "   +---+\n" +
                    "   |   |\n" +
                    "   O   |\n" +
                    "  /|\\  |\n" +
                    "  / \\  |\n" +
                    "       |\n" +
                    "=========\n";
            
                break;
        }
        
   gameOverCheck();
    }

    public void draw() {
        System.out.println(image);
    }

    public void gameOverCheck() {
        if (lives == 0) {
            Game.gameOver();
            level = new Level(); // Reset level on game over
        }
    }

    void next1() {
        next();
    }

    boolean isGameOver() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}  

    