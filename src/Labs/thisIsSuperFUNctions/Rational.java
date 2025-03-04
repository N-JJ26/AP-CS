package src.Labs.thisIsSuperFUNctions;

public class Rational extends Function
{
    private Polynomial numerator, denominator;

    public Rational( Polynomial numerator, Polynomial denominator )
    {
        super( false );

        if( numerator.equals( new Polynomial( new double[]{ 0 } ) ) )
            numerator = new Polynomial( new double[]{ 1 } );

        if( denominator.degree() < 1 )
            denominator = new Polynomial( new double[]{ 0, 1 } );

        this.numerator = numerator;
        this.denominator = denominator;
    }

    public double fOf( double x )
    {
        return numerator.fOf( x ) / denominator.fOf( x );
    }

    public Point[] holes()
    {
        
        return null;
    }

    public double[] asymptotes()
    {
        return null;
    }
}
