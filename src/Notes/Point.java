package src.Notes;

/**
 * Cartesian points
 *
 * @author Nate Johnson
 * @version 1/10/24
 */
public class Point {
    //this.var refers to the implicit parameter's instance variables
    private double x; //this.x
    private double y; //this.y

    //this. can always be avoided
    //strictly for readability

    /*
     * Overshadowing:
     *  using variables with the same name without this. will  make things really funny
     */

    /**
     * Constructor for a Point object
     *
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Default Constructor to generate origin
     *  (overloading the constructor; same name, different parameters)
     */
    public Point() {
        this(0.0, 0.0); //calls the appropriate constructor in one line
                            //to avoid a Point() inside of a Point(), this() avoids that

        // this.x = 0.0;
        // this.y = 0.0;

        // x = 0.0;
        // y = 0.0;
        //these do the exact same thing
    }

    /**
     * overloaded constructor of a lattice point
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(int x, int y) {
        this((double)x, (double)y);
    }

    /**
     * Returns the x coordinate
     *
     * @return x the x coordinate
     */
    public double getX() { return x; }

    /**
     * Returns the y coordinate
     *
     * @return y the y coordinate
     */
    public double getY() { return y; }

    /**
     * Moves the Point object according to a deltaX and deltaY
     *
     * @param deltaX the change in the x coordinate, deltaX > 0 moves to the right
     *               deltaX < 0 moves to the left, and deltaX == 0 does nothing
     * @param deltaY the change in the y coordinate, deltaY > 0 moves up
     *               deltaY < 0 moves down, and deltaY == 0 does nothing
     */
    public void translate(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }

    /**
     * Moves the Point object according to a deltaX and deltaY
     *
     * @param deltaX the change in the x coordinate, deltaX > 0 moves to the right
     *               deltaX < 0 moves to the left, and deltaX == 0 does nothing
     * @param deltaY the change in the y coordinate, deltaY > 0 moves up
     *               deltaY < 0 moves down, and deltaY == 0 does nothing
     */
    public void translate(int deltaX, int deltaY) {
        this.translate((double)deltaX, (double)deltaY); //this. can be used for methods as well

        //this. is not necessary...EVER! (suuuuure) you NEVER (suuuuure) need this.method()
        //this is in reference to itself, but its own methods are the "most local"
    }

    /**
     * Calculates the abs of this implicit point
     *
     * @return the distance from the origin
     */
    public double absoluteValue() {
        return distance(new Point(), this); //(this) is the only necessary this (as a parameter)
    }

    public String toString() {
        return "(" + (int)x + ", " + (int)y + ")";
    }

    /**
     * Calculates the distance between 2 Points
     *
     * @param p1 the first Point object
     * @param p2 the second Point object
     * @return the distance between the two Points
     */
    public static double distance(Point p1, Point p2) {
        return Math.hypot((p1.getX() - p2. getX()), (p1.getY() - p2. getY()));
    }

    /**
     * Calculates the rate of change between two point objects
     *
     * @param p1 the first Point
     * @param p2 the second Point
     * @return the slope of the two points as a decimal
     */
    public double slope(Point p1, Point p2) {
        return (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
    }
}
