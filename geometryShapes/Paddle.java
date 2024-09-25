// 322871831 Yahav Atias

package geometryShapes;

import attributs.Point;
import attributs.Velocity;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import gameObjects.GameLevel;
import interfac.Collidable;
import interfac.Sprite;

import java.awt.Color;

/**
 * The class for the Paddle object which is also a sprite and a collidable.
 */
public class Paddle implements Sprite, Collidable {
    private KeyboardSensor keyboard;

    private Rectangle bounds;
    private Velocity leftSpeed;
    private Velocity rightSpeed;

    private final int screenWidth;

    private int margins;

    /**
     * The constructor for the paddle object.
     *
     * @param x        The top left X coordinate of the paddle.
     * @param y        The top left Y coordinate of the paddle.
     * @param width    The width of the paddle.
     * @param keyboard A KeyboardSensor for keyboard input detection.
     * @param screenWidth Width of the screen.
     */
    public Paddle(int x, int y, KeyboardSensor keyboard, int width, int screenWidth) {
        final int height = 20;
        bounds = new Rectangle(new Point(x, y - height), width, height);
        leftSpeed = new Velocity(-5, 0);
        rightSpeed = new Velocity(5, 0);
        this.keyboard = keyboard;
        this.screenWidth = screenWidth;
        this.margins = 0;
    }

    public void setMargins(int margins) {
        this.margins = margins;
    }

    /**
     * Moves the paddle left according to its xSpeed.
     */
    public void moveLeft() {
        if (bounds.getUpperLeft().getX() <= margins) {
            return;
        }
        attributs.Point p = leftSpeed.applyToPoint(bounds.getUpperLeft());
        bounds = new geometryShapes.Rectangle(p, bounds.getWidth(), bounds.getHeight());
    }

    /**
     * Moves the paddle right according to its xSpeed.
     */
    public void moveRight() {
        if (bounds.getUpperLeft().getX() >= screenWidth - bounds.getWidth() - margins) {
            return;
        }
        Point p = rightSpeed.applyToPoint(bounds.getUpperLeft());
        bounds = new geometryShapes.Rectangle(p, bounds.getWidth(), bounds.getHeight());
    }

    /**
     * Calculate the logic of the paddle for each update.
     */
    public void timePassed() {
        if (keyboard.isPressed("left")) {
            moveLeft();
        } else if (keyboard.isPressed("right")) {
            moveRight();
        }

    }

    /**
     * Draws the paddle onto the screen.
     *
     * @param d The DrawSurface to draw the paddle on to.
     */
    public void drawOn(DrawSurface d) {
        final int x = (int) bounds.getUpperLeft().getX();
        final int y = (int) bounds.getUpperLeft().getY();
        final int w = (int) bounds.getWidth();
        final int h = (int) bounds.getHeight();

        d.setColor(Color.yellow);
        d.fillRectangle(x, y, w, h);
        d.setColor(Color.black);
        d.drawRectangle(x, y, w, h);
    }


    /**
     * Returns the collision rectangle of the paddle.
     *
     * @return The collision rectangle of the paddle.
     */
    public Rectangle getCollisionRectangle() {
        return bounds;
    }

    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double regionWidth = bounds.getWidth() / 5;
        final double speed = 5;
        if (collisionPoint.getX() <= bounds.getUpperLeft().getX() + regionWidth) { // Region 1
            return Velocity.fromAngleAndSpeed(300, speed);    // 300 degrees
        } else if (collisionPoint.getX() <= bounds.getUpperLeft().getX() + 2 * regionWidth) { // Region 2
            return Velocity.fromAngleAndSpeed(330, speed); // 330 degrees
        } else if (collisionPoint.getX() <= bounds.getUpperLeft().getX() + 3 * regionWidth) { // Region 3
            currentVelocity.fillDy();
        } else if (collisionPoint.getX() <= bounds.getUpperLeft().getX() + 4 * regionWidth) { // Region 4
            return Velocity.fromAngleAndSpeed(30, speed); // 30 degrees
        } else if (collisionPoint.getX() <= bounds.getUpperLeft().getX() + 5 * regionWidth) { // Region 5
            return Velocity.fromAngleAndSpeed(60, speed); // 60 degrees
        }
        return currentVelocity;
    }
    /**
     * Adds the paddle to the game.
     *
     * @param g The game to add the paddle to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

}