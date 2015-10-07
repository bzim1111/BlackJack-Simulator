package blackjackSimulator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Player {
		
		/*
		 * Strategy matrices for the Player.
		 * 
		 * s  = stand
		 * h  = hit
		 * ds = double if possible, if not stand
		 * dh = double if possible, if not hit
		 * sp = split
		 * su = surrender
		 * x  = shouldn't hit this entry - this is a trap code to make sure we stay were we want to be in the matrices
		 * 
		 */
		
		/* matrix for hard hands (no aces in the hand) */
		
		String[][] player_hard = new String[][] {
		/* dealer up        2     3     4     5     6     7     8     9    10    11 */
		/* player  2 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
		/*         3 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
		/*         4 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
		/*         5 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
		/*         6 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
		/*         7 */  { "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h",  "h" },
		/*         8 */  { "h",  "h",  "h",  "dh", "dh", "h",  "h",  "h",  "h",  "h" },
		/*         9 */  { "h",  "dh", "dh", "dh", "dh", "h",  "h",  "h",  "h",  "h" },
		/*        10 */  { "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "h",  "h" },
		/*        11 */  { "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "h" },
		/*        12 */  { "h",  "h",  "s",  "s",  "s",  "h",  "h",  "h",  "h",  "h" },
		/*        13 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "h",  "h",  "h" },
		/*        14 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "h",  "h",  "h" },
		/*        15 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "h",  "su",  "h"},
		/*        16 */  { "s",  "s",  "s",  "s",  "s",  "h",  "h",  "su", "su", "su"},
		/*        17 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
		/*        18 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
		/*        19 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
		/*        20 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
		/*        21 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" }
		};
		
		
		/* matrix for soft hands (1+ aces in the hand) */
		
		String[][] player_soft = new String[][] {
		/* dealer up        2     3     4     5     6     7     8     9    10    11 */
		/* player  2 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*         3 */  { "h",  "h",  "h",  "dh", "dh", "h",  "h",  "h",  "h",  "h" },
		/*         4 */  { "h",  "h",  "h",  "dh", "dh", "h",  "h",  "h",  "h",  "h" },
		/*         5 */  { "h",  "h",  "dh", "dh", "dh", "h",  "h",  "h",  "h",  "h" },
		/*         6 */  { "h",  "h",  "dh", "dh", "dh", "h",  "h",  "h",  "h",  "h" },
		/*         7 */  { "h",  "dh", "dh", "dh", "dh", "h",  "h",  "h",  "h",  "h" },
		/*         8 */  { "s",  "ds", "ds", "ds", "ds", "s",  "s",  "h",  "h",  "h" },
		/*         9 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
		/*        10 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
		/*        11 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        12 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        13 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        14 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        15 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        16 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        17 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        18 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        19 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        20 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        21 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" }
		};
		
		
		/* matrix for pairs */
		
		String[][] player_pair = new String[][] {
		/* dealer up        2     3     4     5     6     7     8     9    10    11 */
		/* pair    2 */  { "sp", "sp", "sp", "sp", "sp", "sp", "h",  "h",  "h",  "h" },
		/*         3 */  { "sp", "sp", "sp", "sp", "sp", "sp", "h",  "h",  "h",  "h" },
		/*         4 */  { "h",  "h",  "h",  "sp", "sp", "h",  "h",  "h",  "h",  "h" },
		/*         5 */  { "dh", "dh", "dh", "dh", "dh", "dh", "dh", "dh", "h",  "h" },
		/*         6 */  { "sp", "sp", "sp", "sp", "sp", "h",  "h",  "h",  "h",  "h" },
		/*         7 */  { "sp", "sp", "sp", "sp", "sp", "sp", "h",  "h",  "h",  "h" },
		/*         8 */  { "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp"},
		/*         9 */  { "sp", "sp", "sp", "sp", "sp", "s",  "sp", "sp",  "s", "s" },
		/*        10 */  { "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s",  "s" },
		/*        11 */  { "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp", "sp"},
		/*        12 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        13 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        14 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        15 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        16 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        17 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        18 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        19 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        20 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" },
		/*        21 */  { "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x",  "x" }
		};

		
		boolean debug = false;
		boolean ok_hit, quit_hit;
		
		
		/*
		 * Constructor 
		 * Nothing to do here
		 */
		
		public Player() {	
		}
		
		
		/*
		 * Player play
		 */
		
		public int PlayPlayerHand ( Shoe shoe , Card card1, Card card2, Card dealer_upcard , Bet bet ,  Hand hand , boolean dealer_bj ) throws OutOfCards {
			
			boolean all_done , soft_done, surrender , hand_is_soft;
			
			if (debug) System.out.println("");
			if (debug) System.out.println("Playing Player Hand");
			
			/* add first card to hand */
			
			hand.AddCardToHand ( card1 );
			if (debug) hand.PrintHand();
			
			/* add second card to hand */
			
			hand.AddCardToHand ( card2 );
			if (debug) hand.PrintHand();
			
			/* clear all the flags */
			
			surrender = false;
			all_done = false;
			soft_done = false;
			
			if (debug) System.out.println("player hand value is "+hand.HandValue() );
			if (debug) System.out.println("player alt hand value is "+hand.AltHandValue());
			if (debug) System.out.println("player soft hand value is "+hand.SoftHandValue());
			
			/*
			 * Soft hand logic
			 */
			
			/* evaluate if hand is soft */
			
			hand_is_soft = false;
			if ( ( hand.SoftHandValue() <= 10 ) && ( hand.CountAces() >= 1 ) )  hand_is_soft = true;
		
			/* loop as long as hand is soft and we are not done playing */
			/* note - if we exit on soft_done, it means hand is no longer soft and we can play the hard logic. */
			/*        if we exit on all_done, hard logic will not fire later on */
			
			while ( ( ! all_done ) && ( ! soft_done) && ( hand.HandValue() <= 21 ) && ( hand_is_soft ) ) {
				
				if (debug) System.out.println("soft hand logic");
				
				/* process the action specified in the soft hand matrix */
				
				switch ( player_soft[hand.SoftHandValue()-2][dealer_upcard.card_value-2]) {    /* note (-2) since zero oriented array and array starts at card = 2 */
				
					/* stay */
				
					case "s":
						if (debug) System.out.println("player stays");
						soft_done = true;
						break;

					/* double if possible, else stay */
						
					case "ds":
						if ( hand.NumCards() == 2 ) {  /* can only double with initial hand */
							bet.DoubleBet( ((float) 2.0) );	
							try
							{
								hand.AddCardToHand ( shoe.ShoeDraw() );
								if (debug) hand.PrintHand();
							}
							catch ( OutOfCards ooc )
							{
								throw new OutOfCards();
							}
						}
						soft_done = true;   /* "ds" = double and stay, so we are done with soft */
						if (debug) System.out.println("player doubles (if possible) and stays");
						break;
						
					/* hit */
						
					case "h":
						if (debug) System.out.println("player hits");
						try
						{
							hand.AddCardToHand ( shoe.ShoeDraw() );
							if (debug) hand.PrintHand();
						}
						catch ( OutOfCards ooc )
						{
							throw new OutOfCards();
						}
						break;

					/* double if possible, else hit */
						
					case "dh":
						if ( hand.NumCards() == 2 ) {  /* can only double with initial hand */
							bet.DoubleBet( ((float) 2.0) );
							all_done = true;  /* after we hit, we are all done since we doubled */
						}
						if (debug) System.out.println("player doubles (if possible) and hits");
						try
						{
							hand.AddCardToHand ( shoe.ShoeDraw() );
							if (debug) hand.PrintHand();
						}
						catch ( OutOfCards ooc )
						{
							throw new OutOfCards();
						}
						break;
						
						/* surrender */
						
						case "su":
							if ( ! dealer_bj) bet.HalveBet( ((float) 2.0) );   /* can't surrender if dealer has blackjack */
							if (debug) System.out.println("player surrenders");
						all_done = true;
						surrender = true;
						break;
						
						/* trap - should never hit this */
						
						case "x":
							System.out.println("Hit bad entry in play table");
							all_done = true;
							break;
						
				}
				
				/* check if hand is still soft */
				
				hand_is_soft = false;
				if ( ( hand.SoftHandValue() <= 10 ) && ( hand.CountAces() >=1 ) )  hand_is_soft = true;
			}
		
				
			/*
			 * Hard hand logic
			 * 
			 * note - if we exited because of "all_done" above (e.g. doubled soft hand) hard hand logic will not be executed
			 */
			
			while ( ( ! all_done ) && ( hand.HandValue() <= 21 ) ) {
					
				if (debug) System.out.println("hard hand logic");
				
				switch ( player_hard[hand.HandValue()-2][dealer_upcard.card_value-2]) {
				
					/* stay */
				
					case "s":
						if (debug) System.out.println("player stays");
						all_done = true;
						break;

					/* double if possible, else stay */
						
					case "ds":
						if ( hand.NumCards() == 2 ) {   /* can only double with first 2 cards */
							bet.DoubleBet( ((float) 2.0));
							try
							{
								hand.AddCardToHand ( shoe.ShoeDraw() );
								if (debug) hand.PrintHand();
							}
							catch ( OutOfCards ooc )
							{
								throw new OutOfCards();
							}
						}
						all_done = true;   /* "ds" = stay, so we are all done */
						if (debug) System.out.println("player doubles (if possible) and stays");
						break;
						
					/* hit */
						
					case "h":
						if (debug) System.out.println("player hits");
						try
						{
							hand.AddCardToHand ( shoe.ShoeDraw() );
							if (debug) hand.PrintHand();
						}
						catch ( OutOfCards ooc )
						{
							throw new OutOfCards();
						}
						break;

					/* double if possible, else hit */
						
					case "dh":
						if ( hand.NumCards() == 2 ) {  /* can only double with first 2 cards */
							bet.DoubleBet( ((float) 2.0) );
							all_done = true;  /* we doubled and hit, so we are all done */
						}
						if (debug) System.out.println("player doubles (if possible) and hits");
						try
						{
							hand.AddCardToHand ( shoe.ShoeDraw() );
							if (debug) hand.PrintHand();
						}
						catch ( OutOfCards ooc )
						{
							throw new OutOfCards();
						}
						break;
						
					/* surrender */
						
					case "su":
						if ( ! dealer_bj ) bet.HalveBet( ((float) 2.0) );  /* can't surrender if dealer has blackjack, assumes "s" if so */
						if (debug) System.out.println("player surrenders");
						all_done = true;
						surrender = true;
						break;
						
					/* trap - we should never hit this */
						
					case "x":
						System.out.println("Hit bad entry in play table");
						all_done = true;
						break;
						
				}
			}
			
			if (debug) System.out.println("player hand value is "+hand.HandValue());
			
			/* make sure player loses if surrendered - note - didn't surrender if dealer had blackjack */
			
			if ( surrender && (! dealer_bj) ) return ( 22 );
			
			/* return the final hand value */
			
			if ( ( hand.HandValue() > 21 ) && ( hand.SoftHandValue() < 21 ) ) return (hand.SoftHandValue() );

			return ( hand.HandValue() );
		}
		
				
		
		/*
		 * Check if Player wants to split
		 */
		
		public boolean CheckForSplit ( Card card1 , Card card2 , Card dealer_upcard ) {
			
			/* cards have to be the same face value (e.g. both Kings) and the pair matrix has to specify split ("sp") */
			
			if ( ( card1.card_face_value == card2.card_face_value ) && 
			     ( player_pair[card1.card_value-2][dealer_upcard.card_value-2] == "sp" ) ) return true;
			
			return ( false );
		}
						
			
		/*
		 * Set up the Player strategy for hard, soft, and splits.
		 */
		
		public  void SetPlayerStrategy()  {
			SetHardStrategy();
		}
	
		
		/*
		 * Set up the Hard hand strategy.
		 */
		
		public void SetHardStrategy() {
					
			JTextArea h=new JTextArea(600,30);
			JTextArea h_title = new JTextArea(200,30);
			JTextArea h_header = new JTextArea(200,30);
			JTextArea v_title = new JTextArea(200,30);
			JTextArea[] v = new JTextArea[30];
					
			JButton ok = new JButton("Ok");
			JButton quit = new JButton("Quit");
					
			String[] options = {"S", "H", "Ds", "Dh", "SP", "SU"};
					
			JFrame f = new JFrame();
			
					
			@SuppressWarnings("unchecked")
			JComboBox<String>[][] c = new JComboBox[30][30];
					
			/* set up pull downs for each parameter */
			
			for ( int i=2; i<=21; i++ ) {
				for ( int j=2; j<=11; j++ ) {
					c[i][j] = new JComboBox<String>(options);
				}
			}
			
			/* set up the vertical labels */
			
			for ( int i=2; i<=21; i++ ) {
				v[i] = new JTextArea(60,60);
				v[i].setText(Integer.toString(i));
				v[i].setBounds(40,65+30*(i-2),60,60);
				v[i].setVisible(true);
				v[i].setEditable(false);
				v[i].setOpaque(false);;
				v[i].setForeground(Color.black);
			    v[i].setAlignmentX(JComponent.LEFT_ALIGNMENT);
			    v[i].setAlignmentY(JComponent.CENTER_ALIGNMENT);
			    f.add(v[i]);
			}
			
			/* set up the titles */
			
			f.setTitle("BlackJack Simulator Configuration");
			f.setSize(800,700); 
			f.setLayout(null);
			f.setLocationRelativeTo(null); 
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			h_header.setText("HARD HAND CONFIGURATION");
			h_header.setBounds(300,5,200,30);    
			h_header.setForeground(Color.black);
			h_header.setVisible(true);
			h_header.setEditable(false);
			h_header.setOpaque(false);
			h_header.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			h_header.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			f.add(h_header);
			
			h_title.setText("Dealer Up Card");
			h_title.setBounds(340,20,200,30);    
			h_title.setForeground(Color.black);
			h_title.setVisible(true);
			h_title.setEditable(false);
			h_title.setOpaque(false);
			h_title.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			h_title.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			f.add(h_title);
				    
			v_title.setText("Player Count");
			v_title.setBounds(5,45,200,30);    
			v_title.setForeground(Color.black);
			v_title.setVisible(true);
			v_title.setEditable(false);
			v_title.setOpaque(false);
			v_title.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			v_title.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			f.add(v_title);

			/* set up the horizontal labels */
			
			h.setText("");
			h.insert("                                   2                 3                  4                  5                  6                  7                  8                  9                10               11", 0);
			h.setBounds(0,40,800,30);    
			h.setForeground(Color.black);
			h.setVisible(true);
			h.setEditable(false);
			h.setOpaque(false);
			h.setAlignmentX(JComponent.LEFT_ALIGNMENT);
			h.setAlignmentY(JComponent.CENTER_ALIGNMENT);
			f.add(h);
			
			/* set up the drop down boxes */
			
			for ( int i=2; i<=21; i++ ) {
				
				for ( int j=2; j<=11; j++ ) {
				    c[i][j].setBounds(90+(60*(j-2)),60+(30*(i-2)),40,25);
					c[i][j].setVisible(true);
					c[i][j].setFont( new Font("Arial", Font.PLAIN, 10 ));
			
					/* set defaults based on the optimal strategy matrix defined above */
					
					switch ( player_hard[i-2][j-2] ) {
						case "s":
							c[i][j].setSelectedIndex(0);
							break;
						case "h":
							c[i][j].setSelectedIndex(1);
							break;
						case "ds":
							c[i][j].setSelectedIndex(2);
							break;
						case "dh":
							c[i][j].setSelectedIndex(3);
							break;
						case "sp":
							c[i][j].setSelectedIndex(4);
							break;
						case "su":
							c[i][j].setSelectedIndex(5);
					}
					
					/* add the drop down to the frame */
					
					f.add(c[i][j]);
				 }
			}
				    
			/* Add Ok / Quit buttons */
					
			ok.setBounds(700,300,75,40);
			ok.setVisible(true);
			f.add ( ok );
			quit.setBounds(700,400,75,40);
			quit.setVisible(true);
			f.add ( quit );
				    
			f.setVisible(true);
				
			/* Listener for "ok" button */
				
			ok_hit = false;
			
			ok.addActionListener ( new ActionListener() {
						
				public void actionPerformed ( ActionEvent ae ) {		
					ok_hit = true;
					System.out.println("ok hit");
				}
						
			} );
				    
			/* Listener for "quit" button */
				   
			quit_hit = false;
			
			quit.addActionListener ( new ActionListener() {
						
				public void actionPerformed ( ActionEvent ae ) {
					quit_hit = true;
					System.out.println("quit hit");
				}
						
			} );
			
			/* wait until ok or quit is hit */
			
			do {
				//do nothing
				try {
					Thread.sleep(500);
				} catch (InterruptedException ex ){
				}
			} while ( (! ok_hit) && (! quit_hit) );
			
			/* erase the frame */
			
			f.setVisible(false);
			
			/* if quit, exit */
			
			if ( quit_hit ) System.exit(0);
			
		}

	}

