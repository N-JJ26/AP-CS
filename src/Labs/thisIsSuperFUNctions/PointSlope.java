package src.Labs.thisIsSuperFUNctions;

/**
 * Linear Polynomial Function in point-slope form y - y0 = m*( x - x0 ) 
 *  where the Point = ( x0, y0 ) is any point on the line and m != 0
 *
 * @author Nate J, Avi D.
 * @version February 26, 2025
 */
public class PointSlope extends Linear
{
    private Point point;

    /**
     * Constructs a PointSlopeForm Linear Polynomial Function y - y0 = m*( x - x0 ),
     *  where ( x0, y0 ) is a Point on the line
     *
     * @param point any lattice Point on the line
     * @param slope the slope of the line
     */
    public PointSlope( Point point, double slope )
    {
        super( slope, slope * checkPoint( point ).getX() + checkPoint( point ).getY() );

        this.point = checkPoint(point);
    }

    private static Point checkPoint( Point p )
    {
        if( p == null )
            return new Point();
        return p;
    }

    /**
     * Returns the current Point used in the Point-Slope form of the line
     *
     * @return a Point on the line currently used in Point-Slope
     */
    public Point getPoint()
    {
        Point temp = point;
        return temp;
    }

    /**
     * Changes the Point used in the Point-Slope form from the current Point
     *  to another Point on the line, defaults back to the current Point
     *
     * @param point a new Point that will be checked if it is on the line
     *              to replace the current Point
     */
    public void setPoint( Point point )
    {
        if( point == null || isOnCurve( point ) )
            return;
        this.point = point;
    }

    public String toString()
    {
        String[] nums = new String[]{"" + point.getX(),
                                    "" + point.getY()};

        for( int i = 0; i < nums.length; i++ )
            if( nums[ i ].charAt( 0 ) == '-' )
                nums[ i ] = " + " + nums[ i ].substring( 1 );
            else
                nums[ i ] = " - " + nums[ i ];
        return "y" + nums[ 1 ] + " = " + this.leadingCoefficient() + "*(x" + nums[ 0 ] +
                    ")";
    }

    public String toString( boolean slopeIntercept )
    {
        if( slopeIntercept )
            return super.toString();
        else
            return this.toString();
    }
}
