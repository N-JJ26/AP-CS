package src.Labs.thisIsSuperFUNctions;

import java.util.ArrayList;

public class Calc
{
    /** one-thousandth */
    public static final double EPSILON = 0.001;
    private static final int MIN = -20;
    private static final int MAX = 20;
    
    private static int whichPrime = 0;
    private static final int[] primes = { 2, 3, 5, 7, 11, 13, 17, 19,
                                        23, 29, 31, 37, 41, 43, 47,
                                        53, 59, 61, 67, 71, 73, 79,
                                        83, 89, 97 };
    
    /**
     * This method will return the next prime in the sequence 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 
     *  31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97; after 97, it will go back to the
     *  beginning with 2.
     *
     * @return one of the first 25 primes, cyclically in ascending order starting with 2
     */
    public static int nextPrime()
    {
        int prime = whichPrime;
        whichPrime = ( whichPrime + 1 ) % primes.length;
        
        return primes[ prime ];
    }
    /**
     * This method resets the nextPrime() to be the first one in the sequence, i.e. back to 2
     */
    public static void startOverPrimes()
    {
        whichPrime = 0;
    }
    
    /**
     * Takes a double and cleans it up to within two decimal places as necessary, truncating
     *  the decimal
     *
     * @param num any double to be "cleaned"
     * @return a String within two decimal places
     */
    public static String clean( double num )
    {
        num = Math.round( num * 100 ) / 100.0;
        
        if( Math.abs( num - (int)num ) < EPSILON )
            return "" + (int)num;
        
        return "" + num;
    }
    
    /**
     * Calculates the approximate area under the curve to the x-axis on the closed
     *  interval [ a, b ], where a <= b (if a > b, then area will be negated)
     *  (Note: the area can be negative under the x-axis)
     *
     * @param poly the Polynomial that is continuous Function on the interval
     * @param a the left bound x-value of the closed interval
     * @param b the right bound x-value of the closed interval
     * @return the approximate area under the curve f, on [ a, b ]
     */
    public static double areaUnder( Polynomial poly, double a, double b )
    {
        int ordered = 1;
        if( a > b )
        {
            double temp = a;
            a = b;
            b = temp;
            ordered = -1;
        }
        
        double area = 0.0;
        for( double x = a; x < b; x += EPSILON )
            area += poly.fOf( x );
        
        return ordered * area * EPSILON;
    }
    /**
     * Calculates the approximate area under the curve to the x-axis on the closed
     *  interval [ a, b ], where a <= b
     *  (Note: the area can be negative under the x-axis)
     * 
     * @param poly the Polynomial that is continuous Function on the interval
     * @param interval the closed interval [ a, b ]
     * @return the approximate area under the curve f, on [ a, b ],
     *         or 0.0 if an open interval
     */
    public static double areaUnder( Polynomial poly, Interval interval )
    {
        if( !interval.leftIncluded() || !interval.rightIncluded() )
            return 0.0;
        
        double area = 0.0;
        double b = interval.getRightBound();
        for( double x = interval.getLeftBound(); x < b; x += EPSILON )
            area += poly.fOf( x );
        
        return area * EPSILON;
    }
    
    /**
     * Calculates the first derivative of a Polynomial
     *
     * @param f the Polynomial for which d/dx will be calculated
     * @return a Polynomial equivalent to f'(x)
     */
    public static Polynomial derivative( Polynomial f )
    {
        if( f == null )
            return null;
        
        double[] a = f.coefficients();
        
        if( a.length <= 1 )
            return new Polynomial( new double[]{ 0 } );
        
        double[] d = new double[ a.length - 1 ];
        
        for( int i = 1; i < a.length; i++ )
            d[ i - 1 ] = a[ i ] * i;
        
        return new Polynomial( d );
    }
    
    /**
     * Calculates and returns any x-intercepts of Linear and Quadratic Polynomial
     *  Functions, approximates x-intercepts on the closed interval [ MIN, MAX ] for
     *  all other Polynomial Functions, and returns the Point[] of xIntercepts in the
     *  form ( a, 0 )
     *
     * @param p the Polynomial Function
     * @return a Point[] containing x-intercepts, possibly with zero elements
     */
    public static Point[] xIntercepts( Polynomial p )
    {
        if( p == null || p.degree() < 1 )  //horizontal
            return new Point[]{};
        
        double[] coeffs = p.coefficients();
        
        if( p.degree() < 2 )  //linear
            return new Point[]{ new Point( -1*coeffs[ 0 ] / coeffs[ 1 ], 0.0 ) };
        
        if( p.degree() < 3 )  //quadratic
            return quadraticFormula( coeffs[ 2 ], coeffs[ 1 ], coeffs[ 0 ] );
        
        //although there is a pair of "cubic formulas"
        return findIntercepts( p );
    }
    private static Point[] quadraticFormula( double a, double b, double c )
    {
        double discriminant = b * b - 4 * a * c;
        
        if( discriminant < 0 )
            return new Point[]{};
        
        Point xInt1 = new Point( ( -1*b + Math.sqrt( discriminant ) ) / ( 2 * a ), 0.0 );
        if( Math.abs( discriminant ) < EPSILON )
            return new Point[]{ xInt1 };
        
        Point xInt2 = new Point( ( -1*b - Math.sqrt( discriminant ) ) / ( 2 * a ), 0.0 );
        return new Point[]{ xInt1, xInt2 };
    }
    private static Point[] findIntercepts( Polynomial p )
    {
        final double TOO_CLOSE = 0.1;
        ArrayList< Double > xInts = new ArrayList< Double >();
        
        for( double x = MIN; x <= MAX; x += EPSILON )
            if( Math.abs( p.fOf( x ) ) < EPSILON )
            {
                if( xInts.isEmpty() )
                {
                    xInts.add( x );
                    continue;
                }
                //most recent is further from zero
                if( Math.abs( x - xInts.get( xInts.size() - 1 ) ) < TOO_CLOSE )
                {
                    if( Math.abs( p.fOf( x ) ) < Math.abs( p.fOf( xInts.get( xInts.size() - 1 ) ) ) )
                    {
                        xInts.remove( xInts.size() - 1 );
                        xInts.add( x );
                    }
                    continue;
                }
                
                xInts.add( x );
            }
            else if( p.fOf( x ) * p.fOf( x + EPSILON ) <= 0 )  // +- or -+
            {
                xInts.add( ( 2 * x + EPSILON ) / 2 );  //average x-values
            }
        
        Point[] pts = new Point[ xInts.size() ];
        for( int i = pts.length - 1; i >= 0; i-- )
            pts[ i ] = new Point( xInts.remove( 0 ), 0.0 );
        return pts;
    }
    
    /**
     * Calculates the Points of intersection for two Polynomial Functions on the closed
     *  interval [ MIN, MAX ]
     *
     * @param f a Polynomial Function
     * @param g an other Polynomial Function
     * @return the Point[] for the intersection of f and g, with zero Points possible
     */
    public static Point[] intersect( Polynomial f, Polynomial g )
    {
        return xIntercepts( Polynomial.subtract( f, g ) );
    }
}
