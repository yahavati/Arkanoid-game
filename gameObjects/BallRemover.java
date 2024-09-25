// 322871831 Yahav Atias
package gameObjects;

import geometryShapes.Ball;
import geometryShapes.Block;
import interfac.HitListener;


/**
 * A HitListener that whenever a hit is made, removes the ball that hit the block.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;
    /**
     * The constructor for the BallRemove class.
     *
     * @param gameLevel The game to remove the balls from.
     * @param removedBlocks The counter used to know how many balls are left.
     */

    public BallRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
      hitter.removeFromGame(gameLevel);
      remainingBlocks.decrease(1);

    }
}
