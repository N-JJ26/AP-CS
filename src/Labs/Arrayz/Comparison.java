package src.Labs.Arrayz;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * JAVADOC HERE
 *
 * @author Nate Johnson
 * @version 11/17/24
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

    public static void main(String[] args)
    {
        list = new ArrayList< Character >();
        arrayz = new Arrayz();

        arrayz.testingStarter();
        System.out.println(arrayz);

        arrayz.add(6, 'u');
        System.out.println(arrayz);

        arrayz.remove('u');
        System.out.println(arrayz);

        arrayz.remove('a');
        System.out.println(arrayz);
    }
}
