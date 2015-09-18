package blackjackSimulator;

import java.text.DecimalFormat;

public class BlackjackSimulator {

	
	public static void main(String[] args) {
		
		int dealer_count , player_count, split_count, count_high_target , count_doubles, count_low_target , count_halves;
		Card dealer_first , dealer_second , player_first , player_second , split_first , split_second , temp;
		int i , j;
		int num_iterations, shuffle_point , num_decks;
		int dealer_wins, player_wins, pushes;
		float dealer_pct, player_pct;
		boolean debug, dealer_has_bj , split, count_cards;
		double bankroll, pct_per_hand;
		DecimalFormat df = new DecimalFormat("0.0");
		Bet player_bet, split_bet;
		Hand player_hand, split_hand;
		Game game;
		
		debug = false;				/* turn on/off debug */
		
		/*
		 * Parameters - will be replaced with GUI and XML/JSON
		 */
		
		num_iterations = 100000;	/* number of iterations to simulate */
		shuffle_point  = 20;		/* when this many or fewer cards left in shoe, re-shuffle */
		num_decks = 8;				/* number of decks in the shoe */
		
		count_high_target = 3;		/* when counting cards, raise bet when this count is hit */
		count_doubles = 3;			/* number of times to double the bet (e.g. 3 = 8 times the base bet) */
		
		count_low_target = -3;		/* when counting cards, lower bet when this count is hit */
		count_halves = 3;			/* number of times to halve the bet (e.g. 3 = 1/8 the base bet) */
		
		count_cards = true;			/* turn on/off card counting */
		
		/* initialize some counters */
		
		dealer_wins = 0;
		player_wins = 0;
		pushes = 0;
		bankroll = 0.0;
		
		/* create the shoe and shuffle */

		Shoe shoe = new Shoe ( num_decks );
		shoe.ShuffleShoe();
		
		/* create the game */
		
		game = new Game();
		
		/* iterate through the specified number of hand simulations */
		
		for ( j=1; j<=num_iterations; j++ ) {
		
			/* create the Player hand */
			
			player_hand = new Hand();
		
			/* Draw first card for Dealer (down card) */
		
			dealer_first = null;
			try
			{
				dealer_first = shoe.ShoeDraw();
			}
			catch ( OutOfCards ooc )
			{
				System.out.println("out of cards");
			}
		
			/* Draw second card for Dealer (up card) */
		
			dealer_second = null;
			try
			{
				dealer_second = shoe.ShoeDraw();
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
			
			/* draw first card for Player */
			
			player_first = null;
			try
	        {
				player_first = shoe.ShoeDraw();
	        }
	        catch ( OutOfCards ooc )
	        {
	        	System.out.println("out of cards");
	        }
			
			/* draw second card for Player */
			
			player_second = null;
			try
	        {
				player_second = shoe.ShoeDraw();
	        }
	        catch ( OutOfCards ooc )
	        {
	            System.out.println("out of cards");
	        }

			/* check if the Player wants to split */
			
			split = game.CheckForSplit ( player_first , player_second , dealer_second );
			
			/* initialize the split variables */
			
			split_first = null;
			split_second = null;
			split_first = null;
			split_second = null;
			split_bet = null;
			split_hand = null;
			split_count = 0;
			
			if (debug) System.out.println("checking split "+player_first.card_face_value+" "+player_second.card_face_value);
			
			if ( split ) {
				
				if (debug) System.out.println("we are going to split "+player_first.card_face_value+" "+player_second.card_face_value);
			
				/* temporarily store the second card */
				
				temp = player_second;
				
				/* get a new second card for the main hand */
				
				try
		        {
					player_second = shoe.ShoeDraw();
		        }
		        catch ( OutOfCards ooc )
		        {
		            System.out.println("out of cards");
		        }
				
				/* get a new first card for the split hand */
				
				split_second = temp;
				try
		        {
					split_first = shoe.ShoeDraw();
		        }
		        catch ( OutOfCards ooc )
		        {
		            System.out.println("out of cards");
		        }
				
				/* establish a second bet */
				
				split_bet = new Bet();
				
				/* establish a new player_hand */
				
				split_hand = new Hand();
			}
			
			/* play the Player's first hand */		

			player_count = 0;
			player_bet = new Bet();
		
			try
			{
				/* process card counting, if enabled */
				
				if ( ( shoe.ShoeCardCount() >= count_high_target ) && ( count_cards ) ) {
					for ( i=1; i<= count_doubles; i++ ) player_bet.DoubleBet();
				}
				if ( ( shoe.ShoeCardCount() <= count_low_target ) && ( count_cards ) ) {
					for ( i=1; i<= count_halves; i++ ) player_bet.HalveBet();
				}

				/* play the hand */
				
				player_count = game.PlayPlayerHand ( shoe , player_first , player_second , dealer_second , player_bet, player_hand , dealer_has_bj );
			}
			catch ( OutOfCards ooc )
			{
				System.out.println("out of cards");
			}
		
			if (debug) System.out.println("FINAL PLAYER COUNT = "+player_count);
			if (debug) System.out.println("FINAL PLAYER BET = "+df.format(player_bet.BetAmount()));
	
			
			/* play the Player's second hand, if he chose to split */	

			split_count = 0;
			
			if ( split ) {
		
				try
				{
					/* handle card counting, if enabled */
					
					if ( ( shoe.ShoeCardCount() >= count_high_target ) && ( count_cards ) ) {
						for ( i=1; i<= count_doubles; i++ ) player_bet.DoubleBet();
					}
					if ( ( shoe.ShoeCardCount() <= count_low_target ) && ( count_cards ) ) {
						for ( i=1; i<= count_halves; i++ ) player_bet.HalveBet();
					}

					/* play the second hand */
					
					split_count = game.PlayPlayerHand ( shoe , split_first , split_second , dealer_second , split_bet, split_hand , dealer_has_bj );
				}
				catch ( OutOfCards ooc )
				{
					System.out.println("out of cards");
				}
		
				if (debug) System.out.println("FINAL PLAYER COUNT = "+split_count);
				if (debug) System.out.println("FINAL PLAYER BET = "+df.format(split_bet.BetAmount()));	
			}
		
			/* play the Dealer's hand, if the Player didn't bust */
		
			dealer_count = 0;
			if ( ( player_count <= 21 ) || ( split && (split_count <= 21) ) ) {
				try
				{
					dealer_count = game.PlayDealerHand ( shoe , dealer_first , dealer_second );
				}
				catch ( OutOfCards ooc )
				{
					System.out.println("out of cards");
				}
		
				if (debug) System.out.println("FINAL DEALER COUNT = "+dealer_count);
			}
		
			/* evaluate the winner of the first hand */
		
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
			
			/* evaluate the winner of the second hand, if it was played */
			
			if ( split ) {
				
				if (debug) System.out.println("");
				
				if ( split_count > 21 ) {
					if (debug) System.out.println("DEALER WINS");
					dealer_wins++;
					bankroll = bankroll - split_bet.BetAmount();
				}
				else {
					if ( dealer_count > 21 ) {
						if (debug) System.out.println("PLAYER WINS");
						player_wins++;
						if (( split_count == 21 ) && ( split_hand.NumCards() == 2 )) split_bet.BJWinBet();
						bankroll = bankroll + split_bet.BetAmount();
					}
					else {
						if ( dealer_count == split_count ) {
							if (debug) System.out.println("PUSH");
							pushes++;
						}
						else {
							if ( dealer_count > split_count ) {
								if (debug) System.out.println("DEALER WINS");
								dealer_wins++;
								bankroll = bankroll - split_bet.BetAmount();
							}
							else {
								if (debug) System.out.println("PLAYER WINS");
								player_wins++;
								if (( split_count == 21 ) && ( split_hand.NumCards() == 2 )) split_bet.BJWinBet();
								bankroll = bankroll + split_bet.BetAmount();
							}
						}
					}
				}   /* end of winner evaluation */
			}
			
			/* if we hit the shuffle point number of cards left, re-shuffle */
			
			if (shoe.ShoeCardsLeft() < shuffle_point ) shoe.ShuffleShoe();
			
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
