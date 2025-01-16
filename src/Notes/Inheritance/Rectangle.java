package src.Notes.Inheritance;

/**
 * A class to demonstrate this(), super(), and polymorphism
 *
 * Rectangle is a Quadrilateral
 * Rectangle is a Polygon
 * Rectangle has a Point
 *
 * @author Nate Johnson
 * @version 1/16/25
 */
public class Rectangle extends Quadrilateral {
    public Rectangle(Point a, Point b, Point c, Point d) {
        super(a, b, c, d);
    }

    /**
     * Constructs and "upright" rectangle object
     *
     * @param x the x coordinate of point a
     * @param y the y coordinate of point a
     * @param width the width of the Rectangle
     * @param height the height of the Rectangle
     */
    public Rectangle(int x, int y, int width, int height) {
        this(new Point(x, y), new Point( x + width, y),
            new Point(x + width, y + height), new Point(x, y + height));
    }
}
