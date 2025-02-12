package src.Labs.thisIsSuperFUNctions;

/**
* Quadratic Polynomial Function in standard form a*x^2 + b*x + c
*
* @author Avi D, Nate J.
* @version February 12, 2025
*/
public class Quadratic extends Polynomial
{
   /**
    * Constructs a Quadratic Polynomial Function of the form a*x^2 + b*x + c
    *
    * @param a the coefficient of the squared-term ( !=0 )
    * @param b the coefficient of the linear term
    * @param c the constant
    */
    public Quadratic( double a, double b, double c )
    {
        super( new double[]{ c, b, a } );
    }

   /**
    * Constructs a Quadratic Polynomial Function of the form a*x^2 + b*x + c
    *
    */
    public Quadratic()
    {
        this(1, 0, 0);
    }

   /**
    * Constructs a Quadratic Polynomial Function of the form a*x^2 + b*x + c
    *
    * @return 
    */
    public Point vertex()
    {
        double xValue = Calc.derivative( this ).xIntercepts()[ 0 ].getX();
        return new Point( xValue, this.fOf(xValue) );
    }

   /**
    * Constructs a Quadratic Polynomial Function of the form a*x^2 + b*x + c
    *
    * @param a the coefficient of the squared-term ( !=0 )
    * @return c the constant
    */
    public Point[] xIntercepts( boolean allowComplex )
    {
        return this.xIntercepts();
    }
}
