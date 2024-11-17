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

    public static void main(String[] args)
    {
        list = new ArrayList< Character >();
        arrayz = new Arrayz();

        arrayz.testingStarter();
        System.out.println(arrayz);

        arrayz.add(6, 'u');
        System.out.println(arrayz);
        
        arrayz.add(7, 't');
        System.out.println(arrayz);
    }
}
