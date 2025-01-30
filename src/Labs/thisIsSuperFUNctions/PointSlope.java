package src.Labs.thisIsSuperFUNctions;

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
        this.point = point;
        super( slope, slope * point.getX() + point.getY() );
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
        if( point == null )
        {
            return;
        }
        this.point = point;
    }
}
