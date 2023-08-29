package HangmanGame;

class Scoreboard {
    private int score;

    Scoreboard(int Score) {
        this.score=Score;
        System.out.println("Total attempt is "+score);
    }

    void increaseScore() {
        score++;
    }

    int getScore() {
        return score;
    }
}
