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
        if( Math.abs( a - 0.0 ) < Calc.EPSILON ) {
            a++;
            h -= h;
            k -= k;
        }

        vertex = new Point( h, k );

        super( a, -2 * h * a, a * h * h + k );
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
        String str = "right-side up/upside down: ";

        if( Math.abs( a - 0.0 ) < Calc.EPSILON )
            str += "right-side up";
        else
            str += "upside down";

        str += "\nstretch/squish: ";
        if( Math.abs( a ) < 1.0 && Math.abs( a ) > 0.0 )
            str += "squished by " + a;
        else
            str += "stretched by " + a;

        str += "\nleft/right: ";
        if( vertex.getX() > 0 )
            str += "right by " + vertex.getX();
        else
            str += "left by " + vertex.getX();

        str += "\nup/down: ";
        if( vertex.getY() > 0 )
            str += "right by " + vertex.getY();
        else
            str += "left by " + vertex.getY();

        return str;
    }

    /**
     * Shows the Quadratic Polynomial Function in vertex form
     *
     * @return the Polynomial written in the form "y = a*(x - h)^2 + k"
     */
    public String toString()
    {
        return super.toString();
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
