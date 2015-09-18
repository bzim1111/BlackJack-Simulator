package blackjackSimulator;

public class Bet {
	
	private double bet_amount;
	
	/*
	 * Constructor
	 */
	
	Bet() {
		bet_amount = 1.0;  /* standard is one unit */
	}
	
	
	/*
	 * Double a bet 
	 */
	
	public void DoubleBet() {
		bet_amount = bet_amount * 2.0;
	}
	
	
	/*
	 * Halve a bet
	 */
	
	public void HalveBet() {
		bet_amount = bet_amount / 2.0;
	}
	
	
	/*
	 * Multiply bet by 1.5 (blackjack winning hand)
	 */
	
	public void BJWinBet() {
		bet_amount = bet_amount * 1.5;
	}

	
	/*
	 * Return the current bet amount
	 */
	
	public double BetAmount() {
		return bet_amount;
	}
}
