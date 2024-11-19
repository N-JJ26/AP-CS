package src.Labs.Arrayz;

/**
 * JAVADOC HERE
 *
 * @author Nate Johnson
 * @version 11/19/24
 */
public class Arrayz
{
    /*TODO:
     * remove package header
     */

    /** The initial capacity of the Arrayz object */
    public static final int CAPACITY = 20;

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
     * Checks to see if the Arrayz object is empty or not
     *
     * @return true if the object is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return numberOfElements == 0;
    }

    /**
     * Returns the size of the Arrayz object
     *
     * @return the size of the object
     */
    public int size()
    {
        return numberOfElements;
    }

    /**
     * Clears the Arrayz object of all its elements
     */
    public void clear()
    {
        charArray = new char[ CAPACITY ];

        for( int i = 0; i < charArray.length; i++ )
            charArray[ i ] = ' ';
    }

    /**
     * Returns the element of the Arrayz object at a given index
     *
     * @param index the desired index
     * @return the element at the given index
     */
    public char get( int index )
    {
        return charArray[ index ];
    }

    /**
     * Sets an element of the Arrayz object to a new element at a desired index
     *
     * @param index the desired index
     * @param element the new element to be swapped
     * @return the previous element at the index
     */
    public char set( int index, char element )
    {
        char previous = charArray[ index ];
        charArray[ index ] = element;

        return previous;
    }

    /**
     * Checks to see if the Arrayz object contains a certain element
     *
     * @param element the desired element
     * @return true if the object contains the element, false otherwise
     */
    public boolean contains( char element )
    {
        for( int i = 0; i < charArray.length; i++ )
            if( charArray[ i ] == element )
                return true;
        return false;
    }

    /**
     * Returns the first index of an element
     *
     * @param element the desired element
     * @return the first index of the element
     */
    public int indexOf( char element )
    {
        for( int i = 0; i < charArray.length; i++ )
            if( charArray[ i ] == element )
                return i;
        return -1;
    }

    /**
     * Returns the last index of an element
     *
     * @param element the desired element
     * @return the last index of the element
     */
    public int lastIndexOf( char element )
    {
        for( int i = charArray.length - 1; i >= 0; i-- )
            if( charArray[ i ] == element )
                return i;
        return -1;
    }

    /**
     * Adds an element to the end of the Arrayz object
     *
     * @param element the desired element to be added
     * @return true
     */
    public boolean add( char element )
    {
        if( charArray[ charArray.length - 1 ] != ' ' )
            update();

        charArray[ size() ] = element;
        numberOfElements++;
        return true;
    }

    /**
     * Adds an element to the Arrayz object at a specific index
     *
     * @param index the desired index
     * @param element the desired element to be added
     */
    public void add( int index, char element )
    {
        if( charArray[ charArray.length - 1 ] != ' ' )
            update();

        for( int i = charArray.length - 1; i > index; i-- )
        {
            char temp = charArray[ i - 1 ];
            charArray[ i ] = charArray[ i - 1 ];
            charArray[ i ] = temp;
        }
        charArray[ index ] = element;
        numberOfElements++;
    }

    /**
     * Removes the element at a specific index
     *
     * @param index the desired index
     * @return the element that was removed
     */
    public char remove( int index )
    {
        char previous = charArray[ index ];

        charArray[ index ] = ' ';

        for( int i = index; i < charArray.length - 1; i++ )
        {
            char temp = charArray[ i ];
            charArray[ i ] = charArray[ i + 1 ];
            charArray[ i + 1 ] = temp;
        }

        numberOfElements--;

        return previous;
    }

    /**
     * Removes the first index of an element
     *
     * @param element the desired element to be removed
     * @return true
     */
    public boolean remove( char element )
    {
        if( !contains( element ) )
            return false;

        int index = indexOf( element );

        charArray[ index ] = ' ';

        for( int i = index; i < charArray.length - 1; i++ )
        {
            char temp = charArray[ i ];
            charArray[ i ] = charArray[ i + 1 ];
            charArray[ i + 1 ] = temp;
        }

        numberOfElements--;

        return true;
    }

    private void update()
    {
        char[] updatedArray = new char[ charArray.length + 2 ];

        for( int i = 0; i < charArray.length; i++ )
            updatedArray[ i ] = charArray[ i ];
        for(int i = charArray.length; i < updatedArray.length; i++)
            updatedArray[ i ] = ' ';

        charArray = updatedArray;
    }

    /**
     * Returns the String representation of an Arrayz object
     *  i.e.  ['1', '2', '3', ...]
     *
     * @return the String representation of the object
     */
    public String toString()
    {
        String str = "[" + charArray[ 0 ];

        for(int i = 1; i < size(); i++)
            str += ", " + charArray[ i ];

        str += "]";
        return str;
    }

    /**
     * Checks if another Arrayz object has the same number and value of elements
     *  as the Arrayz object
     *
     * @param arr the Arrayz object to be compared
     * @return true if they have the same number and value of elements, false otherwise
     */
    public boolean equals( Arrayz arr )
    {
        if( arr == null || size() != arr.size() )
            return false;
        
        for( int i = 0; i < size(); i++ )
            if( charArray[ i ] != arr.get( i ) )
                return false;
        return true;
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
