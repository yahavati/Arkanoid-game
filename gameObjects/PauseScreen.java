// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfac.Animation;

/**
 * Represents a pause screen animation.
 */
public class PauseScreen implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;


    /**
     * Constructs a new PauseScreen animation.
     *
     * @param k The keyboard sensor.
     */
    public PauseScreen(KeyboardSensor k) {
        this.keyboard = k;
        this.stop = false;
    }
    /**
     * Performs one frame of the pause screen animation.
     *
     * @param d The DrawSurface to draw the animation frame on.
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }

    /**
     * Determines whether the animation should stop or continue.
     *
     * @return true if the animation should stop, false otherwise.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}