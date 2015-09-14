package blackjackSimulator;
	
import java.util.Random;

public class Deck {
	
	private Card deck[] = new Card[52];
	private int current_card = 0;
	private int[] draw_order = new int[52];

	
	public Deck ()	{
		
		int i;
		
		i = 0;
		
		for ( suit s : suit.values() ) {
			for ( face_value fv : face_value.values() ) {
				deck[i] = new Card (s , fv );
				i++;
			}
		}
	}
	
	
	public Card Draw() throws OutOfCards {
		if ( current_card < 52 )
			return deck[draw_order[current_card++]];
		else
			throw new OutOfCards();
	}
	
	
	public void ShuffleDeck() {
		
		int i;
		boolean[] used = new boolean[52];
		
		/* mark all draw order slots unused */
		
		for ( i=0; i<52; i++ ) used[i] = false;
		
		Random randomGenerator = new Random();
		

		boolean done = false;
		int current_position = 0;
		
		/* initialize the used array for random numbers */
		
		for ( i=0; i<52; i++ ) {
			used[i] = false;
		}
		
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
	}
	
	
	public int CardsLeft() {
		return ( 52 - current_card );
	}

	
	public void ResetDeck() {
		current_card = 0;
	}
	
}
