// 322871831 Yahav Atias
package gameObjects;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import interfac.Animation;

/**
 * the class that representable to the keys.
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor keyboard;
    private boolean stop;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed;

    /**
     * Constructs a new KeyPressStoppableAnimation.
     *
     * @param sensor     The keyboard sensor.
     * @param key        The key that triggers the animation to stop.
     * @param animation  The animation to be stopped.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.keyboard = sensor;
        this.key = key;
        this.animation = animation;
        isAlreadyPressed = true;
        stop = false;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (!keyboard.isPressed(key)) {
            isAlreadyPressed = false;
        }
        animation.doOneFrame(d);
        if (keyboard.isPressed(key) && !isAlreadyPressed) {
            stop = true;
        }
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }
    // ...
    // think about the implementations of doOneFrame and shouldStop.
}