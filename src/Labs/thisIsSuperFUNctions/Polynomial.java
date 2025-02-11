package src.Labs.thisIsSuperFUNctions;

public class Polynomial extends Function
{
    private double[] a;

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

    public int degree()
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
                    ( num.charAt( 0 ) == '-' ? " - " + num.substring( 1 ) : " + " + a[ 0 ] );
        return str;
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

        double multiplier = add ? 1 : -1 ;
        for( int i = shorter; i < longer; i++ )
            c[i] = longer == b.coefficients().length ?
                multiplier * b.coefficients()[ i ] :
                multiplier * a.coefficients()[ i ];

        return new Polynomial( c );
    }

    public static void main(String[] args) {
        Vertex p = new Vertex(1.5, 4, 2);

        System.out.println(p);
        System.out.println(p.transformations());
    }
}
