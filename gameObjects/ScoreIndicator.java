// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import interfac.Sprite;


/**
 * A Sprite that displays the score given to it through a counter to the screen.
 */
public class ScoreIndicator implements Sprite {
    private ScoreTrackingListener currentScore;

    private final int screenWidth;
    private final int screenHeight;

    /**
     * Constructor for the ScoreIndicator.
     *
     * @param scoreCounter The score of the game.
     * @param width the with of the game
     * @param height the height of the game.
     */
    public ScoreIndicator(ScoreTrackingListener scoreCounter, int width, int height) {
        this.currentScore = scoreCounter;
        this.screenWidth = width;
        this.screenHeight = height;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void drawOn(DrawSurface d) {
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {

    }

    /**
     * add the spite to the game.
     *
     * @param g the game we added the sprite.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);

    }

}
