package blackjackSimulator;

/*
 * Custom exception for trying to draw past the end of the deck
 */

public class OutOfCards extends Throwable {

	private static final long serialVersionUID = 1L;
	
	public OutOfCards() { 
		super();
	}
	
};