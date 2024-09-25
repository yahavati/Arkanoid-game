// 322871831 Yahav Atias
package interfac;

import attributs.Velocity;
import geometryShapes.Block;
import interfac.Sprite;

import java.util.List;
/**
 * LevelInformation stores all the info we need for a level.
 * This includes information about the paddle, balls and blocks in the level.
 */
public interface LevelInformation {

    int BORDER_SIZE = 30;
    /**
     * Getter for the number of balls in a level.
     * @return The number of balls in the level.
     */
    int numberOfBalls();
    /**
     * Getter for the initial velocity of all the balls in the level.
     *
     * @return A list of velocities corresponding to the balls in the level.
     */
    List<Velocity> initialBallVelocities();
    /**
     * Getter for the paddle's speed.
     *
     * @return The paddle's speed.
     */
    int paddleSpeed();
    /**
     * Getter for the paddle's width.
     *
     * @return The paddle's width.
     */
    int paddleWidth();
    /**
     * Getter for the level's name.
     *
     * @return A String representing the level's name.
     */
    String levelName();
    /**
     * Getter for the background sprite.
     *
     * @return A Sprite object holding the background of the level.
     */
    Sprite getBackground();
    /**
     * Getter for all the blocks in the level.
     *
     * @return A list of blocks in the level.
     */
    List<Block> blocks();
    /**
     * Number of blocks that should be removed before the level is considered to
     * be "cleared". This number should be <= blocks().size().
     *
     * @return The number of blocks to be removed before the level is cleared.
     */
    int numberOfBlocksToRemove();
}
