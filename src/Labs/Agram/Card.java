package src.Labs.Agram; //REMOVE THIS

/**
 * The Card class is used for the card game Agram
 *
 * @author Ishan Albrecht-Buehler
 * @version September 18, 2024
 */
public class Card
{
    private int rank;
    private int suit;
    
    public Card( int r, int s )
    {
        rank = r + 2; //our lowest rank is 3, so we start at 3.
        suit = s;
    }
    
    public Card( String card )
    {
        String r = card.substring( 0, 1 );
        if( r.equals( "A" ) )
            rank  = 11;
        else if ( r.equals( "T" ) )
            rank = 10;
        else
            rank = Integer.parseInt( r );//will take a String of an int
            //make it an int
        switch( card.charAt( 1 ) )
        {
            case 'c':
                suit = 1;
                break;
            case 'd':
                suit = 2;
                break;
            case 'h':
                suit = 3;
                break;
            case 's':
                suit = 4;
        }
        
    }

    
    public int getRank()
    {
        return rank;
    }
    
    public int getSuit()
    {
        return suit;
    }
    
    public boolean isHigher( Card other )
    {
        if( other == null )
            return true;
        return suit == other.getSuit() && rank > other.getRank();
    }
    
    public boolean equals( Card other ) 
    {
        if( other == null )
            return false;
        return suit == other.getSuit() && rank == other.getRank();
    }
    
    public String toString()
    {
        String str = "";
        
        if( rank == 10 )
            str += "T";
        else if ( rank == 11 )
            str += "A";
        else
            str += rank;
            
        switch( suit )
        {
            case 1:
                return str + "c";
            case 2:
                return str + "d";
            case 3:
                return str + "h";
            default:
                return str + "s";
        }
    }
}
