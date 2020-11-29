import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {
    private ArrayList<Card> deck;
    private static final int TEN = 10;


    public Deck(int numOfDeck) {
        deck = new ArrayList<Card>();
        buildDeck(numOfDeck);
    }

    //put 52 cards into the deck
    private void buildDeck( int numOfDeck) {

        for (int j = 0; j < numOfDeck; j++) {
            for (int cardValue = 2; cardValue < 10; cardValue++) {
                for(int i = 0; i < 4; i++) {
                    deck.add(new Card(cardValue));
                }
            }

            for (int i = 0; i < 16; i++) {
                deck.add(new Card(TEN));
            }

            for (int i = 0; i < 4; i++) {
                deck.add(new Card(11));
            }
        }

        this.shuffle();
    }


    //return the size of the deck so that deck gets to know when to shuffle cards
    public int getSize() {
        return deck.size();
    }

    //return the first card and remove it from the deck
    public Card dealCard() {
        return deck.remove(0);
    }

    //implemeting Fish-Yates shuffle
    public void shuffle() {
        Random rnd = ThreadLocalRandom.current();

        for (int i = getSize() - 1; i > 0; i-- ) {
            int index = rnd.nextInt(i + 1);
            Card a = deck.get(index);
            deck.set(index, deck.get(i));
            deck.set(i, a);
        }
    }

    public void printDeck() {
        for ( Card d: deck) {
            System.out.print(d.getValue() + " ");
        }
    }

}
