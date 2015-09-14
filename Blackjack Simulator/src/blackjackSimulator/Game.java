package blackjackSimulator;

/* need to add a class for Hand */

public class Game {
	
	public Game() {	
	}
	
	public void PlayDealerHand  ( Deck deck ) throws OutOfCards {
		
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
		
	}
}
