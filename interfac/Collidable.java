// 322871831 Yahav Atias

package interfac;

import attributs.Point;
import attributs.Velocity;
import geometryShapes.Ball;
import geometryShapes.Rectangle;

/**
 * An interface for objects in our game that we can collide with.
 */
public interface Collidable {
    /**
     * Return the "collision shape" of the object.
     *
     * @return the object.
     */
    Rectangle getCollisionRectangle();


    /**
     * Notify the object when it was hit with what force (velocity) and where (point).
     *
     * @param collisionPoint  The point of the collision.
     * @param currentVelocity The velocity of the object that collided.
     * @param hitter          the ball that hit the block.
     * @return The new speed after the collision based on the currentVelocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

