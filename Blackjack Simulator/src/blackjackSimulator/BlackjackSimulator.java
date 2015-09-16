package blackjackSimulator;

import java.text.DecimalFormat;

public class BlackjackSimulator {

	
	public static void main(String[] args) {
		
		int dealer_count , player_count;
		Card dealer_first , dealer_second;
		int j;
		int num_iterations, shuffle_point;
		int dealer_wins, player_wins, pushes;
		float dealer_pct, player_pct;
		boolean debug, dealer_has_bj;
		double bankroll, pct_per_hand;
		DecimalFormat df = new DecimalFormat("0.0");
		
		debug = false;
		
		num_iterations = 1000000;
		shuffle_point  = 20;
		
		dealer_wins = 0;
		player_wins = 0;
		pushes = 0;
		bankroll = 0.0;
		

		Deck deck = new Deck();
		deck.ShuffleDeck();
		
		for ( j=1; j<=num_iterations; j++ ) {
		
			Game game = new Game();
			Hand player_hand = new Hand();
		
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
			
			/* check Dealer's hand for blackjack */
			dealer_has_bj = false;
			if ( (dealer_first.card_value + dealer_second.card_value) == 21 ) dealer_has_bj = true;
		
			/* play the Player's hand */		

			player_count = 0;
			Bet player_bet = new Bet();
		
			try
			{
				player_count = game.PlayPlayerHand ( deck , dealer_second , player_bet, player_hand , dealer_has_bj );
			}
			catch ( OutOfCards ooc )
			{
				System.out.println("out of cards");
			}
		
			if (debug) System.out.println("FINAL PLAYER COUNT = "+player_count);
			if (debug) System.out.println("FINAL PLAYER BET = "+df.format(player_bet.BetAmount()));
	
		
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
				bankroll = bankroll - player_bet.BetAmount();
			}
			else {
				if ( dealer_count > 21 ) {
					if (debug) System.out.println("PLAYER WINS");
					player_wins++;
					if (( player_count == 21 ) && ( player_hand.NumCards() == 2 )) player_bet.BJWinBet();
					bankroll = bankroll + player_bet.BetAmount();
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
							bankroll = bankroll - player_bet.BetAmount();
						}
						else {
							if (debug) System.out.println("PLAYER WINS");
							player_wins++;
							if (( player_count == 21 ) && ( player_hand.NumCards() == 2 )) player_bet.BJWinBet();
							bankroll = bankroll + player_bet.BetAmount();
						}
					}
				}
			}   /* end of winner evaluation */
			
			if (deck.CardsLeft() < shuffle_point ) deck.ShuffleDeck();
			
		} /* end of game iteration */
		
		/* generate statistics */
		
		player_pct   = 100*( ((float) player_wins) / ((float) (player_wins+dealer_wins)) );
		dealer_pct   = 100*( ((float) dealer_wins) / ((float) (player_wins+dealer_wins)) );		
		pct_per_hand = 100*(bankroll / ((double) num_iterations) );
		
		/* print statistics */
		
		System.out.println("");
		System.out.println("PLAYER WINS "+player_wins+" "+df.format(player_pct)+"%");
		System.out.println("DEALER WINS "+dealer_wins+" "+df.format(dealer_pct)+"%");
		System.out.println("PUSHES      "+pushes);
		System.out.println("");
		System.out.println("BANKROLL    "+bankroll);
		System.out.println("%/HAND      "+df.format(pct_per_hand)+"%");
	}
}
