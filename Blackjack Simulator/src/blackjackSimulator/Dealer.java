package blackjackSimulator;

public class Dealer {
		
		
		boolean debug = false;
		
		
		/*
		 * Constructor 
		 * Nothing to do here
		 */
		
		public Dealer() {	
		}
		
		
		/*
		 * Dealer play
		 */
		
		public int PlayDealerHand  ( Shoe shoe , Card first_card , Card second_card ) throws OutOfCards {
			
			Hand hand;
			hand = new Hand();
			
			if (debug) System.out.println("");
			if (debug) System.out.println("Playing Dealer Hand");
			
			/* add first and second cards to hand */
			
			hand.AddCardToHand ( first_card );
			hand.AddCardToHand ( second_card );
			
			if (debug) System.out.println("dealer hand value is "+hand.HandValue() );
			
			/* dealer hits until hand value is 17+, not implementing hit on soft 17 */
			
			while ( hand.HandValue() < 17 ) {
				
				/* draw another card */
				
				try
		        {
					hand.AddCardToHand ( shoe.ShoeDraw() );
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
			
			if ( hand.HandValue() > 21 ) {   /* dealer over 21, but need to check potential soft hand value */
				
				/* check the soft (Alternate) hand value, hit 16 and below */
				
				while ( hand.AltHandValue() < 17 ) {
					
					/* draw another card */
					
					try
			        {
						hand.AddCardToHand ( shoe.ShoeDraw() );
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

