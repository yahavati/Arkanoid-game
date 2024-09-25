// 322871831 Yahav Atias
package gameObjects;

import attributs.Velocity;
import geometryShapes.Block;
import interfac.LevelInformation;
import interfac.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the "Wide Easy" level information.
 */
public class WideEasy implements LevelInformation {
    private final int width;
    private final int height;
    private  WideEasyBackground wideEasyBackground;

    /**
     * Constructs a new WideEasy level information.
     *
     * @param width  The width of the level.
     * @param height The height of the level.
     */
    public WideEasy(int width, int height) {
        this.width = width;
        this.height = height;
        wideEasyBackground = new WideEasyBackground(Color.WHITE, width, height);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int numberOfBalls() {
        return 12;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initialBallVelocities = new ArrayList<>();
//        initialBallVelocities.add(new Velocity(3, 3));

        for (int i = 0; i < numberOfBalls(); i++) {
            initialBallVelocities.add(Velocity.fromAngleAndSpeed(280 + 15 * i, 3));
        }

        return initialBallVelocities;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int paddleSpeed() {
        return 15;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int paddleWidth() {
        return 400;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public String levelName() {
        return "Wide Easy";
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Sprite getBackground() {
        return wideEasyBackground;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();

        int rowY = 200; // Y-coordinate of the row
        int totalLength = 800; // Total length of the row (excluding the border size)
        int blockCount = 10; // Number of blocks in the row

        double blockWidth = (double) (totalLength - 2 * BORDER_SIZE) / blockCount;
        double blockHeight = 30; // Height of each block
        // Get a random color from the list

        for (int i = 0; i < blockCount; i++) {
            double x = BORDER_SIZE + i * blockWidth; // Calculate the x-coordinate of each block
            double y = rowY;
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            Color randomColor = new Color(r, g, b);
            // Create the block with the desired properties
            blocks.add(new Block(x, y, blockWidth, blockHeight, randomColor));

        }
        return blocks;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
