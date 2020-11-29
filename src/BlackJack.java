// add A as ONE or ELEVEN FEATURE
// add AK wins all feature ///////////////////////////////////////////Done!
// use 6 deck cards to see how it changes results ////////////////////Done!
// adding some betting strategy to the simulation

public class BlackJack {

    private Deck deck;
    private Hand dealer;
    private Hand player;
    private int numberDeck;

    public BlackJack(int numOfDeck) {
        deck = new Deck(numOfDeck);
        dealer = new Hand();
        player = new Hand();
        numberDeck = numOfDeck;
    }

    public void reset(boolean needNewDeck) {
        if (needNewDeck) {
            deck = new Deck(numberDeck);
            System.out.println("Get a newly shuffled Deck!");
        }
        dealer.clearHands();
        player.clearHands();
    }

    public void dealTwoCards() {
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
    }

    // different strategy
    // player deploys same strategy with the dealers.
    public boolean playerTurn() {
        while( player.getTotalValue() < 17) {
            player.addCard(deck.dealCard());
        }
        return player.getTotalValue() <= 21;
    }

    public boolean dealerTurn() {
        while( dealer.getTotalValue() < 17) {
            dealer.addCard(deck.dealCard());
        }

        return dealer.getTotalValue() <= 21;
    }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BlackJack blackjack = new BlackJack(1);
        int dealerWin = 0, playerWin = 0, chopchop = 0;
        String result;
        int totalGame  = 1000;
        for (int i = 0 ; i < totalGame; i++) {
            if( blackjack.deck.getSize() < 26){
                blackjack.reset(true);
            }else {
                blackjack.reset(false);
            }
            blackjack.dealTwoCards();

            if(blackjack.playerTurn() == false) {
//				System.out.print("Dealer win");
                dealerWin++;
                result = "You lose!!!!!!";
            }else if (blackjack.player.getTotalValue() == 21 && blackjack.player.getNumOfCards() == 2) {
                playerWin++;
                result = "You win!!! You have BlackJack!!!!";
            }else if (blackjack.dealerTurn() == false) {
//				System.out.print("player win");
                playerWin++;
                result = "You win!!!!!!";
            }else if (blackjack.dealer.getTotalValue() > blackjack.player.getTotalValue()) {
//				System.out.print("Dealer win");
                dealerWin++;
                result = "You lose!!!!!!";
            }else if (blackjack.dealer.getTotalValue() < blackjack.player.getTotalValue()) {
//				System.out.print("player win");
                playerWin++;
                result = "You win!!!!!!";
            }else {
//				System.out.print("chop chop");
                chopchop++;
                result = "chop chop!!!!!!!";
            }
            System.out.println("Round " + (i+1) + "============================");
            System.out.println("Player Hand: \n" + blackjack.player.toString());
            System.out.println("Dealer Hand: \n" + blackjack.dealer.toString());
            System.out.println(result +"\n");
        }

        System.out.println("Stats ============================");
        System.out.println("Dealer wins " + dealerWin);
        System.out.println("Player wins " + playerWin);
        System.out.println("Chop " + chopchop);
        System.out.println("Game Total Played: " + totalGame);

        double winRate = playerWin * 1.0 / totalGame;
        System.out.println("Your win rate is " + winRate);
    }
}
