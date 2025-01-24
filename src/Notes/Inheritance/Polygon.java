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
    public Point[] getPoints() {
        Point[] copy = new Point[points.length];
        for(int i = 0; i < points.length; i++)
            copy[i] = points[i];

        return copy;
    }

    /**
     * Calculates the perimeter of the Polygon
     *
     * @return the calculated perimeter of the Polygon
     */
    public double perimeter() {
        double length = Point.distance(points[points.length - 1], points[0]);

        for(int i = 0; i < points.length - 1; i++)
            length += Point.distance(points[i], points[i + 1]);

        return length;
    }

    /**
     * Calculates the area of any given Polygon using Gauss's shoelace formula
     *  an example of polymorphism
     *
     * @param polygon any Polygon
     * @return the approximate area of the Polygon
     */
    public static double area(Polygon polygon) {
        if (polygon == null)
            return 0.0;

        Point[] pts = polygon.getPoints();
        double[] xs = new double[pts.length + 1];
        double[] ys = new double[pts.length + 1];

        for(int i = 0; i < pts.length; i++) {
            xs[i] = pts[i].getX();
            ys[i] = pts[i].getY();
        }

        xs[xs.length - 1] = xs[0];
        ys[ys.length - 1] = ys[0];

        double sop = 0.0; //Sum-of-products

        for(int i = 0; i < xs.length - 1; i++) {
            sop += xs[i] * ys[i + 1];
            sop -= ys[i] * xs[i + 1];
        }

        return Math.abs(sop / 2);
    }

    /**
     * Returns the list of Point objects, overrides Object's toString()
     *
     * @return the list of Point objects
     */
    public String toString() {
        String str = points[0].toString();

        for(int i = 1; i < points.length; i++)
            str += ", " + points[i];

        return str;
    }

    /**
     * Will return either the super Object toString or this.toString()
     *  overloads Polygon's toString()
     *
     * @param isObject true if Object's super.toString() is required, false otherwise
     * @return one of the toString()'s
     */
    public String toString(boolean isObject) {
        if(isObject)
            return super.toString();
        return this.toString();
    }

    public static void main(String[] args) {
        Polygon p = new Polygon(new Point[]{
                                    new Point(),
                                    new Point(4, 0),
                                    new Point(0, 3)
                                });
        
        System.out.println(p.perimeter());
        System.out.println(area(p));
        System.out.println(p);
        System.out.println(p.toString(false));
        System.out.println(p.toString(true));
    }
}
