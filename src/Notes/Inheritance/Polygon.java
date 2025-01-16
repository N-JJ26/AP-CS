package src.Notes.Inheritance;

/**
 * In the Beginning... there were Polygon objects
 *
 * @author Nate Johnson
 * @version 1/16/25
 */
public class Polygon {
    private Point[] points;

    /**
     * Constructs an object of edges and vertices
     *
     * @param points a Point[] of consecutive Point objects for the Polygon
     *                 i.e. A, B, C, D,...etc
     */
    public Polygon(Point[] points) {
        this.points = points;
    }

    /**
     * Returns a copy of the Point[], do not want to give access to points
     *
     * @return the Point[]
     */
    public Point[] gePoints() {
        Point[] copy = new Point[points.length];
        for(int i = 0; i < points.length; i++)
            copy[i] = points[i];

        return copy;
    }
}
