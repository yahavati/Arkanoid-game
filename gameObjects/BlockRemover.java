// 322871831 Yahav Atias
package gameObjects;

import geometryShapes.Ball;
import geometryShapes.Block;
import interfac.HitListener;


/**
 * A HitListener that removes blocks whenever a ball has hit them.
 */
public class BlockRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * The constructor for the BlockRemover class.
     *
     * @param gameLevel The game to remove the blocks from.
     * @param removedBlocks Counter to know how many blocks there are left in the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter removedBlocks) {
        this.gameLevel = gameLevel;
        this.remainingBlocks = removedBlocks;
    }


    /**
     * {@inheritDoc}
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeFromGame(gameLevel);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);


    }

}
