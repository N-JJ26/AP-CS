package src.Labs.thisIsSuperFUNctions;

/**
 * Polynomial is-a Function that is defined as a series of double coefficients on
 *  integer powers of x with a degree of n, where a(n) != 0 when n > 0, or any
 *  real when n == 0 a(n)*x^n + a(n-1)*x^(n-1) + ... + a(1)*x + a(0)
 *
 * @author Avi D, Nate J
 * @version February 14, 2025
 */
public class Polynomial extends Function
{
    private double[] a;

    /**
     * Construct a Polynomial object by defining the coefficients a(0) through a(n),
     *  where a(0) is the first element in the double[]
     *
     * @param coefficients the array of double coefficients from a(0)
     *  through a(n), with a(n) != 0, unless it is the constant polynomial = 0
     */
    public Polynomial( double[] coefficients )
    {
        int count = 0;

        if( coefficients.length == 0 ||
            Math.abs( coefficients[ coefficients.length - 1 ] - 0.0 ) > Calc.EPSILON )
        {
            a = coefficients;
            return;
        }
        else
            for( int i = coefficients.length - 1; i >= 0; i-- )
                if( Math.abs( coefficients[ i ] - 0.0 ) > Calc.EPSILON )
                {
                    count = i;
                    break;
                }

        double[] newCoeff = new double[ count + 1 ];

        for( int i = 0; i < newCoeff.length; i++ )
            newCoeff[ i ] = coefficients[ i ];

        a = newCoeff;
}
    /**
     * Compares the average value of this Polynomial to an
     *  other Polynomial over a given closed interval [ a, b ], where a <= b
     *
     * @param a the left-bound of the interval
     * @param b the right-bound of the interval
     * @return -1 if this Polynomial is less than the explicit parameter
     *  Object, 0 if equal, and +1 if this is greater than other or null or a > b.
     */
    public int compareTo( Polynomial other, double a, double b )
    {
        if( other == null || a > b )
            return 1;

        if( Calc.areaUnder( this, a, b ) / ( b - a )
            > Calc.areaUnder( other, a, b ) / ( b - a ))
            return 1;
        if( Calc.areaUnder( this, a, b ) / ( b - a )
            < Calc.areaUnder( other, a, b ) / ( b - a ))
            return -1;
        else
            return 0;
    }

    /**
     * Compares the average value of this Polynomial to an other Polynomial
     * over a given closed interval [ a, b ], where a <= b
     *
     * @param other the "other" Polynomial against this Polynomial
     * @param interval the closed interval for this comparison [ a,b ]
     * @return -1 if this Polynomial is less than the explicit parameter Object,
     *  0 if equal, and +1 if this is greater than other or null or 
     *  the interval is not closed.
     */
    public int compareTo( Polynomial other, Interval interval )
    {
        return this.compareTo( other, interval.getLeftBound(), interval.getRightBound() );
    }

    /**
     * Returns the open interval of x-values on which the function is
     8 increasing, i.e. slope > 0.0, if none exist, returns an empty array, {}
     *
     * @override increasing in class Function
     * @return the open interval of x-values on which the function is increasing,
     *  i.e. slope > 0.0
     */
    //public Interval[] increasing

    /**
     * Returns the open interval of x-values on which the function is
     *  decreasing, i.e. slope < 0.0, if none exist, returns an empty array, {}
     *
     * @override decreasing in class Function
     * @return the open interval of x-values on which the function is decreasing,
     *  i.e. slope < 0.0
     */
    //public Interval[] decreasing

    /**
     * Calculates the y-value that corresponds to the x-value parameter
     *
     * @override fOf in class function
     * @param the x-value that is "plugged into" the Polynomial
     * @return the y coordinate of the Point on the curve at the given x-value
     */
    public double fOf( double x )
    {
        double sum = 0;
        for( int i = 0; i < a.length; i++ ) {
            sum += a[ i ] * Math.pow( x, ( double )i );
        }
        return sum;
    }

    /**
     * Determines the slope of the line tangent to the Polynomial
     *  at the given x-value using the derivative of the Polynomial
     *
     * @override fPrimeOf in class Function
     * @param a the x-value that is "plugged into" the derivative
     * @return the slope of the tangent line
     */
    public double fPrimeOf( double a )
    {
        return Calc.derivative( this ).fOf( a );
    }

    /**
     * Finds a line, in point-slope form, that is tangent to this
     *  Polynomial at the given x-value
     *
     * @param x the x-value of the point of tangency
     * @return the tangent line in point-slope form at the given x-value
     */
    public PointSlope tangent( double x )
    {
        return new PointSlope( new Point( x, fOf( x ) ), fPrimeOf( x ) );
    }

    /**
     * Returns the Point[] = { ( x1, 0 ), ( x2, 0 ), ... } of this Polynomial object
     *
     * @return the x-ints = { ( x1, 0 ), ( x2, 0 ), ... }
     */
    public Point[] xIntercepts()
    {
        return Calc.xIntercepts( this );
    }

    /**
     * Returns the Point = ( 0, a(0) ) of this Polynomial object
     *
     * @return the y-int = ( 0, a(0) )
     */
    public double yIntercept()
    {
        return a[ 0 ];
    }

    /**
     * The degree of a Polynomial a(n)*x^n + ... a(1)*x + a(0) is n, where a(n) != 0
     *  unless a(0) = 0 is the Polynomial
     *
     * @return the degree n of the Polynomial
     */
    public int degree()
    {
        return a.length - 1;
    }

