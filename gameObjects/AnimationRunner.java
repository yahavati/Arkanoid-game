// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;
import interfac.Animation;

/**
 * The AnimationRunner class handles running the animations.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;
    /**
     * The AnimationRunner constructor. This constructor calls the AnimationRunner(GUI, int).
     *
     * @param width The withe of the game
     * @param height the height of the game
     */
    public AnimationRunner(int width, int height) {
        gui = new GUI("game", width, height);
        sleeper = new Sleeper();
        framesPerSecond = 60;
    }
    /**
     * Run the specified animation.
     *
     * @param animation The animation to run.
     */

    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
    /**
     * Get the GUI object associated with the animation runner.
     *
     * @return The GUI object.
     */
    public GUI getGui() {
        return gui;
    }
    /**
     * Get the keyboard sensor from the GUI object.
     *
     * @return The keyboard sensor.
     */
    public KeyboardSensor getKeyboardSensor() {
        return gui.getKeyboardSensor();
    }

    /**
     * Get the drawing surface from the GUI object.
     *
     * @return The drawing surface.
     */
    public DrawSurface getDrawSurface() {
        return gui.getDrawSurface();
    }

}
