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
     * find errors
     */
    private char[][] seed;
    private static UI ui = new UI();
    private static Rorschach rorschach = new Rorschach();

    /**
     * JAVADOC
     *
     * @param args
     */
    public static void main(String[] args /*REMOVE THIS */)
    {
        while( true )
        {
            rorschach.seed = ui.getPattern();
            while( true )
            {
                switch( ui.getFold() )
                    {
                        case 'L':
                            rorschach.seed = rorschach.left();
                            ui.display( rorschach.seed );
                            break;
                        case 'R':
                            break;
                        case 'T':
                            break;
                        default:
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
        char[][] folded = new char[ seed.length ][ 2 * seed[0].length ];
        
        return folded;
    }

    private char[][] right()
    {
        char[][] folded = new char[ seed.length ][ 2 * seed[0].length ];
        return folded;
    }

    private char[][] top()
    {
        return null;
    }

    private char[][] bottom()
    {
        return null;
    }
}
