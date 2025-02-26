package src.Labs.thisIsSuperFUNctions;

/**
 * Linear Polynomial Function in standard form Ax + By = C where A, B, and C are integers
 *
 * @author Avi D, Nate J.
 * @version February 26, 2025
 */
public class Standard extends Linear
{
    private int A, B, C;

    /**
     * Constructs a StandardForm Linear Polynomial Function Ax + By = C,
     *  where A, B, and C are integers and A != 0 or B != 0 else default to x - y = 0
     *
     * @param A the coefficient of x, where A is an integer
     * @param B the coefficient of y, where B is an integer
     * @param C constant, where C is an integer
     */
    public Standard( int A, int B, int C )
    {
        super( ( double )( -A ) / B, ( ( double )C ) / B );

        this.A = A;
        this.B = B;
        this.C = C;
    }

    /**
     * Shows the Linear Polynomial Function in standard form
     *
     * @return the Polynomial in the form "Ax + By = C"
     */
    public String toString()
    {
        String numA = "" + A;
        String numB = "" + B;
        String numC = "" + C;

        return numA + "x" +
            ( numB.charAt( 0 ) == '-' ? " - " + numB.substring( 1 ) : " + " + numB ) +
            "y = " + numC;
    }

    /**
     * Returns the String that represents the Linear Function as f(x) = m*x + b
     *
     * @param slopeIntercept true for slope intercept form, false for standard form
     * @return the Polynomial written in descending order, ex f(x) = 7x - 1
     */
    public String toString( boolean slopeIntercept )
    {
        if( slopeIntercept )
            return super.toString();
        else
            return this.toString();
    }
}
