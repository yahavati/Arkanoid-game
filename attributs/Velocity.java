// 322871831 Yahav Atias

package attributs;

/**
 * The attributs.Velocity class can be used to store the direction in which an object is going.
 * This class can apply its speed to a given point. We can also create a attributs.Velocity from
 * a direction and a scalar.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Constructor for the attributs.Velocity class. This constructor assigns the values of the speed in each
     * direction to its members.
     *
     * @param dx The speed in the x-axis.
     * @param dy The speed in the y-axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * This metod is for computing the speed of the ball, by using the sin and cos function.
     * @param angle the angle we converd to the speed.
     * @param speed the speed that we need for the ball .
     * @return the velocity that we cumulated.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double dx;
        double dy;
        angle = angle % 360;
        angle = Math.toRadians(angle);
        dy = -1 * speed * (Math.cos(angle));
        dx = speed * (Math.sin(angle));
        return new Velocity(dx, dy);
    }

    /**
     *  Take a point with position (x,y) and return a new point
     *    with position (x+dx, y+dy).
     * @param p the point is the center of the ball.
     * @return the new point of the new position of the ball after he moves.
     */
    public Point applyToPoint(Point p) {
        p = new Point(p.getX() + dx, p.getY() + dy);
        return p;
    }
    /**
     * Flips the sign of the dx member.
     */
    public void fillDx() {
        dx = -dx;
    }
    /**
     * Flips the sign of the dy member.
     */
    public void fillDy() {
        dy = -dy;
    }

    /**
     * Get the x coordinate of the point.
     * @return the x coordinate.
     */
    public double getDx() {
        return dx;
    }
    /**
     * Get the y coordinate of the point.
     * @return the y coordinate.
     */
    public double getDy() {
        return dy;
    }
}
