package src.Notes.Inheritance;

/**
 * Another class used to demonstrate super() and super.
 *
 * @author Nate Johnson
 * @version 1/16/25
 */
public class Quadrilateral extends Polygon {
    /**
     * Sends the Point[] up the hierarchy
     *
     * @param points the Point[] of a Quadrilateral
     */
    public Quadrilateral(Point[] points) {
        super(points); //MUST be the first line of code
    }

    /**
     * A constructor for Quadrilateral with four Points, calls Quadrilateral(Point[])
     *  which then calls Polygon(Point[])
     *
     * @param a any "first" Point
     * @param b either adjacent Point to a
     * @param c the Point opposite a
     * @param d the Point opposite b
     */
    public Quadrilateral(Point a, Point b, Point c, Point d) {
        this(new Point[]{a, b, c, d}); //stylistically, only one super() call
    }
}
