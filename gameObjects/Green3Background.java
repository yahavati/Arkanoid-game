// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import interfac.Sprite;

import java.awt.Color;

/**
 * Represents the background of the "Green 3" level.
 */
public class Green3Background implements Sprite {
    private Color color;
    private int width;
    private int height;

    private int startX;

    /**
     * Creates a Green3Background with the specified color, width, and height.
     *
     * @param color  The color of the background.
     * @param width  The width of the background.
     * @param height The height of the background.
     */
    public Green3Background(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.startX = 150;
    }

    /**
     * Draws the base of the background.
     *
     * @param surface     The drawing surface.
     * @param yBaseTop    The top y-coordinate of the base.
     * @param width       The width of the base.
     */
    private void drawBase(DrawSurface surface, int yBaseTop, int width) {
        surface.setColor(Color.black);

        int height = surface.getHeight() - yBaseTop;
        surface.fillRectangle(startX, yBaseTop, width, height);

        int windowMarginX = 6;
        int windowCountX = 6;
        int windowWidth = (width - windowMarginX * (windowCountX + 1)) / windowCountX;

        int windowMarginY = 8;
        int windowCountY = 5;
        int windowHeight = (height + windowMarginY) / windowCountY;

        surface.setColor(Color.white);
        int x, y;
        for (int i = 0; i < windowCountY; i++) {
            y = yBaseTop + windowMarginY + (windowMarginY + windowHeight) * i;
            for (int j = 0; j < windowCountX; j++) {
                x = startX + windowMarginX + (windowMarginX + windowWidth) * j;
                surface.fillRectangle(x, y, windowWidth, windowHeight);
            }
        }
    }

    /**
     * Draws the antenna on top of the background.
     *
     * @param surface        The drawing surface.
     * @param yBaseTop       The top y-coordinate of the base.
     * @param buildingWidth  The width of the building.
     */
    private void drawAntenna(DrawSurface surface, int yBaseTop, int buildingWidth) {
        int baseAntennaW = buildingWidth / 3;
        int baseAntennaH = 20;
        int baseAntennaX = startX + baseAntennaW;
        int baseAntennaY = yBaseTop - baseAntennaH;

        int antennaW = baseAntennaW / 3;
        int antennaH = 100;
        int antennaX = baseAntennaX + antennaW;
        int antennaY = yBaseTop - baseAntennaH - antennaH;

        surface.setColor(Color.darkGray);
        surface.fillRectangle(baseAntennaX, baseAntennaY, baseAntennaW, baseAntennaH);

        surface.setColor(Color.lightGray);
        surface.fillRectangle(antennaX, antennaY, antennaW, antennaH);

        drawAntennaTop(surface, startX + buildingWidth / 2, yBaseTop - antennaH - baseAntennaH);
    }

    /**
     * Draws the top part of the antenna.
     *
     * @param surface      The drawing surface.
     * @param xAntennaTop  The x-coordinate of the top part of the antenna.
     * @param yAntennaTop  The y-coordinate of the top part of the antenna.
     */
    private void drawAntennaTop(DrawSurface surface, int xAntennaTop, int yAntennaTop) {
        surface.setColor(Color.yellow);
        surface.fillCircle(xAntennaTop, yAntennaTop, 15);
        surface.setColor(Color.orange);
        surface.fillCircle(xAntennaTop, yAntennaTop, 10);
        surface.setColor(Color.white);
        surface.fillCircle(xAntennaTop, yAntennaTop, 5);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle(0, 0, width, height);

        final int paintWidth = 150;
        final int paintHeight = (int) (height * 0.7f);
        drawBase(d, paintHeight, paintWidth);
        drawAntenna(d, paintHeight, paintWidth);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {

    }
}
