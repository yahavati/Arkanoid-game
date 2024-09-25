// 322871831 Yahav Atias
package interfac;

import biuoop.DrawSurface;

/**
 * The Animation interface. Allows us to draw each frame and to know
 * whether an animation has stopped or not.
 */
public interface Animation {

    /**
     * Does one frame of the animation.
     *
     * @param d The DrawSurface to draw the animation frame on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * Whether the animation should stop.
     *
     * @return true if the animation stopped, false otherwise.
     */
    boolean shouldStop();
}
