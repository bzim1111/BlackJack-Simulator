package blackjackSimulator;
	
import java.util.Random;

public class Deck {
	
	private Card deck[] = new Card[52];
	private int current_card = 0;
	private int[] draw_order = new int[52];
	private int card_count;

	
	/*
	 * Constructor
	 */
	
	public Deck ()	{
		
		int i;
		
		i = 0;
		
		/* create all combinations of suit (e.g. Clubs) + face value (e.g. King) */
		
		for ( suit s : suit.values() ) {
			for ( face_value fv : face_value.values() ) {
				deck[i] = new Card (s , fv );
				i++;
			}
		}
	}
	
	
	/*
	 * Draw a card from the deck
	 */
	
	public Card Draw() throws OutOfCards {
		
		Card c;
		
		c = deck[draw_order[current_card++]];   /* draw based on the current entry in draw order, increment current card index */
		
		/* process card count */
		
		if ( c.card_value <= 6 ) card_count++;
		if ( c.card_value >= 10 ) card_count--;
		
		/* return drawn card, but make sure we haven't gone off the end of the deck */
		
		if ( current_card < 52 )
			return c;
		else
			throw new OutOfCards();
	}
	
	
	/*
	 * Get a specific card from the deck
	 */
	
	public Card GetCard ( int card_num ) {
		return ( deck[card_num] );
	}
	
	
	/*
	 * Return the current card count
	 */
	
	public int CardCount() {
		return card_count;
	}
	
	
	/*
	 * Shuffle the deck
	 * 
	 * This uses a parallel matrix draw_order.  This matrix is randomly filled with the numbers between 0-51.
	 * When you want to draw a card, the draw_order matrix tells which card (from the ordered deck ) to draw.
	 * The deck itself is not shuffled - it stays in order but is drawn randomly from the draw_order matrix.
	 */
	
	public void ShuffleDeck() {
		
		int i;
		boolean[] used = new boolean[52];
		
		/* mark all draw order slots unused */
		
		for ( i=0; i<52; i++ ) used[i] = false;
		
		/* create the random generator */
		
		Random randomGenerator = new Random();
		

		boolean done = false;
		int current_position = 0;
		
		/* initialize the used array for random numbers - tracks whether that random number 0-51 has been used */
		
		for ( i=0; i<52; i++ ) {
			used[i] = false;
		}
		
		/* loop until the draw order matrix is full and we've allocated all the 0-51 random draw positions */
		/* note - this is pretty inefficient, but I don't have a better way to do it right now */
		/*        can't use hashing, since the collision resolution will result in "runs" of sequential cards */
		
		while ( ! done ) {
			
			/* check to see if we are done */
			
			done = true;
			
			for ( i=0; i<52; i++ ) {
				if ( used[i] == false ) {
					done = false;
				}
			}
			
			/* if we are not done, fill the next draw position */
			
			if ( ! done ) {
				
				int random = randomGenerator.nextInt(52);

				/* check if this random number has already been used */
				
				if ( used[random] == false ) {
					
					/* put the random number in the current draw position */
					
					draw_order[current_position] = random;
					
					/* mark this random number position as used */
					
					used[random] = true;
					
					/* move to the next draw position */
					
					current_position++;
				}
			}
		}
		
		/* re-set the current draw position */
		
		current_card = 0;
		
		/* re-set the card count since we shuffled the deck */
		
		card_count = 0;
	}
	
	
	/* return the number of cards left to be drawn */
	
	public int CardsLeft() {
		return ( 52 - current_card );
	}

	
	/* re-set the deck to the first position - used for debugging to process the same draw order over and over */
	
	public void ResetDeck() {
		current_card = 0;
	}
	
}
