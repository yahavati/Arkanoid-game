// 322871831 Yahav Atias

package gameObjects;

import attributs.Line;
import attributs.Point;
import geometryShapes.Block;
import geometryShapes.Rectangle;
import interfac.Collidable;

import java.util.ArrayList;

/**
 * A class to store a collection of all of our collidables.
 */
public class GameEnvironment {
    // Stores the collidables in an array list.
    private ArrayList<Collidable> collidables;

    /**
     * Constructor for the GameEnvironment object.
     */
    public GameEnvironment() {
        collidables = new ArrayList<Collidable>();
    }


    /**
     * Add a collidable to the list of collidables.
     *
     * @param c The collidable to add.
     */
    public void addCollidable(Collidable c) {
        collidables.add(c);
    }

    /**
     * get the collidable from the list.
     * @param i the index of the collidable.
     * @return the coliidable.
     */
    public Block getCollidable(int i) {
            return (Block) collidables.get(i);
    }

    /**
     * Removes a collidable from the list of collidables.
     *
     * @param c The collidable to remove.
     */
    public void removeCollidable(Collidable c) {
        collidables.remove(c);
    }

    /**
     * If trajectory does not intersect with any of the collidables return an empty CollisionInfo object.
     * Otherwise, return the closest intersection point to the start of the line.
     *
     * @param trajectory The line to check collisions against.
     * @return The information about the collision objects.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        Point minPoint = null;
        Collidable minCol = null;
        for (Collidable col : collidables) {
            Point tmp = trajectory.closestIntersectionToStartOfLine(col.getCollisionRectangle());
            if (tmp == null) {
                continue;
            }
            if (minPoint == null) {
                minPoint = tmp;
                minCol = col;
            }
            double dist1 = tmp.distance(trajectory.start());
            double dist2 = minPoint.distance(trajectory.start());
            final double epsilon = 0.001;
            if (Math.abs(dist1 - dist2) < epsilon) {
                minPoint = tmp;
                minCol = col;
            }
        }
        if (minPoint == null) {
            return null;
        }
        return new CollisionInfo(minPoint, minCol);
    }

    /**
     * Checks if a point is inside a collidable object.
     *
     * @param pos The point to check against.
     * @return null if the point is not inside any collidable object, the object otherwise.
     */
    public Collidable getInBlock(Point pos) {
        final double x = pos.getX();
        final double y = pos.getY();
        for (Collidable c : collidables) {
            Rectangle rect = c.getCollisionRectangle();
            double left = rect.getUpperLeft().getX();
            double top = rect.getUpperLeft().getY();
            double right = left + rect.getWidth();
            double down = top + rect.getHeight();

            if (left <= x && x <= right && top <= y && y <= down) {
                return c;
            }
        }
        return null;
    }

}
