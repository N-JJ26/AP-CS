package src.Labs.Arrayz;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * The Arrayz lab, where the Arrayz object is compared to an ArrayList object
 *
 * @author Nate Johnson
 * @version 11/19/24
 */
public class Comparison
{
    /*TODO:
     * javadoc
     * remove package header and main() parameters
     */
    private static ArrayList< Character > list;
    private static Arrayz arrayz;
    private static Scanner in = new Scanner( System.in );

    /**
     * The main entry point of the lab
     */
    public static void main(String[] args)
    {
        list = new ArrayList< Character >();
        arrayz = new Arrayz();

        int index = -1;
        char element = '\u0950';
        
        while( true )
        {
            System.out.println("Menu:" + "\n" +
                                "(P)rint, (S)ize, is empt(Y), clear(R), " +
                                "(G)et element, se(T) element," + "\n" +
                                "(C)ontaints an element, i(N)dex of element, " +
                                "(L)ast index of element," + "\n" +
                                "(A)dd at end, add at (I)ndex, " +
                                "re(M)ove at index, remove (E)lement," +
                                "or e(X)it" );
            switch( in.nextLine().toUpperCase().charAt( 0 ) )
            {
                case 'P':
                    System.out.println( "list = " + list.toString() );
                    System.out.println( "arrayz = " + arrayz.toString() );
                    break;
                case 'S':
                    System.out.println( "size = " + list.size());
                    System.out.println( "size = " + arrayz.size());
                    break;
                case 'Y':
                    System.out.println( "is empty? = " + list.isEmpty());
                    System.out.println( "is empty? = " + arrayz.isEmpty());
                    break;
                case 'R':
                    list.clear();
                    arrayz.clear();
                    System.out.println( "cleared" );
                    break;
                case 'G':
                    System.out.print( "Enter index: " );
                    index = in.nextInt();
                    in.nextLine();
                    System.out.println( "list.get( " + index + " ) = " + list.get( index ) );
                    System.out.println( "arrayz.get( " + index + " ) = " + arrayz.get( index ) );
                    break;
                case 'T':
                    System.out.print( "Enter index: ");
                    index = in.nextInt();
                    in.nextLine();

                    System.out.print( "Enter element: ");
                    element = in.nextLine().charAt( 0 );

                    System.out.println( "list.set( " + index + ", " + element + " ) = " +
                                        list.set( index,element ) );

                    System.out.println( "arrayz.set( " + index + ", " + element + " ) = " +
                                        arrayz.set( index,element ) );
                    break;
                case 'C':
                    System.out.print( "Enter element: ");
                    element = in.nextLine().charAt( 0 );

                    System.out.println( "list.contains( " + element + " ) = " +
                                        list.contains( element ) );

                    System.out.println( "arrayz.contains( " + element + " ) = " +
                                        arrayz.contains( element ) );
                    break;
                case 'N':
                    System.out.print( "Enter element: ");
                    element = in.nextLine().charAt( 0 );

                    System.out.println( "list.indexOf( " + element + " ) = " +
                                        list.indexOf( element ) );

                    System.out.println( "arrayz.indexOf( " + element + " ) = " +
                                        arrayz.indexOf( element ) );
                    break;
                case 'L':
                    System.out.print( "Enter element: ");
                    element = in.nextLine().charAt( 0 );

                    System.out.println( "list.lastIndexOf( " + element + " ) = " +
                                        list.lastIndexOf( element ) );

                    System.out.println( "arrayz.lastIndexOf( " + element + " ) = " +
                                        arrayz.lastIndexOf( element ) );
                    break;
                case 'A':
                    System.out.print("Enter element: ");
                    element = in.nextLine().charAt( 0 );

                    System.out.println( "list.add( " + element + " ) = " +
                                        list.add( element ) );
                    
                    System.out.println( "arrayz.add( " + element + " ) = " +
                                        arrayz.add( element ) );
                    break;
                case 'I':
                    System.out.print("Enter index: ");
                    index = in.nextInt();
                    in.nextLine();

                    System.out.print("Enter element: ");
                    element = in.nextLine().charAt( 0 );

                    System.out.println( "list.add( " + index + ", " + element + " )" );
                    list.add( index, element);

                    System.out.println( "arrayz.add( " + index + ", " + element + " )" );
                    arrayz.add( index, element);
                    break;
                case 'M':
                    System.out.print("Enter index: ");
                    index = in.nextInt();
                    in.nextLine();
    
                    System.out.println("list.remove( " + index + " ) = " +
                                        list.remove( index ) );

                    System.out.println("arrayz.remove( " + index + " ) = " +
                                        arrayz.remove( index ) );
                    break;
                case 'E':
                    System.out.print("Enter element: ");
                    element = in.nextLine().charAt( 0 );

                    System.out.println( "list.remove( " + element + " ) = " +
                                        list.remove( ( Character )element ) );

                    System.out.println( "arrayz.remove( " + element + " ) = " +
                                        arrayz.remove( element ) );
                    break;
                case 'X':
                    return;
            }
        }
    }
}
