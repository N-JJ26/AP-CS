package src.Notes;

/**
 * Methods for different matrix operations,
 *  such as adding, multiplying, and finding determinants
 *
 * @author Nate Johnson
 * @version 10/29/24
 */
public class Matrix
{
    private double[][] m ;

    /**
     * Makes a new matrix with a given number of rows and columns
     *
     * @param rows the number of rows
     * @param columns the number of columns
     */
    public Matrix(int rows, int columns) {
        m = new double[rows][columns];
    }
    /**
     * Makes a matrix given a two dimensional array
     *
     * @param matrix the initialized 2D array
     */
    public Matrix(double[][] matrix) {
        m = matrix;
    }
    
    /**
     * Returns the number at a given row and column
     *
     * @param row the row given
     * @param col the column given
     * @return the number at (row, col)
     */
    public double get(int row, int col) {
        return m[row][col];
    }

    /**
     * Sets the value at (row, col) to a given element
     *
     * @param row the row given
     * @param col the column given
     * @param element the element set to replace
     */
    public void set(int row, int col, double element) {
        m[row][col] = element;
    }

    /**
     * Inverts the Matrix, with the rows becoming columns, and the columns becoming rows
     */
    public void transpose() {
        double[][] n = new double[m[0].length][m.length];

        for(int i = 0; i < m.length; i++) {
            for(int j = 0; j < m[0].length; j++) {
                n[j][i] = m[i][j]; //flips the rows and columns
            }
        }
        m = n;
    }

    /**
     * Returns the number of rows
     * @return the number of rows
     */
    public int getRows() {
        return m.length;
    }
    /**
     * Returns the number of columns
     * @return the number of columns
     */
    public int getCols() {
        return m[0].length;
    }

    /**
     * Adds two Matrix objects that are the same dimensions and returns the new Matrix
     *
     * @param N the Matrix to be added
     * @return a new Matrix, the sum of m and N
     */
    public Matrix add(final Matrix N) {
        int cols = m[0].length;
        int rows = m.length;

        if(N == null || cols != N.getCols() || rows != N.getRows())
            return null; //base case
        
        double[][] temp = new double[rows][cols];

        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                temp[i][j] = m[i][j] + N.get(i, j);

        return new Matrix(temp); //anonymous object
    }

    /**
     * Returns the vector of a matrix,
     *  either a row or a column from the original Matrix object, defaults to double[]{}
     *
     * @param isRow true if the vector is a row, false for a column
     * @param numRowCol the row/column desired
     * @return a one dimensional array from the implicit 2D array,
     *  or an empty array if numRowCol is out of bounds
     */
    public double[] getVector(boolean isRow, int numRowCol) {
        double[] vector = new double[]{};

        if(isRow) {
            if(numRowCol < 0 || numRowCol >= m.length)
                return vector;

            vector = new double[m[0].length];

            for (int col = 0; col < m[0].length; col++)
                vector[col] = m[numRowCol][col];
        }
        else {
            if(numRowCol < 0 || numRowCol >= m[0].length)
                return vector;

            vector = new double[m.length];

            for (int row = 0; row < m.length; row++)
                vector[row] = m[row][numRowCol];
        }

        return vector;
    }

    /**
     * Multiplies two Matrix objects that have the same inner dimensions
     *  i.e. a 2x4 matrix and a 4x3 matrix -> 2x3 matrix
     *
     * @param N The matrix to be multiplied
     * @return The product of the two Matrix object
     */
    public Matrix multiply(final Matrix N) {
        if(m[0].length != N.getRows())
            return null;

        int nRows = N.getRows();

        Matrix product = new Matrix(new double[m.length][N.getCols()]);

        for (int row = 0; row < product.getRows(); row++)
            for (int col = 0; col < product.getCols(); col++) {
                for (int element = 0; element < nRows; element++)
                    product.set(row, col, product.get(row, col)
                                + m[row][col] * N.get(element, col));
            }

        return product;
    }

    /**
     * Returns the determinate of the Matrix object,
     *  assuming the it is a square 2 dimensional array
     *
     * @return The determinate of the Matrix object
     */
    public double determinant() {
        if(m.length != m[0].length)
            return Double.NaN;

        return determinant(m);
    }

    private double determinant(double[][] n) {
        if(n.length < 2)
            return 0;
        if(n.length == 2)
            return n[0][0] * n[1][1] - n[0][1] * n[1][0];

        int det = 0;
        for(int i = 0; i < n.length; i++) {
            double[][] temp = new double[n.length - 1][n[0].length - 1];
            for(int row = 1; row < n.length; row++)
                for(int col = 0; col < temp.length; col++)
                    if(col < i)
                        temp[row - 1][col] = n[row][col];
                    else if(col > i)
                        temp[row - 1][col - 1] = n[row][col];
            
            if(i % 2 == 0)
                det += n[0][i] * determinant(temp);
            else
                det -= n[0][i] * determinant(temp);
        }
        return det;
    }

    public Matrix inverse() {
        double det = determinant();
        if (Math.abs(det) < 0.00001)
            return null;

        double[][] minors = new double[m.length][m[0].length];
        for(int row = 0; row < minors.length; row++)
            for(int col = 0; col < minors[0].length; col++) {
                double[][] temp = new double[m.length - 1][m[0].length - 1];
                for (int i = 0; i < temp.length; i++)
                    for (int j = 0; j < temp.length; j++) {
                        if(i < row && j < col)
                            temp[i][j] = m[i][j];
                        else if(i < row && j > col)
                            temp[i][j - 1] = m[i][j];
                        else if(i > row && j < col)
                            temp[i - 1][j] = m[i][j];
                        else if(i > row && j > col)
                            temp[i - 1][j - 1] = m[i][j];
                    }
                minors[row][col] = determinant(temp);
            }

        double[][] cofactors = minors;
        for(int row = 0; row < cofactors.length; row++)
            for(int col = 0; col < cofactors[0].length; col++) {
                if(row % 2 == 1)
                    cofactors[row][col] *= -1;
                if(col % 2 == 1)
                    cofactors[row][col] *= -1;
            }

        Matrix adjudgates = new Matrix(cofactors);
        adjudgates.transpose();

        Matrix inverse = new Matrix(m.length, m[0].length);
        for(int row = 0; row < cofactors.length; row++)
            for(int col = 0; col < cofactors.length; col++)
                inverse.set(row, col, adjudgates.get(row, col) / det);

        return inverse;
    }

    public void print() {
        for(int i = 0; i < m.length; i++) {
            System.out.print("[ " + m[i][0]);
            for(int j = 0; j < m.length; j++)
                System.out.print(", " + m[i][j]);
            System.out.println(" ]");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][]{{1, 2, -1, 2, 1},
                                            {0, 1, 0, 1, 1},
                                            {1, -2, 1, -1, 2},
                                            {-1, 0, -1, 1, 1},
                                            {0, 1, 0, -1, 1}});
        a.print();
        Matrix b = a.inverse();
        b.print();
        Matrix c = a.multiply(b);
        c.print();
    }
}
