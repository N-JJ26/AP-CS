package src.Labs.thisIsSuperFUNctions;

/**
 * Quadratic Polynomial Function in factored form ( x - p )*( x - q )
 *
 * @author Avi D. Nate J
 * @version February 26, 2025
 */
public class Factored extends Quadratic
{
    private int p, q;

    /**
     * Constructs a Quadratic Polynomial Function of the form ( x - p )*( x - q )
     *
     * @param p one of the int x-intercepts
     * @param q the other x-intercept (may be equal to p)
     */
    public Factored(int p, int q)
    {
        super(1, -( p + q ), p * q);

        this.p = p;
        this.q = q;
    }

    /**
     * Shows the Quadratic Polynomial Function in factored form
     *
     * @return the polynomial written in factored form, ex. "y = ( x - p )*( x - q )"
     */
    public String toString()
    {
        String[] nums = new String[]{
            "" + p,
            "" + q
        };

        for( int i = 0; i < nums.length; i++ )
            if( nums[ i ].charAt( 0 ) == '-' )
                nums[ i ] = " + " + nums[ i ].substring( 1 );
            else
                nums[ i ] = " - " + nums[ i ];

        return "y = (x" + nums[ 0 ] + ")(x" + nums[ 1 ] + ")";
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