    /**
     * Returns the leading coefficient of the Polynomial
     *
     * @return a(n), the leading coefficient
     */
    public double leadingCoefficient()
    {
        return a[ a.length - 1 ];
    }

    /**
     * Returns a copy of the coefficients as an double[] in the order a(0),
     * a(1), ... a(n)
     *
     * @return a copy of the coefficients of the Polynomial, a(0) through a(n)
     */
    public double[] coefficients()
    {
        double[] copy = new double[ a.length ];
        for( int i = 0; i < copy.length; i++ )
            copy[ i ] = a[ i ];
        return a;
    }

    /**
     * Determines if the given Point is within one-thousandth of the Polynomial's curve
     *
     * @param p a Point that may be on the Polynomial's curve
     * @return true if the Point p, != null, is a solution to the Polynomial's
     *  equation, false otherwise
     */
    public boolean isOnCurve( Point p )
    {
        return Math.abs( fOf( p.getX() ) - p.getY() ) < Calc.EPSILON;
    }

    /**
     * Checks if two Polynomials are equal
     *
     * @override equals in class java.lang.Object
     * @param obj the object to the compared
     * @return true if all the coefficients match, false otherwise
     */
    public boolean equals( Polynomial other )
    {
        if( other.coefficients().length != a.length || other == null )
            return false;
        for(int i = 0; i < a.length; i++)
            if( Math.abs( a[ i ] - other.coefficients()[ i ] ) > Calc.EPSILON )
                return false;
        return true;
    }

    /**
     * Concatenates a String that represents the Polynomial Function as
     *  f(x) = a(n)*x^n + a(n-1)*x^(n-1) + ... + a(1)*x + a(0)
     *
     * @override toString in class Function
     * @return the Polynomial written in descending order, ex. f(x) = 5x^2 + 7x - 1
     */
    public String toString()
    {
        String str = "y = ";

        if( a.length == 0 )
            str += "0";
        else if( a.length == 1 )
            str += a[0];
        else if( a.length == 2 )
        {
            str += linearString();
        }
        else
        {
            str += a[ a.length - 1] + "x^" + this.degree();
            for( int i = a.length - 2; i > 1; i-- )
            {
                if( Math.abs( a[i] - 0.0 ) < Calc.EPSILON )
                    continue;
                String num = "" + a[ i ];

                str +=
                ( num.charAt( 0 ) == '-' ? " - " + num.substring( 1 ) : " + " + num )
                    + "x^" + i;
            }

            String num = "" + a[ 1 ];
            if( !linearString().equals("") )
                str +=
                ( num.charAt( 0 ) == '-' ? " - " + linearString().substring( 1 )
                    : " + " + linearString() );
        }
        return str;
    }


    private String linearString()
    {
        String str = "";
        String num = "" + a[ 0 ];

        if( Math.abs( a[0] - 0.0 ) < Calc.EPSILON &&
            Math.abs( a[1] - 0.0 ) < Calc.EPSILON )
            return str;
        
        if( Math.abs( a[1] - 0.0 ) < Calc.EPSILON )
            str += a[0];
        else if( Math.abs( a[0] - 0.0 ) < Calc.EPSILON )
            str += a[1] + "x";
        else
            str += a[ 1 ] + "x" +
                    ( num.charAt( 0 ) == '-' ? " - " + num.substring( 1 ) : " + " + num );
        return str;
    }

    /**
     * Generates a new Polynomial f + g
     *
     * @param f one of the Polynomials to be added together
     * @param g the other Polynomial to be added to f
     * @return the Polynomial f + g
     */
    public static Polynomial add( Polynomial a, Polynomial b )
    {
        return arithmetic(a, b, true);
    }

    /**
     * Generates a new Polynomial f - g
     *
     * @param f the minuend of the subtraction
     * @param g the subtrahend of the subtraction
     * @return the Polynomial f - g
     */
    public static Polynomial subtract( Polynomial a, Polynomial b )
    {
        return arithmetic(a, b, false);
    }


    private static Polynomial arithmetic( Polynomial a, Polynomial b, boolean add )
    {
        if( a == null || b == null )
            return new Polynomial( new double[]{ 0 } );

        int longer = 0;
        int shorter = 0;

        if( a.coefficients().length > b.coefficients().length ) {
            longer = a.coefficients().length;
            shorter = b.coefficients().length;
        } else {
            longer = b.coefficients().length;
            shorter = a.coefficients().length;
        }

        double[] c = new double[ longer ];

        for( int i = 0; i < shorter; i++ )
            c[ i ] = add ? a.coefficients()[ i ] + b.coefficients()[ i ] :
                        a.coefficients()[ i ] - b.coefficients()[ i ];

        if( longer == shorter )
            return new Polynomial( c );

        double multiplier = add ? 1 : -1 ;
        for( int i = shorter; i < longer; i++ )
            c[i] = longer == b.coefficients().length ?
                multiplier * b.coefficients()[ i ] :
                multiplier * a.coefficients()[ i ];

        return new Polynomial( c );
    }

    /**
     * Main class, used for testing. To be deleted
     *
     * @param soz
     * @return gleep glorp
     */
    public static void main(String[] args) {
        Standard p = new Standard(5, 10, -3);

        System.out.println(p);
    }
}
