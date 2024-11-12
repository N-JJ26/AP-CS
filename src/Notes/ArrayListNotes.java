package src.Notes;

import java.util.ArrayList;

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

    static ArrayList<String> arrayList1 = new ArrayList<String>(); //must use objects
    static ArrayList<Character> arrayList2 = new ArrayList<Character>();

    /*
     * Boolean
     * Character
     * Integer
     * Double
     */

    public static void main(String[] args) {
        arrayList1.add("first item");
        arrayList1.add("second");
        //... all should return true
        //adds 5 "lockers" once the size has been filled, starting with 10

        arrayList1.toString(); //[0, 1, 2, ...]

        //cannot use set() to an empty array
    }
}
