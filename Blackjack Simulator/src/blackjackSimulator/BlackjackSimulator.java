package blackjackSimulator;

public class BlackjackSimulator {

	
	public static void main(String[] args) {
		
		int i;
		
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
	}

}
