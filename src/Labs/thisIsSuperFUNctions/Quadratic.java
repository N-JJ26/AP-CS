package src.Labs.thisIsSuperFUNctions;

public class Quadratic extends Polynomial
{
    public Quadratic( double a, double b, double c )
    {
        super( new double[]{ c, b, a } );
    }

    public Quadratic()
    {
        this(1, 0, 0);
    }

    public Point vertex()
    {
        double xValue = Calc.derivative( this ).xIntercepts()[ 0 ].getX();
        return new Point( xValue, this.fOf(xValue) );
    }

    public Point[] xIntercepts( boolean allowComplex )
    {
        return this.xIntercepts();
    }
}
