package blackjackSimulator;

import java.util.Random;

public class Shoe {

	private int num_decks , shoe_card_count , shoe_current_card;
	private Deck[] shoe_decks;
	private int[] shoe_draw_order;
	
	
	public Shoe ( int d ) {		
		num_decks = d;
		shoe_decks = new Deck[num_decks];	/* have to bounds check this */	
	}
	
	
	public Card ShoeDraw() throws OutOfCards {
		
		Card c;
		int which_deck;
		
		which_deck = shoe_draw_order[shoe_current_card] / 52;
		
		c = shoe_decks[which_deck].GetCard(shoe_draw_order[shoe_current_card]%52);
		
		if ( c.card_value <= 6 ) shoe_card_count++;
		if ( c.card_value >= 10 ) shoe_card_count--;
		
		if ( shoe_current_card < (52*num_decks) )
			return c;
		else
			throw new OutOfCards();
	}
	

	public int ShoeCardCount() {
		return shoe_card_count;
	}
	
	
	public void ShuffleShoe() {
		
		int i;
		boolean[] used = new boolean[52*num_decks];
		
		shoe_draw_order = new int[52*num_decks];
		
		/* mark all draw order slots unused */
		
		for ( i=0; i<(52*num_decks); i++ ) used[i] = false;
		
		Random randomGenerator = new Random();
		

		boolean done = false;
		int current_position = 0;
		shoe_card_count = 0;
		
		/* initialize the used array for random numbers */
		
		for ( i=0; i<(52*num_decks); i++ ) {
			used[i] = false;
		}
		
		while ( ! done ) {
			
			/* check to see if we are done */
			
			done = true;
			
			for ( i=0; i<(52*num_decks); i++ ) {
				if ( used[i] == false ) {
					done = false;
				}
			}
			
			/* if we are not done, fill the next draw position */
			
			if ( ! done ) {
				
				int random = randomGenerator.nextInt(52*num_decks);

				/* check if this random number has already been used */
				
				if ( used[random] == false ) {
					
					/* put the random number in the current draw position */
					
					shoe_draw_order[current_position] = random;
					
					/* mark this random number position as used */
					
					used[random] = true;
					
					/* move to the next draw position */
					
					current_position++;
				}
			}
		}
		
		/* re-set the current draw position */
		
		shoe_current_card = 0;
		
		/* re-set the card count */
		
		shoe_card_count = 0;
	}
	
	
	public int ShoeCardsLeft() {
		return ( (num_decks*52) - shoe_current_card );
	}

	
	public void ResetDeck() {
		shoe_current_card = 0;
	}
	
	
}
