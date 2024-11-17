package src.Labs.Arrayz;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * JAVADOC HERE
 *
 * @author Nate Johnson
 * @version 11/15/24
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

        arrayz.clear();
        System.out.println(arrayz);

        for(int i = 0; i < 20; i++) {
            arrayz.add( '!' );
        }
        System.out.println(arrayz);
    }
}
