package interfac;

import geometryShapes.Ball;
import geometryShapes.Block;

/**
 * A HitListener is an observer that is used to listen for when a hit was made between
 * a block and a ball.
 */
public interface HitListener {

    /**
     * This method is being called whenever the beingHit object is being hit
     * by the hitter Ball.
     *
     * @param beingHit The block being hit.
     * @param hitter The ball hitting that block.
     */
    void hitEvent(Block beingHit, Ball hitter);
}