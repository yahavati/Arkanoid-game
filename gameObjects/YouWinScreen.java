// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfac.Animation;

import java.awt.Color;

/**
 * Represents the screen displayed when the player wins the game.
 */
public class YouWinScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;

    /**
     * Creates a new instance of the YouWinScreen class.
     *
     * @param score the player's score counter
     */
    public YouWinScreen(Counter score) {
        this.stop = false;
        this.score = score;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void doOneFrame(DrawSurface surface) {
        surface.setColor(Color.black);
        surface.fillRectangle(0, 0, surface.getWidth(), surface.getHeight());

        int fontSize = 32;
        String text = "You Win. Your score is: " + score.getValue();

        surface.setColor(Color.white);
        surface.drawText(surface.getWidth() / 4, (surface.getHeight() - 32) / 2, text, fontSize);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}


