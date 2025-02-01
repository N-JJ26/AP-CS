package src.Labs.thisIsSuperFUNctions;

public class Linear extends Polynomial
{
    public Linear( double m, double b )
    {
        super( new double[]{ m, b } );
    }

    public Linear()
    {
        this( 1, 0 );
    }

    public double slope()
    {
        return this.leadingCoefficient();
    }

    
}
