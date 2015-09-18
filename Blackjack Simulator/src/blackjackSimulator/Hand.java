package blackjackSimulator;

public class Hand {

	private Card hand[] = new Card[52];
	private int num_cards;
	
	
	/*
	 * Constructor
	 */
	
	public Hand () {
		num_cards = 0;   /* initialize 0 cards in the hand */
	}
	
	
	/*
	 * Evaluate the hand value (sum of the card values), with Ace=11
	 */
	
	public int HandValue () {	
		int i;
		int count;
		
		count = 0;
		for ( i=0; i<num_cards; i++ ) {
			count = count + hand[i].card_value;
		}
		
		return ( count );
	}
	
	
	/*
	 * Evaluate the a final hand value - with Aces = 1 until the hand count < 21
	 */
	
	public int AltHandValue() {
		int ac;
		int count;
		
		count = this.HandValue();
		ac = this.CountAces();
		
		while ( ac > 0 ) {
			if ( count > 21 ) count = count - 10;
			ac--;
		}
		
		return ( count );
	}
	
	
	/*
	 * Evaluate a "soft" hand value - with all Aces = 1
	 */
	
	public int SoftHandValue() {
		int ac;
		int count;
		
		count = this.HandValue();
		ac = this.CountAces();
		
		while ( ac > 0 ) {
			count = count - 10;
			ac--;
		}
		
		return ( count );
	}
	
	
	/*
	 * Add a card to the hand, increment number of cards in the hand
	 */
	
	public void AddCardToHand ( Card c ) {
		hand[num_cards++] = c;
	}
	
	
	/*
	 * Check if a hand has an ace
	 */
	
	public boolean HasAce() {
		int i;
		
		for ( i=0; i<num_cards; i++ ) {
			if ( hand[i].card_value == 11 ) return true;
		}
		return false;
	}
	
	
	/*
	 * Count the aces in a hand
	 */
	
	public int CountAces() {
		int i;
		int ac;
		
		ac = 0;
		for ( i=0; i<num_cards; i++ ) {
			if ( hand[i].card_value == 11 ) ac++;
		}
		
		return ( ac );
	}
	
	
	/*
	 * Return the number of cards in a hand
	 * note - num_cards starts at 0, so even though it's been incremented it's the correct count for the hand
	 */
	
	public int NumCards() {
		return ( num_cards );
	}
	
	
	/*
	 * Print out a hand
	 */
	
	public void PrintHand() {
		int i;
		
		System.out.println("-------------------");
		for ( i=0; i<num_cards; i++ ) {
			hand[i].PrintCard();
		}
		System.out.println("value = "+this.HandValue());
		System.out.println("alt value = "+this.AltHandValue());
		System.out.println("has ace = "+this.HasAce());
		System.out.println("ace count = "+this.CountAces());
		System.out.println("-------------------");
	}
	
}
