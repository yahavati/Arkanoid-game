// 322871831 Yahav Atias
package geometryShapes;

import attributs.Line;
import attributs.Point;
import attributs.Velocity;
import biuoop.DrawSurface;
import gameObjects.CollisionInfo;
import gameObjects.GameLevel;
import gameObjects.GameEnvironment;
import interfac.Collidable;
import interfac.Sprite;

import java.awt.Color;

/**
 * The geometryShapes.Ball class which is used to create a circle with a certain color, size and position.
 * We can also set its velocity to make it move every update. We can also enclose the ball inside
 * a square and make it bounce of the walls of said enclosure.
 */
public class Ball implements Sprite {
    // The min bounder of the ball in x
    private int minX;
    // The
    private int maxX;
    private int minY;
    private int maxY;
    // The position of the ball.
    private Point center;
    // The size of the ball.
    private int size;
    // The color of the ball, used when drawing.
    private Color color;
    // The speed of the ball.
    private Velocity vel;

    private GameEnvironment environment;

    /**
     * The constructor for the ball clas.
     * Automatically sets the bounds to be equal. When the bounds are equal we assume there are no bounds.
     *
     * @param center      The starting position for the ball.
     * @param r           The size of the ball.
     * @param color       The color with which to draw the ball to the screen.
     * @param environment asd
     */
    public Ball(Point center, int r, Color color, GameEnvironment environment) {
        this(center.getX(), center.getY(), r, color);
        this.environment = environment;
    }

    /**
     * The constructor for the ball clas.
     * Automatically sets the bounds to be equal. When the bounds are equal we assume there are no bounds.
     *
     * @param x     The starting position for the ball.
     * @param size  The size of the ball.
     * @param color The color with which to draw the ball to the screen.
     * @param y     The starting position for the ball.
     */
    public Ball(double x, double y, int size, Color color) {
        this.center = new Point(x, y);
        this.size = size;
        this.color = color;
        this.vel = new Velocity(0, 0);
        // default values for boundaries.
        setBounder(0, 0, 0, 0);
    }

    /**
     * This class is for setting the bounds of the ball,so each ball know the own bounds.
     *
     * @param minX the min value of the coordinate x.
     * @param minY the min value of the coordinate y.
     * @param maxX the max value of the coordinate x.
     * @param maxY the max value of the coordinate x.
     */
    public void setBounder(int minX, int minY, int maxX, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    /**
     * Accessor for the min x coordinate of the ball.
     *
     * @return The min x coordinate of the ball.
     */
    public int getMinX() {
        return this.minX;
    }

    /**
     * remove the ball from the game.
     * @param gameLevel the game wo removed the ball from.
     */
    public void removeFromGame(GameLevel gameLevel) {
        gameLevel.removeSprite(this);
    }

    /**
     * Accessor for the max y coordinate of the ball.
     *
     * @return The max y coordinate of the ball.
     */
    public int getMaxX() {
        return this.maxX;
    }

    /**
     * Accessor for the min y coordinate of the ball.
     *
     * @return The min y coordinate of the ball.
     */
    public int getMinY() {
        return this.minY;
    }

    /**
     * Accessor for the max x coordinate of the ball.
     *
     * @return The max x coordinate of the ball.
     */
    public int getMaxY() {
        return this.maxY;
    }

    /**
     * Accessor for the X coordinate of the ball.
     *
     * @return The X coordinate of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * Accessor for the Y coordinate of the ball.
     *
     * @return The Y coordinate of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * Accessor for the size of the ball.
     *
     * @return The size of the ball. The size is the radius of the ball.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Accessor for the color of the ball.
     *
     * @return The color of the ball as a java.awt.Color instance.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * This method is realisable to  draw the ball.
     * Draw the ball on the given DrawSurface
     *
     * @param surface the surface of the dr
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(color);
        surface.fillCircle(getX(), getY(), size);

        surface.setColor(Color.black);
        surface.drawCircle(getX(), getY(), size);

        surface.setColor(Color.red);
        surface.fillCircle(getX(), getY(), 1);

    }

    @Override
    public void timePassed() {
        Collidable collidable = environment.getInBlock(center);
        while (collidable != null) {
            unstuck(collidable);
            collidable = environment.getInBlock(center);
        }
        moveOneStep();
    }

    /**
     * Mutator for the velocity of the ball.
     *
     * @param v The new velocity to set to the ball.
     */
    public void setVelocity(Velocity v) {
        vel = v;
    }

    /**
     * Mutator for the velocity of the ball.
     *
     * @param dx The velocity on the X axis.
     * @param dy The velocity on the Y axis.
     */
    public void setVelocity(double dx, double dy) {
        vel = new Velocity(dx, dy);
    }

    /**
     * Accessor for the velocity of the ball.
     *
     * @return The velocity of the ball as a attributs.Velocity object.
     */
    public Velocity getVelocity() {
        return vel;
    }

    /**
     * A function to update the position of the ball based on its velocity.
     * This function also does bound checks to make sure the ball is inside the specified
     * bound (which can be set using the setBounds function).
     * If both the lower and the upper bounds are equal then the function will not do any
     * bound checks.
     */
    public void moveOneStep() {
        Line trajectory = new Line(center, vel.applyToPoint(center));
        CollisionInfo info = environment.getClosestCollision(trajectory);

        if (info == null) {
            center = vel.applyToPoint(center);
            return;
        }

        Point colPoint = info.collisionPoint();
        Velocity afterVel = info.collisionObject().hit(this, colPoint, vel);

        double afterX = colPoint.getX();
        double afterY = colPoint.getY();

        if (center.getX() <= afterX) {
            afterX -= 1;
        } else {
            afterX += 1;
        }

        if (center.getY() <= afterY) {
            afterY -= 1;
        } else {
            afterY += 1;
        }

        final double threshold = 100;
        afterX = Math.round(afterX * threshold) / threshold;
        afterY = Math.round(afterY * threshold) / threshold;

        center = new Point(afterX, afterY);
        vel = afterVel;
    }


    /**
     * Adds this ball to the game as a sprite.
     *
     * @param g A Game instance to add the ball to.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }


    /**
     * Try to release the ball if it is inside a collidable.
     * This might happen because doubles are not precise and the ball might get stuck inside a colllidable.
     *
     * @param c The collidable the ball is stuck inside.
     */
    private void unstuck(Collidable c) {
        Rectangle rect = c.getCollisionRectangle();
        final double left = rect.getUpperLeft().getX();
        final double top = rect.getUpperLeft().getY();
        final double right = left + rect.getWidth();
        final double down = top + rect.getHeight();

        double x = center.getX();
        double y = center.getY();

        double dx = vel.getDx();
        double dy = vel.getDy();

        if (rect.getWidth() <= rect.getHeight()) {
            if (center.distance(new Point(left, y)) < center.distance(new Point(right, y))) {
                x = left - size - 1;
                dx = -Math.abs(dx);
            } else {
                x = right + size + 1;
                dx = Math.abs(dx);
            }
        } else {
            if (center.distance(new Point(x, top)) < center.distance(new Point(x, down))) {
                y = top - size - 1;
                dy = -Math.abs(dy);
            } else {
                y = down + size + 1;
                dy = Math.abs(dy);
            }
        }

        center = new Point(x, y);
        vel = new Velocity(dx, dy);
    }

}
