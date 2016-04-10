package interfaces;

public interface Database {
    String getHighScore();

    /*
    Player getPlayer();

    String getHighScore();
    */
    void clearHighScoreInfo();

    void saveHighScoreInfo();

    void loadHighScoreInfo();

    void addHighScore(HighScore highScore);
}
