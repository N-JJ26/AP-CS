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
     */
    private Scanner in;
    private char[][] pattern;

    /**
     * Instantiates the UI object
     */
    public UI()
    {
        in = new Scanner( System.in );
    }

    /**
     * Prompts the user for a # of rows and columns, and then asks for a pattern
     *  of "*" and " "
     *
     * @return the pattern of "*" and " " from the user
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
     * Asks the user if they want to continue the program
     *
     * @return true if they want to continue the program, false otherwise
     */
    public boolean continueProgram()
    {
        System.out.print( "Would you like to create another \"Rorschach\" pattern" +
                            " Y/N?      ");

        if( in.nextLine().toLowerCase().charAt (0 ) == 'y')
            return true;
        else
            return false;
    }

    /**
     * Asks the user if they want to continue the folding
     *
     * @return true if they want to continue the folding, false otherwise
     */
    public boolean continueFolding()
    {
        System.out.print( "Would you like to \"fold\" it again Y/N?     " );

        if( in.nextLine().toLowerCase().charAt( 0 ) == 'y')
            return true;
        else
            return false;
    }

    /**
     * Asks the user whether they want to fold the pattern left, right, up, or down
     *
     * @return a char that tells the program which fold to do
     *  i.e. 'l' for left, or 'r' for right
     */
    public char getFold()
    {
        System.out.print( "Choose from the following \"folds\" to apply to your"
                        +" seed pattern:\n(L)eft, (R)ight, (T)op, or (B)ottom?   " );
        
        return in.nextLine().toLowerCase().charAt( 0 );
    }

    /**
     * Displays the pattern
     *
     * @param pattern the 2D array to be printed
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
