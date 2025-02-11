package src.Labs.thisIsSuperFUNctions;

/**
 * Interval is an open or closed interval ( a, b ) or [ a, b ], etc
 *  such that the left-bound x-value a and a right-bound x-value b are a <= b 
 *
 * @author Mr. DeGroat
 * @version March 8, 2024
 */
public class Interval
{
    private double left;
    private boolean includeLeft;
    private double right;
    private boolean includeRight;
    
    /**
     * Check and sets the left-bound and right-bound of the Interval
     *
     * @param a the presumed left-bound of the Interval
     * @param b the presumed right-bound, may be equal to a,
     *           if < b, then switched with a
     * @param includeA true if it is included, false if excluded
     * @param includeB true if it is included, false if excluded
     */
    public Interval( double a, boolean includeA,
                                double b, boolean includeB )
    {
        if( Math.abs( a - b ) < Calc.EPSILON )
        {
            b = a;
            includeB = includeA;
        }
        
        if( a > b )
        {
            double temp = a;
            boolean tempInclude = includeA;
            a = b;
            includeA = includeB;
            b = temp;
            includeB = tempInclude;
        }
        
        this.left = a;
        this.includeLeft = includeA;
        this.right = b;
        this.includeRight = includeB;
    }
    
    /**
     * Returns the left-bound of the Interval
     *
     * @return the left-bound of the Interval
     */
    public double getLeftBound()
    {
        return left;
    }
    /**
     * Returns if the left-bound is included
     *
     * @return true if the left-bound is included, false otherwise
     */
    public boolean leftIncluded()
    {
        return includeLeft;
    }
    
    /**
     * Returns the right-bound of the Interval
     *
     * @return the right-bound of the Interval
     */
    public double getRightBound()
    {
        return right;
    }
    /**
     * Returns if the right-bound is included
     *
     * @return true if the right-bound is included, false otherwise
     */
    public boolean rightIncluded()
    {
        return includeRight;
    }
    
    /**
     * Returns true if the given x-value is included in the interval
     *
     * @param x the x-value to be tested
     * @return true if the given x-value is included in the interval, false otherwise
     */
    public boolean contains( double x )
    {
        return includeLeft && Math.abs( x - left ) < Calc.EPSILON ||
                includeRight && Math.abs( x - right ) < Calc.EPSILON ||
                left < x && x < right;
    }
    
    /**
     * Returns true if the given x-values are included in the interval
     * 
     * @param a the left-bound x-value to be tested
     * @param b the right-bound x-value to be tested
     * @return true if the given x-values are included in the interval, false otherwise
     *         or if a >= b
     */
    public boolean contains( double a, double b )
    {
        return Math.abs( a - b ) > Calc.EPSILON && a < b &&
                contains( a ) && contains( b );
    }
    
    /**
     * Returns true if the given Interval is included in the interval
     * 
     * @param domain the Interval to be tested
     * @return true if the given Interval is included in the interval, false otherwise
     */
    public boolean contains( Interval domain )
    {
        return contains( domain.getLeftBound(), domain.getRightBound() );
    }
    
    /**
     * Returns true if the given Interval is the same as this Interval
     *
     * @param obj an Object to be tested
     * @return true if the parameter is a Interval and the left and right bounds match,
     *         false otherwise
     */
    public boolean equals( Object obj )
    {
        if( obj == null || !( obj instanceof Interval ) )
            return false;
        
        Interval domain = (Interval)obj;
        return Math.abs( left - domain.getLeftBound() ) < Calc.EPSILON &&
                includeLeft == domain.leftIncluded() &&
                Math.abs( right - domain.getRightBound() ) < Calc.EPSILON &&
                includeRight == domain.rightIncluded();
    }
    
    /**
     * Returns the interval notation
     * 
     * @return ex. [ a, b ] or ( a, b ] or ( -inf, +inf ), etc
     */
    public String toString()
    {
        String str = "";
        
        if( includeLeft )
            str += "[ ";
        else
            str += "( ";
        
        if( ( new Double( left ) ).equals( Double.NEGATIVE_INFINITY ) )
            str += "-inf, ";
        else
            str += Calc.clean( left ) + ", ";
        
        if( ( new Double( right ) ).equals( Double.POSITIVE_INFINITY ) )
            str += "+inf";
        else
            str += Calc.clean( right );
        
        if( includeRight )
            str += " ]";
        else
            str += " )";
        
        return str;
    }
}
