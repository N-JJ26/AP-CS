package src.Labs.thisIsSuperFUNctions;

public class Cubic extends Polynomial
{
    private String toStr;

    public Cubic( int a, int b, int c, int d )
    {
        super( new double[]{ a, b, c, d } );
    }

    public Cubic( int p, int q, int r )
    {
        this( 0, 0, 0, 0 );
    }

    public String toString()
    {
        return "!";
    }
}
