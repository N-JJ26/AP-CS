package src.Labs.Agram; //REMOVE THIS

/**
 * The Agram Dec contains the Cards 3 through Ace, excluding face cards,
 * with "French Standard" suits, excluding the Ace of Spades
 * 
 * (cards 3-10, with 3 aces excluding ace of spades)
 *
 * @author Ishan Albrecht-Buehler
 * @version September 18, 2024
 */
public class Deck
{
    private static final int HAND = 6;
    private Card[] cards;
    private int index;
    
    public Deck()
    {
        final int RANKS = 9;
        final int SUITS = 4;
        
        cards = new Card[ RANKS  * SUITS - 1 ];
        
        index = 0;
        
        for( int i = 0; i < cards.length; i++ )
            cards[ i ] = new Card( i  / SUITS  + 1, i % SUITS + 1 );// for suits first four will be one, 
            //next four will be 2, etc
        
    }
    
    public void shuffle()
    {
        for( int i = 0; i < cards.length; i++ )
        {
            int index = ( int )( cards.length * Math.random() );//only defined within the for loop
            Card temp = cards[ index ];
            cards[ index ] = cards [ i ];
            cards[ i ] = temp;
        }
        
        index = 0;//private instance variable scope
    }
    
    public Card[] deal() 
    {
        Card[] hand = new Card[ HAND ];
        for( int i = 0; i < hand.length; i++ )
            hand[ i ] = cards[ index + i ];
            
        index += HAND;
        return hand;
    }
    
    public String toString()
    {
        String str = cards[ 0 ].toString();//make this a String as incompatible types
        for( int i = 1; i < cards.length; i++ )
            str += ", " + cards[ i ];//made a String automatically because of "" and toString above
        return str;
    }
}
