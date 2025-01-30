package src.Labs.thisIsSuperFUNctions;

public class Linear extends Polynomial
{
    public Linear( int m, int b )
    {
        super( new double[]{ m, b } );
    }

    public Linear()
    {
        this( 1, 0 );
    }
}
