// 322871831 Yahav Atias
package gameObjects;

import attributs.Velocity;
import geometryShapes.Block;
import interfac.LevelInformation;
import interfac.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * this direct hit is part of the level of the game.
 */
public class DirectHit implements LevelInformation {
    private DirectHitBackground directHitBackground;
    private final int width;
    private final int height;

    /**
     * Creates a DirectHit object with the specified width and height.
     *
     * @param width The width of the DirectHit.
     * @param height The height of the DirectHit.
     */
    public DirectHit(int width, int height) {
        this.width = width;
        this.height = height;
        directHitBackground = new DirectHitBackground(Color.black, width, height);
    }


    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initialBallVelocities = new ArrayList<>();
        initialBallVelocities.add(Velocity.fromAngleAndSpeed(180, 5));
        return initialBallVelocities;
    }

    @Override
    public int paddleSpeed() {
        return 3;
    }

    @Override
    public int paddleWidth() {
        return 60;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return directHitBackground;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        blocks.add(new Block(385, 180, 30, 30, Color.red));
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }


}
