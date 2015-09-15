package blackjackSimulator;

public class Game {
	
	/*
	 * need to implement
	 * doubling
	 * surrender
	 * 1.5 payout for blackjack
	 * soft hands
	 * splitting
	 * bankroll
	 */
	
	/*
	 * Strategy matrices for the Player.
	 * 
	 * s = stand
	 * h = hit
	 * ds = double if possible, if not stand
	 * dh = double if possible, if not hit
	 * sp = split
	 * su = surrender
	 * 
	 */
	
	
	String[][] player_hard = new String[][] {
	/* dealer up        2     3     4     5     6     7     8     9    10    11 */
	/* player  2 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
	/*         3 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
	/*         4 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
	/*         5 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
	/*         6 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
	/*         7 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
	/*         8 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
	/*         9 */  { "h",  "dh", "dh", "dh", "dh", "h",  "h",  "h",  "h",  "h" },
	/*        10 */  { "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "h",  "h" },
	/*        11 */  { "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "h" },
	/*        12 */  { "h",  "h",  "s",  "s",  "s",  "h",  "h",  "h",  "h",  "h" },
	/*        13 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "h",  "h",  "h" },
	/*        14 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "h",  "h",  "h" },
	/*        15 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "h",  "su", "h" },
	/*        16 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "su", "su", "su"},
	/*        17 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
	/*        18 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
	/*        19 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
	/*        20 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
	/*        21 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" }
	};
	
	boolean debug = false;
	
	
	public Game() {	
	}
	
	
	/*
	 * Player play
	 */
	
	public int PlayPlayerHand ( Deck deck , Card dealer_upcard , Bet bet ) throws OutOfCards {
		
		Hand hand;
		hand = new Hand();
		boolean done , surrender;
		
		if (debug) System.out.println("");
		if (debug) System.out.println("Playing Player Hand");
		
		/* draw first card */
		
		try
        {
		   hand.AddCardToHand ( deck.Draw() );
		   if (debug) hand.PrintHand();
        }
        catch ( OutOfCards ooc )
        {
            throw new OutOfCards();
        }
		
		/* draw second card */
		
		try
        {
			hand.AddCardToHand ( deck.Draw() );
			if (debug) hand.PrintHand();
        }
        catch ( OutOfCards ooc )
        {
            throw new OutOfCards();
        }
		
		if (debug) System.out.println("player hand value is "+hand.HandValue() );	
		
		surrender = false;
		done = false;
		
		while ( ( ! done ) && (hand.HandValue() <= 21 ) ) {
			
			switch ( player_hard[hand.HandValue()-2][dealer_upcard.card_value-2]) {
			
				case "s":
					if (debug) System.out.println("player stays");
					done = true;
					break;

				case "ds":
					bet.DoubleBet();
					done = true;
					if (debug) System.out.println("player doubles and stays");
					done = true;
					break;
					
				case "h":
					if (debug) System.out.println("player hits");
					try
			        {
						hand.AddCardToHand ( deck.Draw() );
						if (debug) hand.PrintHand();
			        }
			        catch ( OutOfCards ooc )
			        {
			            throw new OutOfCards();
			        }
					break;

				case "dh":
					bet.DoubleBet();
					done = true;
					if (debug) System.out.println("player doubles and hits");
					try
			        {
						hand.AddCardToHand ( deck.Draw() );
						if (debug) hand.PrintHand();
			        }
			        catch ( OutOfCards ooc )
			        {
			            throw new OutOfCards();
			        }
					break;
					
				case "su":
					bet.HalveBet();
					if (debug) System.out.println("player surrenders");
					done = true;
					surrender = true;
					break;
			}
		}
		
		if (debug) System.out.println("player hand value is "+hand.HandValue());
		
		if ( surrender ) return ( 22 ); /* make sure player loses */
		
		return ( hand.HandValue() );
	}
	
	
	/*
	 * Dealer play
	 */
	
	public int PlayDealerHand  ( Deck deck , Card first_card , Card second_card ) throws OutOfCards {
		
		Hand hand;
		hand = new Hand();
		
		if (debug) System.out.println("");
		if (debug) System.out.println("Playing Dealer Hand");
		
		/* add first and second cards to hand */
		
		hand.AddCardToHand ( first_card );
		hand.AddCardToHand ( second_card );
		
		if (debug) System.out.println("dealer hand value is "+hand.HandValue() );
		
		/* dealer hits until hand value is 17+ */
		
		while ( hand.HandValue() < 17 ) {
			
			/* draw another card */
			
			try
	        {
				hand.AddCardToHand ( deck.Draw() );
				if (debug) hand.PrintHand();
	        }
	        catch ( OutOfCards ooc )
	        {
	            throw new OutOfCards();
	        }
			
			if (debug) System.out.println("dealer hand value is "+hand.HandValue() );
		}
		
		/* Dealer is between 17 and 21 - return that hand value */
		
		if ( hand.HandValue() < 21 ) return hand.HandValue();
		
		/* Dealer is > 21, check for aces (soft hand) */
		
		if ( hand.HandValue() > 21 ) {
			
			/* check the soft (Alternate) hand value, hit 16 and below */
			
			while ( hand.AltHandValue() < 17 ) {
				
				/* draw another card */
				
				try
		        {
					hand.AddCardToHand ( deck.Draw() );
					if (debug) hand.PrintHand();
		        }
		        catch ( OutOfCards ooc )
		        {
		            throw new OutOfCards();
		        }
				
				if (debug) System.out.println("dealer hand value is "+hand.AltHandValue() );
			}
		}
		
		/* now we are done checking soft hand, return whatever the final value is */
		
		return ( hand.AltHandValue() );
		
	}
}
