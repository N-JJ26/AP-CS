package src.Labs.thisIsSuperFUNctions;

public class Polynomial extends Function
{
    private double[] a;

    public Polynomial( double[] coefficients )
    {
        this.a = coefficients;
    }

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

    public int compareTo( Polynomial other, Interval interval )
    {
        if ( other == null || interval == null
            || interval.getLeftBound() > interval.getRightBound() )
            return 1;

        double intervalLength = interval.getRightBound() - interval.getLeftBound();

        if( Calc.areaUnder( this, interval ) / intervalLength
            > Calc.areaUnder( other, interval ) / intervalLength )
            return 1;
        if( Calc.areaUnder( this, interval ) / intervalLength
            < Calc.areaUnder( other, interval ) / intervalLength )
            return -1;
        else
            return 0;
    }

    //public Interval[] decreasing

    //public Interval[] increasing

    public double fOf( double x )
    {
        double sum = 0;
        for( int i = 0; i < a.length; i++ ) {
            sum += a[ i ] * Math.pow( x, ( double )i );
        }
        return sum;
    }

    public double fPrimeOf( double a )
    {
        return Calc.derivative( this ).fOf( a );
    }

    public PointSlope tangent( double x )
    {
        return new PointSlope( new Point( x, fOf( x ) ), fPrimeOf( x ) );
    }

    public Point[] xIntercepts()
    {
        return Calc.xIntercepts( this );
    }

    public double yIntercept()
    {
        return a[ 0 ];
    }

    public double degree()
    {
        return a.length - 1;
    }

    public double leadingCoefficient()
    {
        return a[ a.length - 1 ];
    }

    public double[] coefficients()
    {
        return a;
    }

    public boolean isOnCurve( Point p )
    {
        return Math.abs( fOf( p.getX() ) - p.getY() ) < Calc.EPSILON;
    }

    public boolean equals( Polynomial other )
    {
        return false;
    }

    public String toString()
    {
        return "!";
    }

    public static Polynomial add( Polynomial a, Polynomial b )
    {
        return null;
    }

    public static Polynomial subtract( Polynomial a, Polynomial b )
    {
        return null;
    }
}
