// 322871831 Yahav Atias

package gameObjects;

import attributs.Point;
import interfac.Collidable;
/**
 * A class to store information about a certain collision.
 */
public class CollisionInfo {

    private Point point;
    private Collidable obj;
    /**
     * The constructor to instantiate an object.
     *
     * @param point The point of the collision.
     * @param obj The collidable we collided with.
     */
    public CollisionInfo(Point point, Collidable obj) {
        this.point = point;
        this.obj = obj;
    }

    /**
     * Getter for the collision point object.
     *
     * @return The point where the collision occured.
     */
    public Point collisionPoint() {
        return point;
    }

    /**
     * Getter for the collision object.
     *
     * @return The collision object with which the collision occured.
     */
    public Collidable collisionObject() {
        return obj;
    }
}
