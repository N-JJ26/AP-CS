package src.Labs.thisIsSuperFUNctions;

public class Quadratic extends Polynomial
{
    public Quadratic( double a, double b, double c )
    {
        super( new double[]{ a, b, c } );
    }

    public Quadratic()
    {
        this(1, 0, 0);
    }

    public Point vertex()
    {
        return Calc.derivative( this ).xIntercepts()[ 0 ];
    }

    public Point[] xIntercepts( boolean allowComplex )
    {
        return this.xIntercepts();
    }
}
