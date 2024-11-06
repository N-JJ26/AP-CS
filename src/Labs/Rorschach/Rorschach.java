package src.Labs.Rorschach; //REMOVE THIS

/**
 * JAVADOC GOES HERE
 *
 * @author Nate Johnson
 * @version 10/31/24
 */
public class Rorschach
{
    /*TODO:
     * remove the parameters and the package declaration
     * get methods working
     *  top()
     *  bottom()
     * find errors
     */
    private char[][] seed;
    private static UI ui = new UI();
    private static Rorschach rorschach = new Rorschach();

    /**
     * The main entry point of the Rorschach lab. Runs the program
     */
    public static void main(String[] args /*REMOVE THIS */)
    {
        while( true )
        {
            rorschach.seed = ui.getPattern();
            while( true )
            {
                System.out.println();
                ui.display( rorschach.seed );
                switch( ui.getFold() )
                {
                    case 'l':
                        rorschach.seed = rorschach.left();
                        ui.display( rorschach.seed );
                        break;
                    case 'r':
                        rorschach.seed = rorschach.right();
                        ui.display( rorschach.seed );
                        break;
                    case 't':
                        rorschach.seed = rorschach.top();
                        ui.display( rorschach.seed );
                        break;
                    default:
                        rorschach.seed = rorschach.bottom();
                        ui.display( rorschach.seed );
                        break;
                }
                if( !ui.continueFolding() )
                    break;
            }
            if( !ui.continueProgram() )
                    break;
        }
    }

    private char[][] left()
    {
        char[][] folded = new char[ seed.length ][ 2 * seed[ 0 ].length ];
        char[][] flipped = horizontalFlip( seed );

        for( int i = 0; i < folded.length; i++ )
            for( int j = 0; j < seed[ 0 ].length; j++ )
                folded[ i ][ j ] = flipped[ i ][ j ];

        for( int i = 0; i < folded.length; i++ )
            for( int j = 0; j < seed[ 0 ].length; j++ )
                folded[ i ][ seed[ 0 ].length + j ] = seed[ i ][ j ];

        return folded;
    }

    private char[][] right()
    {
        char[][] folded = new char[ seed.length ][ 2 * seed[ 0 ].length ];
        char[][] flipped = horizontalFlip( seed );

        for( int i = 0; i < folded.length; i++ )
            for( int j = 0; j < seed[ 0 ].length; j++ )
                folded[ i ][ j ] = seed[ i ][ j ];

        for( int i = 0; i < folded.length; i++ )
            for( int j = 0; j < seed[ 0 ].length; j++ )
                folded[ i ][ seed[ 0 ].length + j ] = flipped[ i ][ j ];

        return folded;
    }

    private char[][] horizontalFlip( char[][] pattern )
    {
        pattern = new char[ seed.length ][ seed[ 0 ].length ];

        for( int i = 0; i < pattern.length; i++ )
            for( int j = 0; j < pattern[ 0 ].length; j++ )
                pattern[ i ][ j ] = seed[ i ][ seed[ 0 ].length - 1 - j];

        return pattern;
    }

    private char[][] top()
    {
        char[][] folded = new char[ 2 * seed.length ][ seed[ 0 ].length ];
        char[][] flipped = verticalFlip( seed );

        for( int i = 0; i < seed.length; i++ )
            for( int j = 0; j < folded[ 0 ].length; j++ )
                folded[ i ][ j ] = flipped[ i ][ j ];

        for( int i = 0; i < seed.length; i++ )
            for( int j = 0; j < folded[ 0 ].length; j++ )
                folded[ seed.length + i ][ j ] = seed[ i ][ j ];


        return folded;
    }

    private char[][] bottom()
    {
        char[][] folded = new char[ 2 * seed.length ][ seed[ 0 ].length ];
        char[][] flipped = verticalFlip( seed );

        for( int i = 0; i < seed.length; i++ )
            for( int j = 0; j < folded[ 0 ].length; j++ )
                folded[ i ][ j ] = seed[ i ][ j ];

        for( int i = 0; i < seed.length; i++ )
            for( int j = 0; j < folded[ 0 ].length; j++ )
                folded[ seed.length + i ][ j ] = flipped[ i ][ j ];

        return folded;
    }

    private char[][] verticalFlip( char[][] pattern )
    {
        pattern = new char[ seed.length ][ seed[ 0 ].length ];

        for( int i = 0; i < pattern.length; i++ )
            for( int j = 0; j < pattern[ 0 ].length; j++ )
                pattern[ i ][ j ] = seed[ seed.length - 1 - i ][ j ];

        return pattern;
    }
}
