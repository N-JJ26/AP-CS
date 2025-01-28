package src.Notes.Inheritance;

/**
 * Demonstration of polymorphism - many forms
 *
 * @author Nate Johnson
 * @version 1/28/25
 */
public class ShapeRunner {
    public static void main(String[] args) {
        Polygon[] polygons = new Polygon[7];

        Point[] points1 = new Point[]{
                        new Point(),
                        new Point(1, 1),
                        new Point(2, 5),
                        new Point(1, 4),
                        new Point(0, 2)
        };

        Point[] points2 = new Point[]{
                        new Point(),
                        new Point(1, 1),
                        new Point(2, 5),
                        new Point(0, 2)
        };

        polygons[0] = new Polygon(points1);
        polygons[1] = new Quadrilateral(points2);
        polygons[2] = new Quadrilateral(
                        new Point(),
                        new Point(5, 0),
                        new Point(3, 3),
                        new Point(5, 4)
        );
        polygons[3] = new Rectangle(0, 0, 9, 7);
        polygons[4] = new Rectangle(
                        new Point(),
                        new Point(5, 0),
                        new Point(5, 3),
                        new Point(0, 3)
        );
        polygons[5] = new Square();
        polygons[6] = new Square(6);

        for(Polygon poly : polygons)
            System.out.println(poly + ": " + poly.perimeter());

        System.out.println();

        for(Polygon poly : polygons)
            if(poly instanceof Rectangle)
                System.out.println(poly + ": " + ((Rectangle)poly).getWidth());

        for (Polygon poly : polygons)
            if(poly instanceof Quadrilateral)
                printIt((Quadrilateral)poly);
    }

    private static void printIt(Quadrilateral quad) {
        System.out.println("I'm a quadrilateral " + Polygon.area(quad));
    }
}
