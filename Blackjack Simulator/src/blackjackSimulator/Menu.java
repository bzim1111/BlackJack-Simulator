package blackjackSimulator;

import java.awt.*;
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
		static JButton quit = new JButton("Quit");	
		static JTextArea label=new JTextArea(150,30);
		static JTextArea area=new JTextArea(75,30);
		static JRadioButton r1 = new JRadioButton("On");
		static JRadioButton r2 = new JRadioButton("Off");
		static JTextArea cc=new JTextArea(150,30);
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
		
		
		public void setup_menu() {
			  
		    f.setTitle("My Empty Frame");
			f.setSize(600,600); 
			f.setLayout(null);
			f.setLocationRelativeTo(null); 
			f.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			/* Run / Quit */
			
			run.setBounds(150,500,75,40);
			f.add ( run );
			run.setVisible(true);
			
			quit.setBounds(300,500,75,40);
			f.add ( quit );
			quit.setVisible(true);
			
			/* Number of Iterations */
			
			label.insert("Number of Iterations", 0);
		    label.setBounds(100,50,150,30);    
		    label.setForeground(Color.black);
		    label.setVisible(true);
		    label.setEditable(false);
		    label.setOpaque(false);
		    label.setAlignmentX(LEFT_ALIGNMENT);
		    label.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(label);
		    
		    area.setBounds(300,50,75,30);  
		    area.setBackground(Color.white);  
		    area.setForeground(Color.black);
		    area.setAlignmentY(CENTER_ALIGNMENT);
		    area.setBorder(BorderFactory.createLineBorder(Color.black));
		    area.setVisible(true);    
		    f.add(area);  
		    
		    /* Card Counting on/off */
		    
		    r1.setBounds(300,115,75,30);
		    r2.setBounds(375,115,75,30);
		    ButtonGroup bg = new ButtonGroup();
		    bg.add(r1);
		    bg.add(r2);
		    f.add(r1);
		    f.add(r2);
	
			cc.insert("Card Counting", 0);
		    cc.setBounds(100,115,150,30);    
		    cc.setForeground(Color.black);
		    cc.setVisible(true);
		    cc.setEditable(false);
		    cc.setOpaque(false);
		    cc.setAlignmentX(LEFT_ALIGNMENT);
		    cc.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(cc);
		    
		    /* Results */
		    
			res.insert("Results", 0);
		    res.setBounds(250,250,150,30);    
		    res.setForeground(Color.black);
		    res.setVisible(true);
		    res.setEditable(false);
		    res.setOpaque(false);
		    res.setAlignmentX(LEFT_ALIGNMENT);
		    res.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(res);
		    
			pw.insert("Player Wins", 0);
		    pw.setBounds(100,300,150,30);    
		    pw.setForeground(Color.black);
		    pw.setVisible(true);
		    pw.setEditable(false);
		    pw.setOpaque(false);
		    pw.setAlignmentX(LEFT_ALIGNMENT);
		    pw.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pw);
		    
			dw.insert("Dealer Wins", 0);
		    dw.setBounds(100,325,150,30);    
		    dw.setForeground(Color.black);
		    dw.setVisible(true);
		    dw.setEditable(false);
		    dw.setOpaque(false);
		    dw.setAlignmentX(LEFT_ALIGNMENT);
		    dw.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(dw);
		    
			pp.insert("Pushes", 0);
		    pp.setBounds(100,350,150,30);    
		    pp.setForeground(Color.black);
		    pp.setVisible(true);
		    pp.setEditable(false);
		    pp.setOpaque(false);
		    pp.setAlignmentX(LEFT_ALIGNMENT);
		    pp.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pp);
		    
			br.insert("Ending Bankroll", 0);
			br.setBounds(100,375,150,30);    
			br.setForeground(Color.black);
			br.setVisible(true);
			br.setEditable(false);
			br.setOpaque(false);
			br.setAlignmentX(LEFT_ALIGNMENT);
			br.setAlignmentY(CENTER_ALIGNMENT);
			f.add(br);
			
			pct.insert("% per Hand", 0);
			pct.setBounds(100,400,150,30);    
			pct.setForeground(Color.black);
			pct.setVisible(true);
			pct.setEditable(false);
			pct.setOpaque(false);
			pct.setAlignmentX(LEFT_ALIGNMENT);
			pct.setAlignmentY(CENTER_ALIGNMENT);
			f.add(pct);

		    pw_r.setBounds(300,300,150,30);    
		    pw_r.setForeground(Color.black);
		    pw_r.setVisible(true);
		    pw_r.setEditable(false);
		    pw_r.setOpaque(false);
		    pw_r.setAlignmentX(LEFT_ALIGNMENT);
		    pw_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pw_r);
		    
		    dw_r.setBounds(300,325,150,30);    
		    dw_r.setForeground(Color.black);
		    dw_r.setVisible(true);
		    dw_r.setEditable(false);
		    dw_r.setOpaque(false);
		    dw_r.setAlignmentX(LEFT_ALIGNMENT);
		    dw_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(dw_r);

		    pp_r.setBounds(300,350,150,30);    
		    pp_r.setForeground(Color.black);
		    pp_r.setVisible(true);
		    pp_r.setEditable(false);
		    pp_r.setOpaque(false);
		    pp_r.setAlignmentX(LEFT_ALIGNMENT);
		    pp_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pp_r);
		    
		    br_r.setBounds(300,375,150,30);    
		    br_r.setForeground(Color.black);
		    br_r.setVisible(true);
		    br_r.setEditable(false);
		    br_r.setOpaque(false);
		    br_r.setAlignmentX(LEFT_ALIGNMENT);
		    br_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(br_r);
		    
		    pct_r.setBounds(300,400,150,30);    
		    pct_r.setForeground(Color.black);
		    pct_r.setVisible(true);
		    pct_r.setEditable(false);
		    pct_r.setOpaque(false);
		    pct_r.setAlignmentX(LEFT_ALIGNMENT);
		    pct_r.setAlignmentY(CENTER_ALIGNMENT);
		    f.add(pct_r);


			
		    /* Display */
		    
		    f.setSize(600,600); 
		    f.setLayout(null);  
		    f.setVisible(true);  
			
			
		  } // end setup
		
		
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
		  
	}  // end class
