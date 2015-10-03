package blackjackSimulator;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.*;

public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* If possible this method opens the default browser to the specified web page.
	* If not it notifies the user of webpage's url so that they may access it
	* manually.
	* 
	* @param url
	*            - this can be in the form of a web address (http://www.mywebsite.com)
	*            or a path to an html file or SVG image file e.t.c 
	*/
	
		static JFrame f = new JFrame();
		static JButton run = new JButton("Run");
		static JTextArea iter=new JTextArea(150,30);
		static JTextField iter_i=new JTextField(75);
		static JTextArea decks=new JTextArea(150,30);
		static JRadioButton r1 = new JRadioButton("On");
		static JRadioButton r2 = new JRadioButton("Off");
		static JTextArea cut=new JTextArea(150,30);
		
		static JTextArea cc=new JTextArea(150,30);
		static JTextArea high=new JTextArea(150,30);
		static JTextArea highd=new JTextArea(150,30);
		static JTextArea low=new JTextArea(150,30);
		static JTextArea lowh=new JTextArea(150,30);

		
		static JTextArea res=new JTextArea(150,30);
		static JTextArea pw=new JTextArea(150,30);
		static JTextArea dw=new JTextArea(150,30);
		static JTextArea pp=new JTextArea(150,30);
		static JTextArea br=new JTextArea(150,30);
		static JTextArea pct=new JTextArea(150,30);
		static JTextArea pw_r=new JTextArea(150,30);
		static JTextArea dw_r=new JTextArea(150,30);
		static JTextArea pp_r=new JTextArea(150,30);
		static JTextArea br_r=new JTextArea(150,30);
		static JTextArea pct_r=new JTextArea(150,30);
		
		DecimalFormat df = new DecimalFormat("0.0");
		
		
		/*
		 * Set up the menu.
		 */
		
		public void setup_menu() {
			  
		    f.setTitle("My Empty Frame");
			f.setSize(600,600); 
			f.setLayout(null);
			f.setLocationRelativeTo(null); 
			f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			/* Run / Quit */
			
			run.setBounds(250,500,75,40);
			f.add ( run );
			run.setVisible(true);
			
			/* Number of Iterations */
			
			iter.insert("Number of Iterations", 0);
		    iter.setBounds(100,50,150,30);    
		    iter.setForeground(Color.black);
		    iter.setVisible(true);
		    iter.setEditable(false);
		    iter.setOpaque(false);
		    iter.setAlignmentX(LEFT_ALIGNMENT);
		    iter.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(iter);
		    
		    iter_i.setBounds(300,50,75,30);  
		    iter_i.setBackground(Color.white);  
		    iter_i.setForeground(Color.black);
		    iter_i.setAlignmentY(CENTER_ALIGNMENT);
		    iter_i.setBorder(BorderFactory.createLineBorder(Color.black));
		    iter_i.setVisible(true);    
		    f.add(iter_i);  
		    
		    /* Number of decks */
		    
			decks.insert("Number of Decks", 0);
		    decks.setBounds(100,100,150,30);    
		    decks.setForeground(Color.black);
		    decks.setVisible(true);
		    decks.setEditable(false);
		    decks.setOpaque(false);
		    decks.setAlignmentX(LEFT_ALIGNMENT);
		    decks.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(decks);

		    
		    /* Cut point */
		    
			cut.insert("Cards Left When Cut", 0);
		    cut.setBounds(100,125,150,30);    
		    cut.setForeground(Color.black);
		    cut.setVisible(true);
		    cut.setEditable(false);
		    cut.setOpaque(false);
		    cut.setAlignmentX(LEFT_ALIGNMENT);
		    cut.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(cut);

		    
		    /* Card Counting on/off */
		    
		    r1.setBounds(300,150,75,30);
		    r2.setBounds(375,150,75,30);
		    ButtonGroup bg = new ButtonGroup();
		    bg.add(r1);
		    bg.add(r2);
		    f.add(r1);
		    f.add(r2);
	
			cc.insert("Card Counting", 0);
		    cc.setBounds(100,150,150,30);    
		    cc.setForeground(Color.black);
		    cc.setVisible(true);
		    cc.setEditable(false);
		    cc.setOpaque(false);
		    cc.setAlignmentX(LEFT_ALIGNMENT);
		    cc.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(cc);
		    
		    /* Card Counting Parameters */
		    
			high.insert("High Count Target", 0);
			high.setBounds(100,170,150,30);    
			high.setForeground(Color.black);
			high.setVisible(true);
			high.setEditable(false);
			high.setOpaque(false);
			high.setAlignmentX(LEFT_ALIGNMENT);
			high.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(high);
		    
		    highd.insert("High Times to Double", 0);
			highd.setBounds(100,190,150,30);    
			highd.setForeground(Color.black);
			highd.setVisible(true);
			highd.setEditable(false);
			highd.setOpaque(false);
			highd.setAlignmentX(LEFT_ALIGNMENT);
			highd.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(highd);
		    
		    low.insert("Low Count Target", 0);
		    low.setBounds(100,210,150,30);    
		    low.setForeground(Color.black);
		    low.setVisible(true);
		    low.setEditable(false);
		    low.setOpaque(false);
		    low.setAlignmentX(LEFT_ALIGNMENT);
		    low.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(low);
		    
		    lowh.insert("Low Times to Halve", 0);
		    lowh.setBounds(100,230,150,30);    
		    lowh.setForeground(Color.black);
		    lowh.setVisible(true);
		    lowh.setEditable(false);
		    lowh.setOpaque(false);
		    lowh.setAlignmentX(LEFT_ALIGNMENT);
		    lowh.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(lowh);

		    
		    /* Results */
		    
			res.insert("Results", 0);
		    res.setBounds(250,300,150,30);    
		    res.setForeground(Color.black);
		    res.setVisible(true);
		    res.setEditable(false);
		    res.setOpaque(false);
		    res.setAlignmentX(LEFT_ALIGNMENT);
		    res.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(res);
		    
			pw.insert("Player Wins", 0);
		    pw.setBounds(100,325,150,30);    
		    pw.setForeground(Color.black);
		    pw.setVisible(true);
		    pw.setEditable(false);
		    pw.setOpaque(false);
		    pw.setAlignmentX(LEFT_ALIGNMENT);
		    pw.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pw);
		    
			dw.insert("Dealer Wins", 0);
		    dw.setBounds(100,350,150,30);    
		    dw.setForeground(Color.black);
		    dw.setVisible(true);
		    dw.setEditable(false);
		    dw.setOpaque(false);
		    dw.setAlignmentX(LEFT_ALIGNMENT);
		    dw.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(dw);
		    
			pp.insert("Pushes", 0);
		    pp.setBounds(100,375,150,30);    
		    pp.setForeground(Color.black);
		    pp.setVisible(true);
		    pp.setEditable(false);
		    pp.setOpaque(false);
		    pp.setAlignmentX(LEFT_ALIGNMENT);
		    pp.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pp);
		    
			br.insert("Ending Bankroll", 0);
			br.setBounds(100,400,150,30);    
			br.setForeground(Color.black);
			br.setVisible(true);
			br.setEditable(false);
			br.setOpaque(false);
			br.setAlignmentX(LEFT_ALIGNMENT);
			br.setAlignmentY(CENTER_ALIGNMENT);
			f.add(br);
			
			pct.insert("% per Hand", 0);
			pct.setBounds(100,425,150,30);    
			pct.setForeground(Color.black);
			pct.setVisible(true);
			pct.setEditable(false);
			pct.setOpaque(false);
			pct.setAlignmentX(LEFT_ALIGNMENT);
			pct.setAlignmentY(CENTER_ALIGNMENT);
			f.add(pct);

		    pw_r.setBounds(300,325,150,30);    
		    pw_r.setForeground(Color.black);
		    pw_r.setVisible(true);
		    pw_r.setEditable(false);
		    pw_r.setOpaque(false);
		    pw_r.setAlignmentX(LEFT_ALIGNMENT);
		    pw_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pw_r);
		    
		    dw_r.setBounds(300,350,150,30);    
		    dw_r.setForeground(Color.black);
		    dw_r.setVisible(true);
		    dw_r.setEditable(false);
		    dw_r.setOpaque(false);
		    dw_r.setAlignmentX(LEFT_ALIGNMENT);
		    dw_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(dw_r);

		    pp_r.setBounds(300,375,150,30);    
		    pp_r.setForeground(Color.black);
		    pp_r.setVisible(true);
		    pp_r.setEditable(false);
		    pp_r.setOpaque(false);
		    pp_r.setAlignmentX(LEFT_ALIGNMENT);
		    pp_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pp_r);
		    
		    br_r.setBounds(300,400,150,30);    
		    br_r.setForeground(Color.black);
		    br_r.setVisible(true);
		    br_r.setEditable(false);
		    br_r.setOpaque(false);
		    br_r.setAlignmentX(LEFT_ALIGNMENT);
		    br_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(br_r);
		    
		    pct_r.setBounds(300,425,150,30);    
		    pct_r.setForeground(Color.black);
		    pct_r.setVisible(true);
		    pct_r.setEditable(false);
		    pct_r.setOpaque(false);
		    pct_r.setAlignmentX(LEFT_ALIGNMENT);
		    pct_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pct_r);

		    /* Display */
		    
		    iter_i.requestFocusInWindow();
		    f.setSize(600,600); 
		    f.setLayout(null);  
		    f.setVisible(true);  
		    
			
		  } // end setup
		
		
		/*
		 * Get parameters and return them
		 */
		
		public void process_menu ( final Params params ) {
			
			run.addActionListener ( new ActionListener() {
				
				public void actionPerformed ( ActionEvent ae ) {
					String iter_input = iter_i.getText();
					params.set_num_iterations( Integer.valueOf(iter_input) );
					params.set_run ( true );
				}
				
			} );
						
		}
		
		
		/*
		 * Display results of the run
		 */
		
		public void display_results ( int player_wins , float player_pct , int dealer_wins , float dealer_pct ,
										int pushes , double bankroll , double pct_per_hand ) {
			
			pw_r.insert(Integer.toString(player_wins)+"  ("+df.format(player_pct)+"%)", 0);
			dw_r.insert(Integer.toString(dealer_wins)+"  ("+df.format(dealer_pct)+"%)", 0);
			pp_r.insert(Integer.toString(pushes),0);
			br_r.insert(df.format(bankroll),0);
			pct_r.insert(df.format(pct_per_hand)+"%", 0);
		    
		    f.setLayout(null);  
		    f.setVisible(true);

		}
		
		
		/*
		 *  Get rid of the frame
		 */
		
		public void delete_run () {
			run.setVisible(false);
		}
		  
	}  // end class
