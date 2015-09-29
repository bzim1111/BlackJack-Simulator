package blackjackSimulator;

import static org.junit.Assert.*;

import org.junit.Test;

public class DeckTest {

	
	@Test
	public void testDeck() {
		
		Card test_card;
		Deck test_deck = new Deck();
		
		test_card = test_deck.GetCard(0);
		assertEquals(11,test_card.card_value);
		
		test_card = test_deck.GetCard(5);
		assertEquals(6,test_card.card_value);
		
		/*fail("Not yet implemented");*/
	}

	
	@Test
	public void testDraw() {
		
		Card test_card;
		Deck test_deck = new Deck();
		
		test_card = null;
		try
		{
			test_card = test_deck.Draw();
		}
		catch ( OutOfCards ooc )
		{
			System.out.println("out of cards");
		}

		assertEquals(11,test_card.card_value);
		assertEquals(-1,test_deck.CardCount());

	}

	
	@Test
	public void testGetCard() {
		
		Card test_card;
		Deck test_deck = new Deck();
		
		test_card = test_deck.GetCard(20);
		assertEquals(8,test_card.card_value);

	}

	
	@Test
	public void testCardCount() {
		
		int i;
		Deck test_deck = new Deck();
		
		for ( i=1; i<=4; i++ ) {
			try
			{
				test_deck.Draw();
			}
			catch ( OutOfCards ooc )
			{
				System.out.println("out of cards");
			}
		}

		assertEquals(-4,test_deck.CardCount());
	}

	

	@Test
	public void testCardsLeft() {
		/*fail("Not yet implemented");*/
		
		int i;
		Deck test_deck = new Deck();
		
		for ( i=1; i<=5; i++ ) {
			try
			{
				test_deck.Draw();
			}
			catch ( OutOfCards ooc )
			{
				System.out.println("out of cards");
			}
		}

		assertEquals(47,test_deck.CardsLeft());
	}


}
