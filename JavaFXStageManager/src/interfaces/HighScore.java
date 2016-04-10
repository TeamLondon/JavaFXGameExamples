package interfaces;

import java.io.Serializable;

public interface HighScore extends Serializable {
    String getPlayerName();

    Integer getPlayerScore();
}
