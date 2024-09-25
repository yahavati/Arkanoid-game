// 322871831 Yahav Atias
package gameObjects;

import geometryShapes.Ball;
import geometryShapes.Block;
import interfac.HitListener;

/**
 * A HitListener that updates a score for whenever a block is being hit.
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;

    /**
     * The constructor for the ScoreTrackingListener.
     *
     * @param scoreCounter The current score in the game.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * {@inheritDoc}
     */
    public void hitEvent(Block beingHit, Ball hitter) {

        currentScore.increase(5);
    }

    /**
     * The score of the game.
     * @return the score.
     */
    public int getValue() {
        return currentScore.getValue();
    }
}