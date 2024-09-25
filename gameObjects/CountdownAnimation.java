// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import interfac.Animation;

import java.awt.Color;

/**
 * the class of the countdown the do break and count to 3.
 */
public class CountdownAnimation implements Animation {
    private double countdownDuration;
    private int countFrom;
    private SpriteCollection gameScreen;
    private double timePerCount;
    private int currentCount;
    private boolean stop;
    private long startTime;

    /**
     * Creates a countdown animation with the specified duration, starting number, and game screen.
     *
     * @param numOfSeconds The duration of the countdown in seconds.
     * @param countFrom The number to count down from.
     * @param gameScreen The game screen to display during the countdown.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.countdownDuration = numOfSeconds * 1000; // Convert to milliseconds
        this.countFrom = countFrom;
        this.gameScreen = gameScreen;
        this.timePerCount = countdownDuration / countFrom;
        this.currentCount = countFrom;
        this.stop = false;
        this.startTime = System.currentTimeMillis(); // Initialize the start time
    }
    /**
     * Perform one frame of the countdown animation.
     * Displays the game screen and the current countdown number.
     * Updates the current countdown number based on elapsed time.
     *
     * @param d The drawing surface to draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // Display the game screen
        gameScreen.drawAllOn(d);
        // Display the current countdown number
        // Check if the countdown is finished
        d.setColor(Color.white);
        if (currentCount == 0) {
            // Display "GO" instead of the countdown number
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, "GO", 32);
        } else {
            // Display the current countdown number
            d.drawText(d.getWidth() / 2, d.getHeight() / 2, Integer.toString(currentCount), 32);
        }

        // Update the current countdown number
        double elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime >= timePerCount) {
            currentCount--;
            startTime = System.currentTimeMillis(); // Update the start time
        }

        // Check if the countdown is finished
        if (currentCount < 0) {
            stop = true;
        }
    }
    /**
     * Check if the countdown animation should stop.
     *
     * @return true if the countdown animation should stop, false otherwise.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
}