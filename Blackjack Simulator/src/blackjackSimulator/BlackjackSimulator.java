package blackjackSimulator;

public class BlackjackSimulator {

	
	public static void main(String[] args) {
		
		int i;
		int dealer_count;
		
		Deck deck = new Deck();
		
		deck.ShuffleDeck();
		
		/* temp - print out the deck */
		
		for ( i=0; i<53; i++ ) {
			try
	        {
				Card c = deck.Draw();
				c.PrintCard();
	        }
	        catch ( OutOfCards ooc )
	        {
	            System.out.println("out of cards");
	            break;
	        }
		}
		
		/* play dealer hand */
		
		/*deck.ShuffleDeck();*/
		deck.ResetDeck();
		
		Game game = new Game();
		
		dealer_count = 0;
		try
        {
			dealer_count = game.PlayDealerHand ( deck );
        }
        catch ( OutOfCards ooc )
        {
            System.out.println("out of cards");
        }
		
		System.out.println("FINAL DEALER COUNT = "+dealer_count);
		
	}

}
