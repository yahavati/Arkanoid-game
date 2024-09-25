// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import interfac.Sprite;

import java.awt.Color;

/**
 * Represents a level title.
 */
public class LevelTitle implements Sprite {

    private final int width;
    private final int height;
    private final Counter counter;
    private final String title;

    /**
     * Constructs a new LevelTitle.
     *
     * @param width   The width of the title.
     * @param height  The height of the title.
     * @param counter The counter associated with the level.
     * @param title   The title of the level.
     */
    public LevelTitle(int width, int height, Counter counter, String title) {
        this.width = width;
        this.height = height;
        this.counter = counter;
        this.title = title;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, width, height);
        d.setColor(Color.black);
        d.drawRectangle(0, 0, width, height);
        d.setColor(Color.black);
        d.drawText(600, 15, "Level Name: " + title, 15);
        d.drawText(400, 15, "Score: " + counter.getValue(), 15);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {

    }
}
