package blackjackSimulator;

public class BlackjackSimulator {

	
	public static void main(String[] args) {
		
		int i;
		int dealer_count , player_count;
		Card dealer_first , dealer_second;
		
		dealer_first = null;
		dealer_second = null;
		Deck deck = new Deck();
		
		deck.ShuffleDeck();
		
		/* temp - print out the deck */
		/* need to check all cards printed...
		 * 
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
		*/
		
		/* play dealer hand */
		
		/*deck.ShuffleDeck();*/
		/*deck.ResetDeck();*/
		
		Game game = new Game();
		
		/* Draw first card for Dealer (down card) */
		
		try
        {
		   dealer_first = deck.Draw();
        }
        catch ( OutOfCards ooc )
        {
        	System.out.println("out of cards");
        }
		
		/* Draw second card for Dealer (up card) */
		
		try
        {
		   dealer_second = deck.Draw();
        }
        catch ( OutOfCards ooc )
        {
        	System.out.println("out of cards");
        }
		
		System.out.println("initial dealer cards");
		dealer_first.PrintCard();
		dealer_second.PrintCard();
		
		/* play the Player's hand */
		
		player_count = 0;
		
		try
		{
			player_count = game.PlayPlayerHand(deck, dealer_second );
		}
        catch ( OutOfCards ooc )
        {
            System.out.println("out of cards");
        }
		
		System.out.println("FINAL PLAYER COUNT = "+player_count);
	
		
		/* play the Dealer's hand */
		
		dealer_count = 0;
		try
        {
			dealer_count = game.PlayDealerHand ( deck , dealer_first , dealer_second );
        }
        catch ( OutOfCards ooc )
        {
            System.out.println("out of cards");
        }
		
		System.out.println("FINAL DEALER COUNT = "+dealer_count);
		
	}

}
