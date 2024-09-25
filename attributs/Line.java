// 322871831 Yahav Atias


package attributs;

import geometryShapes.Rectangle;

import java.util.List;

/**
 * The line (segment) class. Each line segment is represented as two points.
 * Each line can return it's mid-point, check intersection with a different line, display itself
 * on a given DrawSurface.
 */
public class Line {
    private Point p1;
    private Point p2;

    // used for the line equation. Ax+By=C.
    private double a, b, c;

    /**
     * A constructor for a line object. This constructor calls in the back
     * the attributs.Line(double, double, double, double) constructor in the back.
     *
     * @param start The starting point of the line segment.
     * @param end   The end point of the line segment.
     */
    public Line(Point start, Point end) {
        this(start.getX(), start.getY(), end.getX(), end.getY());
    }

    /**
     * A constructor for a line object. This constructor makes sure that
     * p1 is the point with the smaller x coordinate.
     *
     * @param x1 The starting point x coordinate of the line segment.
     * @param y1 The starting point y coordinate of the line segment.
     * @param x2 The ending point x coordinate of the line segment.
     * @param y2 the ending point y coordinate of the line segment.
     */
    public Line(double x1, double y1, double x2, double y2) {
        p1 = new Point(x1, y1);
        p2 = new Point(x2, y2);

        a = p2.getY() - p1.getY();
        b = p1.getX() - p2.getX();
        c = a * p1.getX() + b * p1.getY();
    }


    /**
     * Calculates the length of the line segments and return it.
     *
     * @return The distance between p1 and p2.
     */
    public double length() {
        return p1.distance(p2);
    }

    /**
     * Calculates and returns the mid-point on the line segment.
     *
     * @return The mid-point of the line segment.
     */
    public Point middle() {
        double xMiddle = (p1.getX() + p2.getX()) / 2;
        double yMiddle = (p1.getY() + p2.getY()) / 2;
        return new Point(xMiddle, yMiddle);
    }

    /**
     * Accessor for the starting point of the line segment.
     *
     * @return The starting point of the line segment.
     */
    public Point start() {
        return p1;
    }

    /**
     * Accessor for the ending point of the line segment.
     *
     * @return The ending point of the line segment.
     */
    public Point end() {
        return p2;
    }

    /**
     * Checks if this line intersects with the other line.
     * Intersection includes collision.
     *
     * @param other The other line to check the intersection with.
     * @return true if the two lines intersect or collide, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        return intersectionWith(other) != null;
    }

    /**
     * Checks if a point is on this line segment. This method is mainly for inside use in the class.
     *
     * @param p The point to be checked against the line segment.
     * @return true if the point is on the line segment, false otherwise.
     */
    public  boolean isOn(Point p) {
        final double delta = 0.0001;

        final double minX = Math.min(p1.getX(), p2.getX());
        final double maxX = Math.max(p1.getX(), p2.getX());

        final double minY = Math.min(p1.getY(), p2.getY());
        final double maxY = Math.max(p1.getY(), p2.getY());

        final double x = p.getX();
        final double y = p.getY();

        // check if point is on the line equation.
        if (Math.abs(a * x + b * y - c) <= delta) {
            return minY <= y && y <= maxY && minX <= x && x <= maxX;
        }
        return false;
    }

    /**
     * Check if two lines collide with one another. This method is inside use of the class only.
     * More specifically this method is to be used mainly by the isIntersecting method.
     *
     * @param other The other line to check collision with.
     * @return point of to collide that is both on the two lines.
     */
    public Point intersectionWith(Line other) {
        // using cremer's rule for finding (x,y) intersection.
        double determinant = a * other.b - other.a * b;

        // used for checking equality in double.
        double delta = 0.00001;

        // if the lines are parallel there is no intersection.
        if (Math.abs(determinant) < delta) {
            // check if our lines intersect

            if (isOn(other.p1)) {
                return other.p1;
            }
            if (isOn(other.p2)) {
                return other.p2;
            }
            return null;
        }

        // cremer's rule.
        double x = (other.b * c - b * other.c) / determinant;
        double y = (a * other.c - other.a * c) / determinant;
        Point p = new Point(x, y);

        if (isOn(p) && other.isOn(p)) {
            return new Point(x, y);
        }
        return null;
    }

    /**
     * Checks if two line segments are equal to one another.
     * The equality is checked by comparing both the starting and ending points.
     *
     * @param other The other line to check the equality with.
     * @return true if both lines have the same start and end points.
     */
    public boolean equals(Line other) {
        return (p1.equals(other.p1) && p2.equals(other.p2))
                || (p1.equals(other.p2) && p2.equals(other.p1));
    }

    /**
     * Returns the closest intersection point of a rectangle to the start of this line.
     * @param rect The rectangle to check against/
     * @return The closest intersection point, if there is none return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> pts = rect.intersectionPoints(this);
        Point closet = null;
        if (pts == null) {
            return null;
        }

        for (Point p : pts) {
            if (closet == null || p1.distance(closet) >= p1.distance(p)) {
                closet = p;
            }
        }
        return closet;

    }


}
