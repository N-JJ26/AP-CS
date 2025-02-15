package src.Labs.thisIsSuperFUNctions;

/**
 * Quadratic Polynomial Function in standard form a*x^2 + b*x + c
 *
 * @author Nate J, Avi D.
 * @version February 12, 2025
 */
public class Quadratic extends Polynomial
{
    /**
     * Constructs a Quadratic Polynomial Function of the form a*x^2 + b*x + c
     *
     * @param a the coefficient of the squared te4rm ( !=0 )
     * @param b the coefficient of the linear-term
     * @param c the constant
     */
    public Quadratic( double a, double b, double c )
    {
        super( new double[]{ a, b, c } );
    }

    /**
     * Default constructor for y = x^2
     */
    public Quadratic()
    {
        this(1, 0, 0);
    }

    /**
     * Returns the vertex of the Quadratic
     *
     * @return vertex = ( -b/2a, f(-b/2a) )
     */
    public Point vertex()
    {
        double xValue = Calc.derivative( this ).xIntercepts()[ 0 ].getX();
        return new Point( xValue, this.fOf( xValue ) );
    }

    /**
     * Returns the Point[] = { ( x1, 0 ), ( x2, 0 ) }, or the complex conjugates
     *  as Point objects where the x = real-part and y = imaginary-part
     *  i.e. 2 +/- 5i => { ( 2, 5 ), ( 2, -5 ) }
     *
     * @param allowCompex true if complex x-its are allowed, false otherwise
     * @return the single x-int, two real x-ints, or
     *  two complex x-ints if complex numbers are allowed.
     */
    public Point[] xIntercepts( boolean allowComplex )
    {
        if ( allowComplex )
        {
            double[] coeffs = this.coefficients();

            double discriminant = ( coeffs[ 1 ] * coeffs[ 1 ] )
                    - 4 * coeffs[ 0 ] * coeffs[ 2 ];

            if( discriminant >= 0 ) //maybe wont work
                return this.xIntercepts();

            double imaginary = Math.sqrt( Math.abs( discriminant ) );
            double xValue = -coeffs[ 1 ] / 2 * coeffs[ 0 ];

            return new Point[]{ new Point( xValue, imaginary / 2 * coeffs[ 0 ] ),
                                new Point( xValue, -( imaginary / 2 * coeffs[ 0 ] ) ) };
        }
        else
            return this.xIntercepts();
    }
}
