package src.Labs.thisIsSuperFUNctions;

public class Vertex extends Quadratic
{
    private Point vertex;

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

    public String toString()
    {
        return super.toString();
    }

    public String toString( boolean generalForm )
    {
        if( generalForm )
            return super.toString();
        else
            return this.toString();
    }
}
