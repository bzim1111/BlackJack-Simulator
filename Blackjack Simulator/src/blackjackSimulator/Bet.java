package blackjackSimulator;

public class Bet {
	
	private double bet_amount;
	
	Bet() {
		bet_amount = 1.0;  /* standard is one unit */
	}
	
	
	public void DoubleBet() {
		bet_amount = bet_amount * 2.0;
	}
	
	
	public void HalveBet() {
		bet_amount = bet_amount / 2.0;
	}
	
	
	public void BJWinBet() {
		bet_amount = bet_amount * 1.5;
	}

	
	public double BetAmount() {
		return bet_amount;
	}
}
