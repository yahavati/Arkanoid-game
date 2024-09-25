// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfac.Animation;

import java.awt.Color;
/**
 * Game over screen to notify the player that he has lost the game.
 */
public class GameOverScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private Counter score;
    /**
     * The constructor for the game over screen.
     *
     * @param score The score the player accumulated.
     */
    public GameOverScreen(Counter score) {
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
        String text = "Game Over. Your score is: " + score.getValue();

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
