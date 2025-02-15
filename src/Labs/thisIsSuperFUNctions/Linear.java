package src.Labs.thisIsSuperFUNctions;

/**
 * Linear Polynomial Function in slope-intercept form m*x + b
 *
 * @author Avi D. Nate J.
 * @version February 12, 2025
 */
public class Linear extends Polynomial
{
    /**
     * Constructs a Linear Polynomial Function in slope-intercept form m*x + b
     *
     * @param m the slope of the line
     * @param b the y-coordinate of the y-intercept
     */
    public Linear( double m, double b )
    {
        super( new double[]{ b, m } );
    }

    /**
     * Default constructor for y = x, slope = 1, y-intercept = origin
     */
    public Linear()
    {
        this( 1, 0 );
    }

    /**
     * Returns the slope of the line
     *
     * @return the slope of the line
     */
    public double slope()
    {
        return this.leadingCoefficient();
    }
}
