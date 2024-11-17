package src.Labs.Arrayz;

/**
 * JAVADOC HERE
 *
 * @author Nate Johnson
 * @version 11/15/24
 */
public class Arrayz
{
    /*TODO:
     * javadoc
     * remove package header
     */

    /** JAVADOC */
    public static final int CAPACITY = 20;

    private static final int INCREMENT = 5;

    private int numberOfElements;
    private char[] charArray;

    /**
     * Instantiates the Arrayz object with the correct initial size
     */
    public Arrayz()
    {
        numberOfElements = 0;
        charArray = new char[ CAPACITY ];
        for( int i = 0; i < charArray.length; i++ )
            charArray[ i ] = ' ';
    }

    /**
     * JAVADOC
     *
     * @return
     */
    public boolean isEmpty()
    {
        return numberOfElements == 0;
    }

    /**
     * JAVADOC
     *
     * @return
     */
    public int size()
    {
        return numberOfElements;
    }

    /**
     * JAVADOC
     */
    public void clear()
    {
        charArray = new char[ CAPACITY ];

        for( int i = 0; i < charArray.length; i++ )
            charArray[ i ] = ' ';
    }

    /**
     * JAVADOC
     *
     * @param index
     * @return
     */
    public char get( int index )
    {
        return charArray[ index ];
    }

    /**
     * JAVADOC
     *
     * @param index
     * @param element
     * @return
     */
    public char set( int index, char element )
    {
        char previous = charArray[ index ];
        charArray[ index ] = element;

        return previous;
    }

    /**
     * JAVADOC
     *
     * @param element
     * @return
     */
    public boolean contains( char element )
    {
        for( int i = 0; i < charArray.length; i++ )
            if( charArray[ i ] == element )
                return true;
        return false;
    }

    /**
     * JAVADOC
     *
     * @param element
     * @return
     */
    public int indexOf( char element )
    {
        for( int i = 0; i < charArray.length; i++ )
            if( charArray[ i ] == element )
                return i;
        return -1;
    }

    /**
     * JAVADOC
     *
     * @param element
     * @return
     */
    public int lastIndexOf( char element )
    {
        for( int i = charArray.length - 1; i >= 0; i-- )
            if( charArray[ i ] == element )
                return i;
        return -1;
    }

    /**
     * JAVADOC
     *
     * @param element
     * @return
     */
    public boolean add( char element )
    {
        if( charArray[ charArray.length - 1 ] != ' ' )
        {
            update();
        }

        charArray[ size() ] = element;
        numberOfElements++;
        return true;
    }

    private char[] update()
    {
        char[] updatedArray = new char[ charArray.length + INCREMENT ];

        for( int i = 0; i < charArray.length; i++ )
            updatedArray[ i ] = charArray[ i ];
        for(int i = charArray.length; i < updatedArray.length; i++)
            updatedArray[ i ] = ' ';

        charArray = updatedArray;
        return charArray;
    }

    /**
     * JAVADOC
     *
     * @param index
     * @param element
     * @return
     */
    public boolean add( int index, char element )
    {
        return false;
    }

    /**
     * JAVADOC
     *
     * @param index
     * @return
     */
    public char remove( int index )
    {
        return '!';
    }

    /**
     * JAVADOC
     *
     * @param element
     * @return
     */
    public boolean remove( char element )
    {
        return false;
    }

    /**
     * JAVADOC
     *
     * @return JAVADOC
     */
    public String toString()
    {
        String str = "[" + charArray[ 0 ];
        for(int i = 1; charArray[ i ] != ' '; i++)
            str += ", " + charArray[ i ];
        str += "]";
        return str;
    }

    /**
     * JAVADOC
     *
     * @param arr
     * @return
     */
    public boolean equals( Arrayz arr )
    {
        return false;
    }

    /**
     * This method resets all of the elements of the charArray as:
     *  "AP Compsi A Arrayz Lab", all as lowercase chars ignoring spaces
     */
    public void testingStarter()
    {
        charArray = new char[]{ 'a', 'p', 'c', 'o', 'm', 'p', 's', 'c', 'i', 'a',
                                'a', 'r', 'r', 'a', 'y', 'z', 'l', 'a', 'b', ' ' };
        numberOfElements = CAPACITY - 1;
    }
}
