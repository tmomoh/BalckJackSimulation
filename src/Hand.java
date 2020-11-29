import java.util.ArrayList;


public class Hand {
    private ArrayList<Card> hand;
    private int numberOfA;
    private ArrayList<Integer> totalValue;

    public Hand() {
        hand = new ArrayList<Card>();
        numberOfA = 0;
        totalValue = new ArrayList<Integer>();
    }

    public void clearHands() {
        hand.clear();
    }

    //
    public void addCard(Card card) {
        hand.add(card);
        if (card.getValue() == 11) {
            numberOfA++;
        }
    }

    public int getNumOfCards() {
        return hand.size();
    }

    public Card getCard(int i) {
        return hand.get(i);
    }

    public int getTotalValue() {
        int total = 0;
        for(Card c : hand) {
            total += c.getValue();
        }

        return total;
    }

    @Override
    public String toString() {
        String tmp = "";
        for (Card c: hand) {
            tmp += c.toString();
        }
        return tmp;
    }

//	public static void main(String[] args) {
//		Hand player = new Hand();
//		player.add(new Card(10));
//		player.add(new Card(5));
//		System.out.println(player);
//
//	}
}
