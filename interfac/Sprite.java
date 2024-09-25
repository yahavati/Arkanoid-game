// 322871831 Yahav Atias

package interfac;

import biuoop.DrawSurface;
/**
 * The Sprite interface for when objects need to be drawn to the screen and have logic tied into them.
 */
public interface Sprite {
    /**
     * Draws the object onto the screen.
     *
     * @param d The surface to draw the object on.
     */
    void drawOn(DrawSurface d);


    /**
     * Calculates the logic of the object.
     */
    void timePassed();
}