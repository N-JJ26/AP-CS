package src.Labs.thisIsSuperFUNctions;

public class Polynomial
{
    private double[] a;

    public Polynomial( double[] coefficients )
    {
        this.a = coefficients;
    }

    public int compareTo( Polynomial other, double a, double b )
    {
        return 0;
    }

    public int compareTo( Polynomial other, Interval interval )
    {
        return 0;
    }

    //public Interval[] decreasing

    //public Interval[] increasing

    public double fOf()
    {
        return 0.0;
    }

    public double fPrimeOf()
    {
        return 0.0;
    }

    public PointSlope tangent()
    {
        return null;
    }

    public double[] xIntercepts()
    {
        return null;
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

    public boolean isOnCurve()
    {
        return false;
    }

    public boolean equals()
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
