package blackjackSimulator;

public class BlackjackSimulator {

	
	public static void main(String[] args) {
		
		int i;
		int dealer_count , player_count;
		Card dealer_first , dealer_second;
		int j;
		int num_iterations, shuffle_point;
		int dealer_wins, player_wins, pushes;
		float dealer_pct, player_pct;
		boolean debug;
		
		debug = false;
		
		num_iterations = 100000;
		shuffle_point  = 20;
		
		dealer_wins = 0;
		player_wins = 0;
		pushes = 0;
		

		Deck deck = new Deck();
		
		for ( j=1; j<=num_iterations; j++ ) {
			
			deck.ShuffleDeck();
		
			Game game = new Game();
		
			/* Draw first card for Dealer (down card) */
		
			dealer_first = null;
			try
			{
				dealer_first = deck.Draw();
			}
			catch ( OutOfCards ooc )
			{
				System.out.println("out of cards");
			}
		
			/* Draw second card for Dealer (up card) */
		
			dealer_second = null;
			try
			{
				dealer_second = deck.Draw();
			}
			catch ( OutOfCards ooc )
			{
        	System.out.println("out of cards");
			}
		
			if (debug) System.out.println("initial dealer cards");
			if (debug) dealer_first.PrintCard();
			if (debug) dealer_second.PrintCard();
		
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
		
			if (debug) System.out.println("FINAL PLAYER COUNT = "+player_count);
	
		
			/* play the Dealer's hand, if the Player didn't bust */
		
			dealer_count = 0;
			if ( player_count <= 21 ) {
				try
				{
					dealer_count = game.PlayDealerHand ( deck , dealer_first , dealer_second );
				}
				catch ( OutOfCards ooc )
				{
					System.out.println("out of cards");
				}
		
				if (debug) System.out.println("FINAL DEALER COUNT = "+dealer_count);
			}
		
			/* evaluate the winner */
		
			if (debug) System.out.println("");
		
			if ( player_count > 21 ) {
				if (debug) System.out.println("DEALER WINS");
				dealer_wins++;
			}
			else {
				if ( dealer_count > 21 ) {
					if (debug) System.out.println("PLAYER WINS");
					player_wins++;
				}
				else {
					if ( dealer_count == player_count ) {
						if (debug) System.out.println("PUSH");
						pushes++;
					}
					else {
						if ( dealer_count > player_count ) {
							if (debug) System.out.println("DEALER WINS");
							dealer_wins++;
						}
						else {
							if (debug) System.out.println("PLAYER WINS");
							player_wins++;
						}
					}
				}
			}   /* end of winner evaluation */
			
			if (deck.CardsLeft() < shuffle_point ) deck.ShuffleDeck();
			
		} /* end of game iteration */
		
		/* generate and print statistics */
		
		player_pct = 100*( ((float) player_wins) / ((float) (player_wins+dealer_wins)) );
		dealer_pct = 100*( ((float) dealer_wins) / ((float) (player_wins+dealer_wins)) );
		
		player_pct = Math.round(player_pct*10)/10;
		dealer_pct = Math.round(dealer_pct*10)/10;
		
		System.out.println("");
		System.out.println("PLAYER WINS "+player_wins+" "+player_pct+"%");
		System.out.println("DEALER WINS "+dealer_wins+" "+dealer_pct+"%");
		System.out.println("PUSHES      "+pushes);
	}
}
