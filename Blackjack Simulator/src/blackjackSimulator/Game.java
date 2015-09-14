package blackjackSimulator;

public class Game {
	
	
	String[][] player_hard = new String[][] {
	/* dealer up        2     3     4     5     6     7     8     9    10   11 */
	/* player  2 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*         3 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*         4 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*         5 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*         6 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*         7 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*         8 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*         9 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        10 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        11 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        12 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        13 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        14 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        15 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        16 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        17 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        18 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        19 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        20 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" },
	/*        21 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s", "s" }
	};
	
	
	public Game() {	
	}
	
	public int PlayDealerHand  ( Deck deck ) throws OutOfCards {
		
		Hand hand;
		hand = new Hand();
		
		System.out.println("Playing Dealer Hand");
		
		/* draw first card */
		
		try
        {
		   hand.AddCardToHand ( deck.Draw() );
		   hand.PrintHand();
        }
        catch ( OutOfCards ooc )
        {
            throw new OutOfCards();
        }
		
		/* draw second card */
		
		try
        {
			hand.AddCardToHand ( deck.Draw() );
			hand.PrintHand();
        }
        catch ( OutOfCards ooc )
        {
            throw new OutOfCards();
        }
		
		System.out.println("hand value is "+hand.HandValue() );
		
		while ( hand.HandValue() < 17 ) {
			
			/* draw another card */
			
			try
	        {
				hand.AddCardToHand ( deck.Draw() );
				hand.PrintHand();
	        }
	        catch ( OutOfCards ooc )
	        {
	            throw new OutOfCards();
	        }
			
			System.out.println("hand value is "+hand.HandValue() );
		}
		
		if ( hand.HandValue() < 21 ) return hand.HandValue();
		
		if ( hand.HandValue() > 21 ) {
			
			while ( hand.AltHandValue() < 17 ) {
				
				/* draw another card */
				
				try
		        {
					hand.AddCardToHand ( deck.Draw() );
					hand.PrintHand();
		        }
		        catch ( OutOfCards ooc )
		        {
		            throw new OutOfCards();
		        }
				
				System.out.println("hand value is "+hand.AltHandValue() );
			}
		}
		
		return ( hand.AltHandValue() );
		
	}
}
