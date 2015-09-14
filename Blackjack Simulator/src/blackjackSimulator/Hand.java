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
	
	
	public void AddCardToHand ( Card c ) {
		hand[num_cards++] = c;
	}
	
	
	public boolean HasAce() {
		int i;
		
		for ( i=0; i<num_cards; i++ ) {
			if ( hand[i].card_value == 11 ) return true;
		}
		return false;
	}
	
	
	public int CountAces() {
		int i;
		int ac;
		
		ac = 0;
		for ( i=0; i<num_cards; i++ ) {
			if ( hand[i].card_value == 11 ) ac++;
		}
		
		return ( ac );
	}
	
	
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
