package src.Notes.Inheritance;

/**
 * Lattice point has only int x's and y's
 *
 * @author Nate Johnson
 * @version 1/15/24
 */
public class LatticePoint extends Point {
    public LatticePoint(int x, int y) {
        super(x, y); //super() goes up a constructor
    }

    public double distance(LatticePoint pt) {
        return Math.hypot((this.getX() - pt.getX()), (this.getY() - pt.getY()));
    }

    //anything public, the subclass has automatic access
}
