// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import interfac.Sprite;

import java.awt.Color;

/**
 * Represents the background for the "Wide Easy" level.
 */
public class WideEasyBackground implements Sprite {
    private Color color;
    private int width;
    private int height;

    /**
     * Constructs a new WideEasyBackground.
     *
     * @param color  The color of the background.
     * @param width  The width of the background.
     * @param height The height of the background.
     */
    public WideEasyBackground(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;

    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(color);
        d.fillRectangle(0, 0, width, height);
        drawCloud(d, 500, 100, 100, 100);
        drawCloud(d, 300, 100, 100, 100);
        drawSun(d);


    }

    /**
     * Draws a cloud on the given draw surface.
     *
     * @param drawSurface The draw surface to draw on.
     * @param x           The x-coordinate of the cloud's position.
     * @param y           The y-coordinate of the cloud's position.
     * @param width       The width of the cloud.
     * @param height      The height of the cloud.
     */
    private static void drawCloud(DrawSurface drawSurface, int x, int y, int width, int height) {
        // Draw the cloud shape
        // You can customize the cloud shape by drawing circles or ovals with different positions and sizes

        // Draw the main body of the cloud
        drawSurface.setColor(Color.WHITE);
        drawSurface.fillOval(x, y, width, height);
        // Draw smaller circles to add texture/details to the cloud
        drawSurface.setColor(Color.CYAN);
        drawSurface.fillOval(x + 20, y + 10, width - 20, height - 20);
        drawSurface.fillOval(x - 10, y + 20, width - 20, height - 20);
        drawSurface.fillOval(x + 30, y + 30, width - 20, height - 20);
        drawSurface.fillOval(x + 60, y + 10, width - 20, height - 20);
        drawSurface.fillOval(x + 80, y + 30, width - 20, height - 20);

    }

    /**
     * Draws the sun rays on the given draw surface.
     *
     * @param drawSurface The draw surface to draw on.
     */
    private void drawSunRays(DrawSurface drawSurface) {
        final int numOfSunRays = 75;
        final int fromX = 75;
        final int fromY = 90;
        final int y = 200;
        final int startX = 30;
        final int step = (width - 30) / numOfSunRays;

        drawSurface.setColor(Color.yellow.brighter());
        for (int i = 0; i < numOfSunRays; i++) {
            drawSurface.drawLine(fromX, fromY, startX + i * step, y);
        }
    }

    /**
     * Draws the sun on the given draw surface.
     *
     * @param drawSurface The draw surface to draw on.
     */
    public void drawSun(DrawSurface drawSurface) {
        drawSunRays(drawSurface);
        Color sunColor1 = new Color(0xF6AE2D);
        Color sunColor2 = new Color(0xF5D32C);
        Color sunColor3 = new Color(0xFFE875);
        drawSurface.setColor(sunColor1);
        int sunRadius = 50;
        int xPos = 80;
        int yPos = 90;
        drawSurface.fillCircle(xPos, yPos, (int) Math.round(sunRadius * 1.5));
        drawSurface.setColor(sunColor2);
        drawSurface.fillCircle(xPos, yPos, (int) Math.round(sunRadius * 1.25));
        drawSurface.setColor(sunColor3);
        drawSurface.fillCircle(xPos, yPos, (int) Math.round(sunRadius * 1.0));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void timePassed() {

    }

}
