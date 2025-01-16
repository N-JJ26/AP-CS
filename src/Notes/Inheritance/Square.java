package src.Notes.Inheritance;

/**
 * Just to have a longer hierarchy
 *
 * @author Nate Johnson
 * @version 1/16/25
 */
public class Square extends Rectangle {
    /**
     * Bottom-left corner at the origin
     * @param side the side length of the Square
     */
    public Square(int side) {
        super(0, 0, side, side);
    }

    /**
     * Unit Square
     */
    public Square() {
        this(1);
    }

    // public Square(Point a, int side) {
    //     // super(new Point[]{a,
    //     //         new Point(a.getX() + side, a .getX()),
    //     //         new Point(a.getX(), a.getY() + side),
    //     //         new Point(a.getX() + side, a.getY() + side)});
    //     //cannot do this because super() ONLY goes one level up

    //     super((int)a.getX(), (int)a.getY(), side, side);
    // }
}
