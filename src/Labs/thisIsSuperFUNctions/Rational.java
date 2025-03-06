package src.Labs.thisIsSuperFUNctions;

import java.util.ArrayList;

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
        ArrayList< Point > numeratorInts = new ArrayList< Point >();
        ArrayList< Point > denominatorInts = new ArrayList< Point >();

        ArrayList< Double > xValues = new ArrayList< Double >();

        for( Point point : numerator.xIntercepts() )
            numeratorInts.add( point );

        for( Point point : denominator.xIntercepts() )
            denominatorInts.add( point );

        for( int i = 0; i < numeratorInts.size(); i++ )
            if( denominatorInts.contains( numeratorInts.get( i ) ) )
                xValues.add( numeratorInts.get( i ).getX() );

        Point[] holes = new Point[ xValues.size() ];

        for( int i = 0; i < holes.length; i++ )
            holes[ i ] = new Point( xValues.get( i ), lHopitalAt( xValues.get( i ) ) );

        return holes;
    }

    private double lHopitalAt( double value )
    {
        return numerator.fPrimeOf( value ) / denominator.fPrimeOf( value );
    }

    public double[] asymptotes()
    {
        ArrayList< Point > numeratorInts = new ArrayList< Point >();
        ArrayList< Point > denominatorInts = new ArrayList< Point >();

        ArrayList< Double > xValues = new ArrayList< Double >();

        for( Point point : numerator.xIntercepts() )
            numeratorInts.add( point );

        for( Point point : denominator.xIntercepts() )
            denominatorInts.add( point );

        for( int i = 0; i < denominatorInts.size(); i++ )
            if( !numeratorInts.contains( denominatorInts.get( i ) ) )
                xValues.add( denominatorInts.get( i ).getX() );

        double[] asymptotes = new double[ xValues.size() ];

        for( int i = 0; i < asymptotes.length; i++ )
            asymptotes[ i ] = xValues.get( i );

        return asymptotes;
    }

    public String toString()
    {
        final int BEGINNING_INDEX = 7;

        return "y = (" + numerator.toString().substring( BEGINNING_INDEX )
                + ")/(" + denominator.toString().substring( BEGINNING_INDEX ) + ")";
    }
}
