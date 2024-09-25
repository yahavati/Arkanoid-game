// 322871831 Yahav Atias

package geometryShapes;

import attributs.Point;
import attributs.Velocity;
import biuoop.DrawSurface;
import gameObjects.GameLevel;
import interfac.Collidable;
import interfac.HitListener;
import interfac.HitNotifier;
import interfac.Sprite;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * The class for the Block object which is also a Collidable and a Sprite.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle coliision;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     * A constructor for the block object.
     *
     * @param x      Top left X coordinate for the block.
     * @param y      Top left Y coordinate for the block.
     * @param width  The width of the block.
     * @param height The height of the block.
     * @param color  the color of the block.
     */
    public Block(double x, double y, double width, double height, Color color) {
        coliision = new Rectangle(new Point(x, y), width, height);
        this.color = color;
        hitListeners = new ArrayList<>();
    }

    /**
     * This code creates a new Block object with a specified location, width, height, and color.
     * It calls another constructor of the same class with the same parameters, except that the location
     * parameter is converted to its x and y coordinates using the getX() and getY() methods.
     *
     * @param location the upper left point of the block.
     * @param width    the width of the block.
     * @param height   the height of the block.
     * @param color    the color of the block.
     */
    public Block(Point location, double width, double height, Color color) {
        this(location.getX(), location.getY(), width, height, color);
    }

    /**
     * Adds the block to the game. Adds it to both the sprite collection and to the game environment.
     *
     * @param g The Game to add the block to.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);

    }

    /**
     * This appears to be a method named drawOn that takes a DrawSurface object as a parameter and contains code to draw
     * something on that surface based on the collision object's location and dimensions.
     *
     * @param surface the surface we draw on.
     */
    public void drawOn(DrawSurface surface) {
        final int x = (int) coliision.getUpperLeft().getX();
        final int y = (int) coliision.getUpperLeft().getY();
        final int w = (int) coliision.getWidth();
        final int h = (int) coliision.getHeight();

        surface.setColor(color);
        surface.fillRectangle(x, y, w, h);
        surface.setColor(Color.black);
        surface.drawRectangle(x, y, w, h);
    }

    @Override
    public void timePassed() {

    }

    /**
     * Accessor for the collision of the block.
     *
     * @return The collision of the block.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return coliision;
    }

    /**
     * remove the block from the game.
     * @param gameLevel the game wo remove from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }


    @Override
    public void addHitListener(HitListener hl) {
        hitListeners.add(hl);
    }


    @Override
    public void removeHitListener(HitListener hl) {
        hitListeners.remove(hl);
    }

    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * update the velocity of the ball when hit the block and notify to the lister about the hitting.
     * @param hitter the ball the hit the block
     * @param collisionPoint The point of the collision.
     * @param currentVelocity The velocity of the object that collided.
     * @return the new velocity after the hitting.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        if (coliision.getLeftLine().isOn(collisionPoint) || coliision.getRightLine().isOn(collisionPoint)) {
            dx = -dx;
        }
        if (coliision.getBottomLine().isOn(collisionPoint) || coliision.getTopLine().isOn(collisionPoint)) {
            dy = -dy;
        }
        this.notifyHit(hitter);
        return new Velocity(dx, dy);
        // ... as before.

    }

}

