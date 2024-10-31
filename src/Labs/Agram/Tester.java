package src.Labs.Agram;

public class Tester {
    private static Deck deck = new Deck();
    private static MyPlayer player = new MyPlayer();
    public static void main(String[] args) {
        deck.shuffle();
        player.getHand(deck.deal());
        for(int i = 0; i < 6; i++) {
            System.out.println();
            player.printHand();
            System.out.println();

            System.out.println(player.playCard(new Card[]{}));
        }
    }
}
