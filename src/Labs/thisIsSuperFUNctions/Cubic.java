package src.Labs.thisIsSuperFUNctions;

/**
 * Cubic Polynomial Function of the form a*x^3 + b*x^2 + c*x + d
 *
 * @author Avi D. Nate J.
 * @version February 10, 2025
 */
public class Cubic extends Polynomial
{
    private String toStr;

    /**
    * Constructs a Cubic Polynomial Function of the form a*x^3 + b*x^2 + c*x + d
     *
     * @param a the int coefficient of the cubed-term ( != 0, defaults to 1 )
     * @param b the int coefficient of the squared-term
     * @param c the int coefficient of the linear-term
     * @param d the int constant
     */
    public Cubic( int a, int b, int c, int d )
    {
        super( new double[]{ a, b, c, d } );
    }

    /**
    * Constructs a Cubic Polynomial Function of the form a*x^3 + b*x^2 + c*x + d
    *
    * @param p the first int x-intercept
    * @param q the second int x-intercept
    * @param r the third int x-intercept
     */
    public Cubic( int p, int q, int r )
    {
        this( 1, p + q + r, p * q + p * r + q * r, p * q * r );
    }

    /**
    * Shows the Cubic Polynomial Function in general or factored form,
    *  determined by how it was constructed
    *
    * @return "y = a*x^3 + b*x^2 + c*x + d" or "y = ( x - p )*( x - q )*( x - r )"
    */
    public String toString()
    {
        return this.toString();
    }
}
