package blackjackSimulator;

public class Hand {

	private Card hand[] = new Card[52];
	private int num_cards;
	
	public Hand () {
		num_cards = 0;
	}
	
	public int HandValue () {	
		int i;
		int count;
		
		count = 0;
		for ( i=0; i<num_cards; i++ ) {
			count = count + hand[i].card_value;
		}
		
		return ( count );
	}
	
	
	public void AddCardToHand ( Card c ) {
		hand[num_cards++] = c;
	}
	
	
	public void PrintHand() {
		int i;
		
		System.out.println("-------------------");
		for ( i=0; i<num_cards; i++ ) {
			hand[i].PrintCard();
		}
		System.out.println("-------------------");
	}
	
}
