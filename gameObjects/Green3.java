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
 * Represents the level "Green 3".
 */
public class Green3 implements LevelInformation {
    private Green3Background green3Background;

    private final int width;
    private final int height;

    /**
     * Creates a Green3 level with the specified width and height.
     *
     * @param width  The width of the level.
     * @param height The height of the level.
     */
    public Green3(int width, int height) {
        this.width = width;
        this.height = height;
        green3Background = new Green3Background(Color.GREEN.darker(), width, height);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int numberOfBalls() {
        return 2;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> initialBallVelocities = new ArrayList<>();
        initialBallVelocities.add(Velocity.fromAngleAndSpeed(45, 5));
        initialBallVelocities.add(Velocity.fromAngleAndSpeed(-45, 5));
        return initialBallVelocities;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return green3Background;
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();

        Color[] colors = new Color[] {Color.green, Color.yellow, Color.red, Color.blue, Color.magenta};

        final int blockWidth = 45;
        final int blockHeight = 20;
        final int startY = (int) (height * 0.20f);
        final int blockCount = 11;

        final int startX = width - (blockWidth * blockCount) - BORDER_SIZE;
        for (int i = 0; i < colors.length; i++) {
            Color color = colors[i];
            int y = startY + blockHeight * i;
            for (int j = i; j < blockCount; j++) {
                Block block = new Block(startX + j * blockWidth, y, blockWidth, blockHeight, color);
                blocks.add(block);
            }
        }

        return blocks;
    }


    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
