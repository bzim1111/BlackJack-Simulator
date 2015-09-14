package blackjackSimulator;

/* need to add a class for Hand */

public class Game {

	private Card dealer_cards[] = new Card[52];
	
	public Game() {	
	}
	
	public void PlayDealerHand  ( Deck deck ) throws OutOfCards {
		
		System.out.println("Playing Dealer Hand");

		int num_cards = 0;
		int hand_value;
		int i;
		
		/* draw first card */
		
		try
        {
			dealer_cards[0] = deck.Draw();
			dealer_cards[0].PrintCard();
			num_cards++;
        }
        catch ( OutOfCards ooc )
        {
            throw new OutOfCards();
        }
		
		/* draw second card */
		
		try
        {
			dealer_cards[1] = deck.Draw();
			dealer_cards[1].PrintCard();
			num_cards++;
        }
        catch ( OutOfCards ooc )
        {
            throw new OutOfCards();
        }
		
		/* get the hand value */
		
		hand_value = 0;
		for ( i=0; i<num_cards; i++ ) {
			hand_value = hand_value + dealer_cards[i].card_value;
		}
		
		System.out.println("hand value is "+hand_value);
		
		while ( hand_value < 17 ) {
			
			/* draw another card */
			
			try
	        {
				dealer_cards[num_cards] = deck.Draw();
				dealer_cards[num_cards].PrintCard();
				num_cards++;
	        }
	        catch ( OutOfCards ooc )
	        {
	            throw new OutOfCards();
	        }
			
			/* recalculate hand value */
			
			hand_value = 0;
			for ( i=0; i<num_cards; i++ ) {
				hand_value = hand_value + dealer_cards[i].card_value;
			}
			System.out.println("hand value is "+hand_value);
		}
		
	}
}
