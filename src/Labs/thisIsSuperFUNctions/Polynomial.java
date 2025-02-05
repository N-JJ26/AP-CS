package src.Labs.thisIsSuperFUNctions;

public class Polynomial extends Function
{
    private double[] a;

    public Polynomial( double[] coefficients )
    {
        super(); //unnecessary
        a = coefficients;
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
        double[] copy = new double[ a.length ];
        for( int i = 0; i < copy.length; i++ )
            copy[ i ] = a[ i ];
        return a;
    }

    public boolean isOnCurve( Point p )
    {
        return Math.abs( fOf( p.getX() ) - p.getY() ) < Calc.EPSILON;
    }

    public boolean equals( Polynomial other )
    {
        if( other.coefficients().length != a.length || other == null )
            return false;
        for(int i = 0; i < a.length; i++)
            if( Math.abs( a[ i ] - other.coefficients()[ i ] ) > Calc.EPSILON )
                return false;
        return true;
    }

    public String toString()
    {
        String str = "y = ";
        for( int i = a.length - 1; i >= 0; i-- ) {
            String num = "" + a[i];
            str += ( num.charAt( 0 ) == 'y' ? "" : "+" ) +
                        a[ i ] + "x^" + i;
        }
        return str;
        //TODO: make work
    }

    public static Polynomial add( Polynomial a, Polynomial b )
    {
        return arithmetic(a, b, true);
    }

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

        for( int i = shorter; i < longer; i++ )
            c[i] = longer == b.coefficients().length ?
                b.coefficients()[ i ] : a.coefficients()[ i ];

        return new Polynomial( c );
    }

    public static void main(String[] args) {
        
    }
}
