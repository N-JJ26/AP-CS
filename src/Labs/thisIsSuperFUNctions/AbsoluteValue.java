package src.Labs.thisIsSuperFUNctions;

/**
 * AbsoluteValue is-a Function that has the functionality of an absolute-value
 *
 * @author Nate Johnson, Avi Dasgupta
 * @version 2/28/25
 */
public class AbsoluteValue extends Function
{
    private double a;
    private Point vertex;

    /**
     * Constructs an AbsoluteValue Function using the stretch/shrink and vertex
     *
     * @param a stretch/shrink of the function, a > 0 right-side up,
     *          a < 0 upside-down, defaults to a = +1.0
     * @param vertex the vertex of the graph, defaults to origin
     */
    public AbsoluteValue( double a, Point vertex )
    {
        super( false );

        if( Math.abs( a - 0 ) < Calc.EPSILON )
            a = 1.0;

        this.a = a;
        this.vertex = vertex;
    }

    /**
     * Constructs an AbsoluteValue Function in the form y = a * | x - h | + k
     *
     * @param a stretch/shrink of the function, a > 0 right-side up,
     *          a < 0 upside-down, defaults to a = 1
     * @param h right/left transformation
     * @param k up/down transformation
     */
    public AbsoluteValue( double a, double h, double k )
    {
        this( a, checkPoint( new Point( h, k ) ) );
    }

    private static Point checkPoint( Point p )
    {
        if( p == null )
            return new Point();
        return p;
    }

    /**
     * Returns the interval for the half of the Function that is increasing
     *
     * @return the open interval of x-values on which the function is increasing,
     *           i.e. slope > 0.0
     */
    public Interval[] increasing()
    {
        if( a > 0 )
            return new Interval[]{ new Interval( vertex.getX() , false,
                    Double.POSITIVE_INFINITY, false ) };
        return new Interval[]{ new Interval ( Double.NEGATIVE_INFINITY, false,
                                vertex.getX(), false ) };
    }

    /**
     * Returns the interval for the half of the Function that is decreasing
     *
     * @return the open interval of x-values on which the function is decreasing,
     *           i.e. slope < 0.0
     */
    public Interval[] decreasing()
    {
        if( a < 0 )
            return new Interval[]{ new Interval( vertex.getX() , false,
                    Double.POSITIVE_INFINITY, false ) };
        return new Interval[]{ new Interval ( Double.NEGATIVE_INFINITY, false,
                                vertex.getX(), false ) };
    }

    /**
     * Calculates the y-value that corresponds to the x-value parameter
     *
     * @param x the x-value that is "plugged into" the AbsoluteValue
     * @return the y coordinate of the Point on the curve at the given x-value
     */
    public double fOf( double x )
    {
        return a * Math.abs( x - vertex.getX() ) + vertex.getY();
    }

    /**
     * Determines the slope of the AbsoluteValue at the given x-value
     *
     * @param x the x-value to be plugged into the Function's derivative
     * @return the slope of the tangent line
     */
    public double fPrimeOf( double x )
    {
        if( Math.abs( x - 0 ) < Calc.EPSILON )
            return Double.NaN;
        if( x > vertex.getX() )
            return a;
        return -a;
    }

    /**
     * Returns the Function as y = a * | x - h | + k
     *
     * @return "y = a * | x - h | + k"
     */
    public String toString()
    {
        String str = super.toString();
        String[] numStr = new String[]{
                Calc.clean( a ) + "*",
                Calc.clean( vertex.getX() ),
                Calc.clean( -vertex.getY() )
        };

        for( int i = 1; i < numStr.length; i++ )
        {
            if( numStr[ i ].equals("0") )
            {
                numStr[ i ] = "";
                continue;
            }

            if( numStr[ i ].charAt( 0 ) == '-' )
                numStr[ i ] = " + " + numStr[ i ].substring( 1 );
            else
                numStr[ i ] = " - " + numStr[ i ];
        }

        if( numStr[ 0 ].charAt(0) == '1' )
            numStr[ 0 ] = "";

        return str + numStr[ 0 ] + "|x" + numStr[ 1 ] + "|" + numStr[ 2 ];
    }
}
