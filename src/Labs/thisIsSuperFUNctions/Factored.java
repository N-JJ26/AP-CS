package src.Labs.thisIsSuperFUNctions;

/**
 * Quadratic Polynomial Function in factored form ( x - p )*( x - q )
 *
 * @author Avi D. Nate J
 * @version February 12, 2025
 */
public class Factored extends Quadratic
{
    //(x-p)(x-q)
    private int p, q;

    /**
     * Constructs a Quadratic Polynomial Function of the form ( x - p )*( x - q )
     *
     * @param p one of the int x-intercepts
     * @param q the other x-intercept (may be equal to p)
     */
    public Factored(int p, int q)
    {
        this.p = p;
        this.q = q;

        super(1, -( p + q ), p * q);
    }

    /**
     * Shows the Quadratic Polynomial Function in factored form
     *
     * @return the polynomial written in factored form, ex. "y = ( x - p )*( x - q )"
     */
    public String toString()
    {
        String numP = "" + p;
        String numQ = "" + q;

        return "y = ( x" +
            ( numP.charAt( 0 ) == '-' ? " + " + numP.substring( 1 ) : " - " + numP ) +
            " )*( x" +
            ( numQ.charAt( 0 ) == '-' ? " + " + numQ.substring( 1 ) : " - " + numQ ) +
            " )";
    }

    /**
     * Returns the String that represents the Quadratic Function as f(x) = a*x^2 + b*x + c
     *
     * @return the Polynomial written in descending order, ex. f(x) = 5x^2 + 7x - 1
     */
    public String toString( boolean generalForm )
    {
        if( generalForm )
            return super.toString();
        else
            return this.toString();
    }
}
