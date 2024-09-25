// 322871831 Yahav Atias

package gameObjects;

import java.util.ArrayList;
import java.util.List;

import biuoop.DrawSurface;
import interfac.Sprite;

/**
 * The SpriteCollection class to store a list of sprites that will be later drawn and updated.
 */
public class SpriteCollection {
    private ArrayList<Sprite> sprites;

    /**
     * The constructor for the SpriteCollection object.
     */
    public SpriteCollection() {
        sprites = new ArrayList<>();
    }

    /**
     * Adds a sprite to the list of sprites.
     *
     * @param s The sprite to add.
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }

    /**
     * Removes a sprite from the list of sprites.
     *
     * @param s The sprite to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }

    /**
     * Updates the logic of all sprites in the list of sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites = new ArrayList<>(this.sprites);
        for (Sprite s : sprites) {
            s.timePassed();
        }
    }


    /**
     * Draws all off the sprites in the list of sprites to the screen.
     *
     * @param d The DrawSurface to draw the sprites onto.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : sprites) {
            s.drawOn(d);
        }
    }
}
