package src.Labs.thisIsSuperFUNctions;

import java.util.ArrayList;

public class Runner
{
    private static Polynomial[] polys;
    
    /**
     * Executes to solve a preset list of polynomial equations
     */
    public static void main()
    {
        polys = new Polynomial[]{ new Polynomial( new double[]{ 0, -4, 1 } ),
                                new Polynomial( new double[]{ 5, 0, 0, 6 } ),
                                new Polynomial( new double[]{ 0, 0, -11, 1, 0, 9, 0, 0, 0 } ),
                                new Polynomial( new double[]{ -9, 1, -5, 7 } ),
                                new Polynomial( new double[]{ 11, 0, 8 } ),
                                new Polynomial( new double[]{ 0, 2 } ),
                                new Polynomial( new double[]{ -1, 2 } ),
                                new Linear( -1, -3 ),
                                new Linear( 1, 0 ),
                                new Quadratic( 5, 8, 9 ),
                                new Quadratic( 1, -4, 0 ),
                                new Quadratic( 1, 0, 0 ),
                                new Quadratic(),
                                new Standard( 1, 1, -3 ),
                                new Standard( 2, 3, 6 ),
                                new Standard( 2, -1, 1 ),
                                new PointSlope( new Point( 1, -2 ), 3 ),
                                new PointSlope( new Point( 0, 0 ), 2 ),
                                new PointSlope( new Point( -1, -3 ), 0.5 ),
                                new Cubic( 6, 0, 0, 5 ),
                                new Cubic( 2, 2, -1 ),
                                new Cubic( 7, -5, 1, -9 ),
                                new Cubic( 4, 4, 4 ),
                                new Cubic( 5, 5, 6 ),
                                new Cubic( 7, 8, 9 ),
                                new Factored( 1, -1 ),
                                new Factored( -3, -3 ),
                                new Factored( 2, -5 ),
                                new Quadratic( 1, -6, 9 ),
                                new Polynomial( new double[]{ -1, 0, 1 } ),
                                new Vertex( 1, 0, -1 ),
                                new Vertex( -1, 3, -2 ),
                                new Vertex( 2, -4, -2 ),
                                new Vertex( -0.5, -1, 2 ),
                                new Vertex( Math.PI, (int)( 2.0 / 7 ), (int)Math.cos( -Math.PI / 3 ) )
                                };
        
        System.out.println( "Full List:" );
        print();
        
        eliminateRepeats();
        System.out.println( "\n\n" + "Elminiated Repeats:" );
        print();
        
        
        sortByCompareTo();
        System.out.println( "\n\n" + "Sorted:" );
        print();
        
        System.out.println( "\n\n" + "Intercepts:" );
        printIntercepts();
        
        System.out.println( "\n\n" + "Transformations:" );
        printTransformations();
        
        System.out.println( "\n\n" + "Special toString():" );
        printToStrings();
        
        System.out.println( "\n\n" + "tangent( 0 ):" );
        tangents( 0 );
        System.out.println( "\n\n" + "tangent( 1 ):" );
        tangents( 1 );
        System.out.println( "\n\n" + "tangent( -1 ):" );
        tangents( -1 );
        
        System.out.println( "\n\n" + "Additions:" );
        additions();
        System.out.println( "\n\n" + "Subtractions:" );
        subtractions();
    }
    private static void print()
    {
        for( Polynomial poly : polys )
            System.out.println( poly );
    }
    private static void eliminateRepeats()
    {

        ArrayList< Polynomial > polyList = new ArrayList< Polynomial >();

        for( int i = 0; i < polys.length; i++ )
            polyList.add( polys[ i ] );

        for(int i = 1; i < polyList.size(); i++)
            if( polyList.get( i ).equals( polyList.get( i - 1 ) ) )
                polyList.remove( i );

        Polynomial[] newList = new Polynomial[ polyList.size() ];

        for( int i = 0; i < newList.length; i++ )
            newList[ i ] = polyList.get( i );

        polys = newList;
    }
    private static void sortByCompareTo()
    {
        final int LEFT_BOUND = -10;
        final int RIGHT_BOUND = 10;
        
        for( int i = 1; i < polys.length - 1; i++ )
        {
            boolean changed = false;
            for( int j = 0; j < polys.length - i; j++ )
                if( polys[ j ].compareTo( polys[ j + 1 ], LEFT_BOUND, RIGHT_BOUND) == 1 )
                {
                    Polynomial temp = polys[ j ];
                    polys[ j ] = polys[ j + 1 ];
                    polys[ j + 1 ] = temp;

                    changed = true;
                }
            if( !changed )
                break;
        }
    }
    private static void printIntercepts()
    {
        for( Polynomial poly : polys )
        {
            System.out.print( poly + "\n" + "y-int = " + poly.yIntercept() + "\n" + "x-int(s) = " );
            Point[] pts = poly.xIntercepts();
            if( pts.length > 0 )
            {
                System.out.print( pts[ 0 ] );
                for( int i = 1; i < pts.length; i++ )
                    System.out.print( ", " + pts[ i ] );
            }
            System.out.println();
            
            if( poly instanceof Quadratic )
            {
                Point[] complex = ( (Quadratic)poly ).xIntercepts( true );
                System.out.print( "complex zeros (a+bi) = " + complex[ 0 ] );
                if( complex.length > 1 )
                    System.out.print( " and " + complex[ 1 ] );
                System.out.println();
            }
            System.out.println();
        }
    }
    private static void printTransformations()
    {
        for( Polynomial poly : polys )
            if( poly instanceof Vertex )
                System.out.println( poly + "\n" + ( (Vertex)poly ).transformations() );
    }
    private static void printToStrings()
    {
        for( Polynomial poly : polys )
        {
            if( poly instanceof Factored )
                toStrings( (Factored)poly );
            else if( poly instanceof Standard )
                toStrings( (Standard)poly );
        }
    }
    private static void toStrings( Factored poly )
    {
        System.out.println( poly.toString( true ) + "\n" + poly.toString( false ) );
    }
    private static void toStrings( Standard poly )
    {
        System.out.println( poly.toString( true ) + "\n" + poly.toString( false ) );
    }
    private static void tangents( double x )
    {
        for( Polynomial poly : polys )
            System.out.println( poly.tangent( x ) );
    }
    private static void additions()
    {
        for( int i = 0; i < polys.length - 1; i += 2 )
            System.out.println( Polynomial.add( polys[ i ], polys[ i + 1 ] ) );
    }
    private static void subtractions()
    {
        for( int i = 0; i < polys.length - 1; i += 2 )
            System.out.println( Polynomial.subtract( polys[ i ], polys[ i + 1 ] ) );
    }
}
