/* package src.Notes;

public class TwoDArrays {
    private static final int NUM_ARRAYS = 1;
    private static final int NUM_ELEMENTS = 1;
    private static final int SIZE = 1;

    /*
     * [][]. . . []
     * [][]. . . []
     * . . . . . .
     * . . . . . .
     * . . . . . .
     * [][]. . . []
     */

    //private static int[][] arrOfNums = new int[NUM_ARRAYS][NUM_ELEMENTS]; //Rectangular Array
    //private static char[][] letters = new char[SIZE][];
    //private static int[][] nums = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
    //nums[0][3] == 4
    //nums[1][3] == 9
    //nums.length == NUM_ARRAYS == 2 == "rows"  x's i's
    //nums[0].length == NUM_ELEMENTS == 5 == "cols"

    /*public static void main(String[] args) {
        for(int rows = 0; rows < nums.length; rows++)
            for(int cols = 0; cols < nums[0].length; cols++)
                if(nums[rows][cols] == 0)
                    return; // each element of a row, per column

        for(int i = 0; i < nums[0].length; i++)
            for(int j = 0; j < nums.length; j++)
                if(nums[j][i] == 0)
                    return; // each element of a column, per row

        for(int[] arr : nums)
            for(int x : arr)
                x+=5;
    }

    public static void enhancedLoop() {
        double[] scores = new double[6];
        for(double x : scores) {
            if(x >= 90) {
                return;
            }
        }
    }
}
 */