package src.Labs.thisIsSuperFUNctions;

/**
 * A superclass for the top of the hierarchy within
 *  this program, handles Function notation
 *
 * @author Mr. DeGroat
 * @version March 8, 2024
 */
public class Function
{
    private static int totalPolys = 0;
    private int numPoly;
    private boolean isPoly;
    
    /**
     * Constructs a Function object, keeping track of Function notation
     */
    public Function()
    {
        numPoly = ++totalPolys;
        isPoly = true;
    }
    
    /**
     * Constructs a Function object, keeping track of Function notation as necessary
     *  (Function notation is reserved for Polynomial Functions)
     *
     * @param isPoly true if the Function is a Polynomial, false otherwise
     */
    public Function( boolean isPoly )
    {
        this();
        if( isPoly )
            return;
        
        totalPolys--;
        numPoly = -1;
        this.isPoly = isPoly;
    }
    
    /**
     * A method that should be overridden but will allow for compilation
     *
     * @param x the x-value to be plugged into the Function
     * @return the y-value cooresponding to the x-value of the Function
     */
    public double fOf( double x )
    {
        return Double.NaN;
    }
    /**
     * A method that should be overridden but will allow for compilation
     *
     * @param x the x-value to be plugged into the Function's derivative
     * @return the slope of the line tangent to the graph of the Function at the given x-value
     */
    public double fPrimeOf( double x )
    {
        return Double.NaN;
    }

    /**
     * <b> ** BONUS ** </b>
     * A method that should be overridden, but could be correct and will allow for compilation
     *  defaults to an empty array, {}
     *
     * @return the open interval of x-values on which the function is increasing, i.e. slope > 0.0
     */
    public Interval[] increasing()
    {
        return new Interval[]{};
    }
    /**
     * <b> ** BONUS ** </b>
     * A method that should be overridden, but could be correct and will allow for compilation
     *  defaults to an empty array, {}
     *
     * @return the open interval of x-values on which the function is decreasing, i.e. slope < 0.0
     */
    public Interval[] decreasing()
    {
        return new Interval[]{};
    }
    /**
     * <b> ** BONUS ** </b>
     * A method that could be overridden, but is correct for Polynomials and will allow for compilation
     *  defaults to an empty array, {}
     *
     * @return the open interval of x-values on which the function is constant, i.e. slope == 0.0
     */
    public Interval[] constant()
    {
        return new Interval[]{};
    }
    
    /**
     * Generates Function notation starting with "f(x) = ", skipping "i(x) = ",
     *  and after "w(x) = ", maintains "y = " for successive Function objects
     *
     * @return Function notation or "y = "
     */
    public String toString()
    {
        final int W = 17;
        
        if( !isPoly || numPoly > W )
            return "y = ";
        
        if( numPoly <= 3 )
            return (char)('f' + ( numPoly - 1 )) + "(x) = ";
        
        return (char)('f' + numPoly ) + "(x) = ";
    }
}
