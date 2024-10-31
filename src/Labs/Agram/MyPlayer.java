package src.Labs.Agram; //REMOVE THIS

/**
 * The player will always play the lowest card in the hand,
 *  so that the last card will be the highest
 * 
 * @author Team Winning
 * @version 9/24/2024
 */
public class MyPlayer
{
    private static final int HAND = 6;
    private final String TEAM_NAME = "Team Winning";
    private int playedCards = 0;
    private Card playedCard;
    private Card[] hand;

    public MyPlayer()
    {
        hand = new Card[ HAND ];
    }
    public void getHand( Card[] cards )
    {
        hand = cards;
        mergeSort( hand );
    }
    public void showTrick( Card[] cards ){}

    private Card[] mergeSort( Card[] cards )
    {
        if( cards.length <= 1 )
            return cards;

        Card[] left = new Card[ cards.length / 2 ];
        Card[] right = new Card[ cards.length - cards.length / 2 ];

        int j = 0;
        for( int i = 0; i < cards.length; i++ )
        {
            if( i < cards.length / 2 )
                left[ i ] = cards[ i ];
            else
            {
                right[ j ] = cards[ i ];
                j++;
            }
        }
        mergeSort( left );
        mergeSort( right );
        merge( left, right, cards );

        return cards;
    }

    private void merge( Card[] left, Card[] right, Card[] cards )
    {
        int leftSize = cards.length / 2;
        int rightSize = cards.length - leftSize;

        int index = 0, leftIndex = 0, rightIndex = 0;
        while( leftIndex < leftSize && rightIndex < rightSize )
        {
            if( left[ leftIndex ].getRank() < right[ rightIndex ].getRank() )
            {
                cards[ index ] = left[ leftIndex ];
                index++;
                leftIndex++;
            }
            else
            {
                cards[ index ] = right[ rightIndex ];
                index++;
                rightIndex++;
            }
        }
        while( leftIndex < leftSize )
        {
            cards[ index ] = left[ leftIndex ];
            index++;
            leftIndex++;
        }
        while( rightIndex < rightSize )
        {
            cards[ index ] = right[ rightIndex ];
            index++;
            rightIndex++;
        }
    }

    public void printHand()
    {
        for( int i = 0; i < hand.length; i++ )
            System.out.print( hand[ i ] + " " );
    }

    public Card playCard( Card[] cardsPlayed )
    {
        if( cardsPlayed.length == 0 )
            playedCard = hand[ playedCards ];

        playedCards++;
        return playedCard;
    }

    public String toString()
    {
        return TEAM_NAME;
    }
}
