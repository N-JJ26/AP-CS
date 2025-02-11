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

    public String toString()
    {
        return "y = " + this.leadingCoefficient() +
                "*(x - " + vertex.getX() + ")^2 + " + vertex.getY();
    }

    public String toString( boolean generalForm )
    {
        if( generalForm )
            return super.toString();
        else
            return this.toString();
    }
}
