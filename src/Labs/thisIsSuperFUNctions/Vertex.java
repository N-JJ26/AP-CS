package src.Labs.thisIsSuperFUNctions;

/**
 * Quadratic Polynomial Function of the form a*( x - h )^2 + k
 *
 * @author Avi D. Nate J
 * @version February 12, 2025
 */
public class Vertex extends Quadratic
{
    private Point vertex;

    /**
     * Constructs a Quadratic Polynomial Function of the form a*( x - h )^2 + k
     * with stretch/shrink = a, and vertex = ( h, k )
     *
     * @param a the stretch/shrink of the parabola (!=0, defaults to y= x^2 )
     * @param h the x-coordinate of the vertex
     * @param h the x-coordinate of the vertex
     */
    public Vertex( double a, int h, int k )
    {
        super( checkA(a, h, k), -2 * h * a, a * h * h + k );

        vertex = new Point( h, k );
    }

    private static double checkA( double a, int h, int k )
    {
        if( Math.abs( a - 0.0 ) < Calc.EPSILON )
        {
            a = 1.0;
            h = 0;
            k = 0;
        }
        return a;
    }

    /**
     * Lists the transformations: right-side up/upside down, stretch/shrink,
     * left/right, up/down of the Quadratic in Vertex form from the basic: y = x^2
     *
     * @return the transformations of the Quadratic
     */
    public String transformations()
    {
        double a = this.leadingCoefficient();
        String str = "";

        if( a > 0 )
            str += "right-side up/upside down: right-side up";
        else
            str += "right-side up/upside down: upside down";

        str += "\n";
        if( Math.abs( a ) < 1.0 && Math.abs( a ) > 0.0 )
            str += "stretch/squish: stretched by " + a;
        else if( Math.abs( a ) > 1.0 )
            str += "stretch/squish: squished by " + a;

        str += "\n";
        if( vertex.getX() > 0 )
            str += "left/right: right by " + vertex.getX();
        else if( vertex.getY() < 0 )
            str += "left/right: left by " + vertex.getX();

        str += "\n";
        if( vertex.getY() > 0 )
            str += "up/down: right by " + vertex.getY();
        else if( vertex.getY() < 0 )
            str += "up/down: left by " + vertex.getY();

        return str;
    }

    /**
     * Shows the Quadratic Polynomial Function in vertex form
     *
     * @return the Polynomial written in the form "y = a*(x - h)^2 + k"
     */
    public String toString()
    {
        double[] nums = new double[]{
            this.leadingCoefficient(),
            vertex.getX(),
            -vertex.getY()
        };

        String[] numStr = new String[ nums.length ];

        numStr[ 0 ] = Calc.clean( nums[ 0 ] );

        for( int i = 1; i < nums.length; i++ )
            if( nums[ i ] == 0.0 )
                numStr[ i ] = "";
            else if( ( "" + nums[ i ] ).charAt( 0 ) == '-' )
                numStr[ i ] = " + " + Calc.clean( nums[ i ] ).substring( 1 );
            else
                numStr[ i ] = " - " + Calc.clean( nums[ i ] );

        return "y = " + numStr[ 0 ] +
                "(x" + numStr[ 1 ] + ")^2" + numStr[ 2 ];
    }

    /**
     * Returns the String that represents the Quadratic Function as
     * f(x) = a*x^2 + b*x + c
     *
     * @return the Polynomial written in descending order, ex. f(x) = 5x^2 + 7x - 1
     */
    public String toString( boolean generalForm )
    {
        if( generalForm )
            return super.toString();
        else
            return this.toString();
    }
}
