// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import interfac.Sprite;

import java.awt.Color;

/**
 * Represents the background for the "Direct Hit" game level.
 */
public class DirectHitBackground implements Sprite {
    private Color color;
    private int width;
    private int height;
    /**
     * Creates a DirectHitBackground object with the specified color, width, and height.
     *
     * @param color The color of the background.
     * @param width The width of the background.
     * @param height The height of the background.
     */
    public DirectHitBackground(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }
    /**
     * Draws the background on the given drawing surface.
     *
     * @param d The drawing surface to draw on.
     */

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle(0, 0, width, height);
        drawCircle(d);
        drawLine(d);

    }
    /**
     * Draws the circles on the given drawing surface.
     *
     * @param drawSurface The drawing surface to draw on.
     */
    public void drawCircle(DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLUE);
        drawSurface.drawCircle(400, 200, 50);
        drawSurface.setColor(Color.BLUE);
        drawSurface.drawCircle(400, 200, 100);
        drawSurface.setColor(Color.BLUE);
        drawSurface.drawCircle(400, 200, 150);


    }
    /**
     * Draws the lines on the given drawing surface.
     *
     * @param drawSurface The drawing surface to draw on.
     */
    public void drawLine(DrawSurface drawSurface) {
        drawSurface.setColor(Color.BLUE);
        drawSurface.drawLine(400, 200, 250, 200);
        drawSurface.setColor(Color.BLUE);
        drawSurface.drawLine(400, 200, 550, 200);
        drawSurface.setColor(Color.BLUE);
        drawSurface.drawLine(400, 200, 400, 350);
        drawSurface.setColor(Color.BLUE);
        drawSurface.drawLine(400, 50, 400, 150);

    }

    /**
     * Updates the background. (Empty method implementation as it's not needed in this class.)
     */
    @Override
    public void timePassed() {

    }

}
