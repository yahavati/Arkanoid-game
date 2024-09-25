// 322871831 Yahav Atias


package attributs;

/**
 * The attributs.Point class. Used in creating point instances where we would need
 * an x and a y. Each point can calculate its distance, mid-point and check if it is
 * equal to a different point.
 */

public class Point {
    // The x and y coordinates of a point.
    private double x;
    private double y;

    /**
     * The constructor for a point object.
     *
     * @param x The x coordinate to set.
     * @param y The y coordinate to set.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * A method to calculate the distance between this point and another point.
     *
     * @param other The other point to use in the distance calculations.
     * @return The distance between this point and the other point.
     */
    public double distance(Point other) {
        double numberRoot = (x - other.x) * (x - other.x) + (y - other.y) * (y - other.y);
        return Math.sqrt(numberRoot);
    }

    /**
     * A method to check if two points are similar.
     *
     * @param other The other point to check the equality with.
     * @return true if the points are the same, false otherwise.
     */
    public boolean equals(Point other) {
        double delta = 0.00001;
        return Math.abs(x - other.x) < delta && Math.abs(y - other.y) < delta;
    }


    /**
     * Accessor for the X coordinate.
     *
     * @return The X coordinate.
     */
    public double getX() {
        return this.x;
    }

    /**
     * Accessor for the X coordinate as an int value.
     *
     * @return The X coordinate as an int value.
     */
    public double getY() {
        return this.y;
    }
}
