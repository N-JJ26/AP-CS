package src.Labs.Rorschach; //REMOVE THIS

import java.util.Scanner;

/**
 * JAVADOC GOES HERE
 *
 * @author Nate Johnson
 * @version 10/31/24
 */
public class UI
{
    /*TODO:
     * remove the package declaration
     * find errors
     * javadoc
     */
    private Scanner in;
    private char[][] pattern;

    /**
     * JAVADOC
     */
    public UI()
    {
        in = new Scanner( System.in );
    }

    /**
     * JAVADOC
     * @return
     */
    public char[][] getPattern()
    {
        System.out.print( "Enter the amount of rows:   " );
        int rows = in.nextInt();
        in.nextLine();

        System.out.print( "Enter the amount of columns:   " );
        int cols = in.nextInt();
        in.nextLine();

        pattern = new char[ rows ][ cols ];

        System.out.println("Enter the seed pattern with either spaces or \"*\".\n" +
                        "Press enter when finished with the line to move to the next" );

        for( int i = 0; i < pattern.length; i++ )
        {
            String answer = in.nextLine();
            for( int j = 0; j < answer.length(); j++ )
                pattern[i][j] = answer.charAt(j);
        }

        System.out.println();

        return pattern;
    }

    /**
     * JAVADOC
     * @return
     */
    public boolean continueProgram()
    {
        System.out.print( "Would you like to create another \"Rorschach\" pattern?  " );

        if( in.nextLine().toLowerCase().charAt (0 ) == 'y')
            return true;
        else
            return false;
    }

    /**
     * JAVADOC
     * @return
     */
    public boolean continueFolding()
    {
        System.out.print( "Would you like to \"fold\" it again?   " );

        if( in.nextLine().toLowerCase().charAt( 0 ) == 'y')
            return true;
        else
            return false;
    }

    /**
     * JAVADOC
     * @return
     */
    public char getFold()
    {
        System.out.print( "Choose from the following \"folds\" to apply to your"
                        +" seed pattern:\n(L)eft, (R)ight, (T)op, or (B)ottom?   " );
        
        return in.nextLine().toLowerCase().charAt( 0 );
    }

    /**
     * JAVADOC
     * @param pattern
     */
    public void display( char[][] pattern )
    {
        for(int rows = 0; rows < pattern.length; rows++)
        {
            for(int cols = 0; cols < pattern[0].length; cols++)
                System.out.print(pattern[ rows ][ cols ]);
                
            System.out.println();
        }
    }
}
