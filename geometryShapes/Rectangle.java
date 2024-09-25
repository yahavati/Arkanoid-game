// 322871831 Yahav Atias

package geometryShapes;

import attributs.Line;
import attributs.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for the Rectangle object.
 */
public class Rectangle {
    private double width;
    private double height;
    private Point upperLeft;
    private Line topLine;
    private Line rightLine;
    private Line bottomLine;
    private Line leftLine;


    /**
     * The constructor for the rectangle object.
     *
     * @param upperLeft The top left position of the rectangle on the screen.
     * @param width The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        Point xTopLine = new Point(upperLeft.getX(), upperLeft.getY());
        Point point2 = new Point((upperLeft.getX() + width), upperLeft.getY());
        topLine = new Line(xTopLine, point2);
        Point leftLine1 = new Point(upperLeft.getX(), upperLeft.getY());
        Point leftLine2 = new Point(upperLeft.getX(), height + upperLeft.getY());
        leftLine = new Line(leftLine1, leftLine2);
        Point rightLine1 = new Point(upperLeft.getX() + width, upperLeft.getY());
        Point rightLine2 = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        rightLine = new Line(rightLine1, rightLine2);
        Point bottomLine1 = new Point(upperLeft.getX(), upperLeft.getY() + height);
        Point bottomLine2 = new Point(upperLeft.getX() + width, upperLeft.getY() + height);
        bottomLine = new Line(bottomLine1, bottomLine2);
    }


    /**
     * Given a line, return all the points on the edges of the rectangle that intersect that line.
     *
     * @param line The line to check the intersections against.
     * @return A list of points for the intersection points.
     */
    public List<Point> intersectionPoints(Line line) {
        List<Point> pts = new ArrayList<>();
        Line[] bound = new Line[]{topLine, bottomLine, leftLine, rightLine};
        for (int i = 0; i < bound.length; i++) {
            if (line.isIntersecting(bound[i])) {
                Point p1 = line.intersectionWith(bound[i]);
                pts.add(p1);

            }
        }
        return pts;
    }

    /**
     * Getter for the width property.
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Getter for the height property.
     * @return The height of the rectangle.
     */
    public double getHeight() {
        return height;
    }


    /**
     * Getter for the upperLeft property.
     * @return The upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * Getter for the top line property.
     * @return The top line of the rectangle.
     */
    public Line getTopLine() {
        return topLine;
    }

    /**
     * Getter for the bottom line property.
     * @return The bottom line of the rectangle.
     */
    public Line getBottomLine() {
        return bottomLine;

    }
    /**
     * Getter for the right line property.
     * @return The right line of the rectangle.
     */

    public Line getRightLine() {
        return rightLine;

    }
    /**
     * Getter for the left line property.
     * @return The left line of the rectangle.
     */
    public Line getLeftLine() {
        return leftLine;
    }
}
