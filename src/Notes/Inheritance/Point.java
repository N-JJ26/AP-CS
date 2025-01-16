package src.Notes.Inheritance;

/**
 * Cartesian points
 *
 * @author Nate Johnson
 * @version 1/15/25
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

    /**
     * Compares this Point object to another Point object
     *
     * @param other the Point that is being compared against
     * @return true if the implicit x and y are equal to the explicit x and y,
     *          false otherwise
     */
    public boolean equals(Point other) {
        if (other == null)
            return false;

        final double EPSILON = 0.001;

        return (Math.abs(x - other.x) < EPSILON) &&
                (Math.abs(y - other.y) < EPSILON);
    }

    /**
     * Overridden .equals() of Object
     *
     * @param obj is any Object as a parameter
     * @return true of the explicit parameter is a Point object and matches coordinates
     */
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Point)) { //instanceof is an operator
            return false;
        }
        return this.equals((Point)obj); //obj is AT LEAST a Point object
    }

    /**
     * Returns the point as an ordered pair: (x, y)
     *
     * @return the ordered pair: (x, y) to 2 decimal places
     */
    public String toString() {
        final double EPSILON = 0.001;

        String xStr = "";
        String yStr = "";

        if(Math.abs((int)(x) - x) < EPSILON)
            xStr = "" + (int)(x);
        else {
            if((int)(x * 100) % 10 != 0)
                xStr = "" + (int)(x) + "." + (int)((x * 100) % 100);
            else
                xStr = "" + (int)(x) + "." + (int)((x * 10) % 10);
        }

        if(Math.abs((int)(y) - y) < EPSILON)
            yStr = "" + (int)(y);
        else {
            if((int)(y * 100) % 10 != 0)
                yStr = "" + (int)(y) + "." + (int)((y * 100) % 100);
            else
                yStr = "" + (int)(y) + "." + (int)((y * 10) % 10);
        }

        return "(" + xStr + ", " + yStr + ")";
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
    public static double slope(Point p1, Point p2) {
        return (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
    }

    /**
     * Returns the int array of all the x coordinates of the points
     *
     * @param points the array of Point objects
     * @return the int array of all the x coordinates in points
     */
    public static int[] getXs(Point[] points) {
        if(points == null)
            return new int[]{};
        
        int[] xs = new int[points.length];
        for(int i = 0; i < xs.length; i++) {
            xs[i] = (int)(points[i].getX());
        }
        return xs;
    }

    /**
     * Returns the int array of all the y coordinates of the points
     *
     * @param points the array of Point objects
     * @return the int array of all the y coordinates in points
     */
    public static int[] getYs(Point[] points) {
        if(points == null)
            return new int[]{};
        
        int[] ys = new int[points.length];
        for(int i = 0; i < ys.length; i++) {
            ys[i] = (int)(points[i].getY());
        }
        return ys;
    }

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(6.781, 3.425),
                                    new Point(15.40, 8.20),
                                    new Point(6, 1),
                                    new Point(6.00, 1.00),
                                    new Point(10000.5, 123251241.5),
                                    new Point(),
                                    new Point(3.00000000001, 2.3)};

        for(Point point : points) {
            System.out.println(point);
        }

        System.out.println(points[2].equals(points[3]));
        System.out.println(points[1].equals(points[2]));

        for(int x : getXs(points)) {
            System.out.print(x + " ");
        }

        System.out.println();

        for(int y : getYs(points)) {
            System.out.print(y + " ");
        }

        System.out.println();
    }
}
