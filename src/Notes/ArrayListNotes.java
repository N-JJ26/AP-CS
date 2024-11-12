package src.Notes;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListNotes {
    /*
     * major drawback of arrays => fixed size
     *      an array's size larger than necessary
     *      partially filled array
     *          store information amount used
     *
     *  0   1   2 ...
     * ____________________
     *| x | x | x |   |   |
     * ____________________
     *
     *
     *
     *
     * java.util.ArrayList
     */

    //ArrayList<String> arrayList1 = new ArrayList<String>(); //must use objects
    //ArrayList<Character> arrayList2 = new ArrayList<Character>();

    /*
     * Boolean
     * Character
     * Integer
     * Double
     */

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<Character>();
        //or   List list = new ArrayList<Character>();  on the AP

        //can be used for the lab
        while(true) {
            System.out.println("Menu:\n" +
                            "(P)rint, is empt(Y), clea(R), (G)et element, (S)et element,\n" +
                            "(C)ontains an element, i(N)dex of element,\n" +
                            "(L)ast index of element, (A)dd at the end, add at (I)ndex,\n" +
                            "re(M)ove at index, remove(E)lement, or e(X)itn\n");
            char choice = in.nextLine().toLowerCase().charAt(0);
            switch( choice ) {
                case 'p':
                    System.out.println(list.toString());
                    break;
                case 's':
                    System.out.println(list.size());
                    break;
                case 'x':
                    return;
                case 'y':
                    System.out.println(list.isEmpty());
                        //list.isEmpty() => list.size() == 0
                    break;
                case 'r':
                    list.clear(); //void return cannot be in a println()
                    System.out.println("cleared");
                    break;
                case 'g':
                    int index = in.nextInt();
                    in.nextLine(); //scrap the <enter>
                    System.out.println(list.get(index));
                    break;
            }
        }
    }
}
