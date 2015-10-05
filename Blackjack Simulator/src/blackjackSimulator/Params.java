package blackjackSimulator;

public class Params {
	
	int num_iterations;
	int num_decks;
	int cut_point;
	int high;
	float high_doubles;
	int low;
	float low_halves;
	boolean count_cards;
	boolean run_flag;
	
	public Params() {
		num_iterations = 0;
	}
	
	public void set_num_iterations ( int n ) {
		num_iterations = n;
	}
	
	public int get_num_iterations() {
		return ( num_iterations );
	}

	public void set_num_decks ( int n ) {
		num_decks = n;
	}
	
	public int get_num_decks() {
		return ( num_decks );
	}
	
	public void set_cut ( int n ) {
		cut_point = n;
	}
	
	public int get_cut() {
		return ( cut_point );
	}
	
	public void set_high ( int n ) {
		high = n;
	}
	
	public int get_high() {
		return ( high );
	}

	public void set_high_doubles ( float n ){
		high_doubles = n;
	}
	
	public float get_high_doubles() {
		return ( high_doubles );
	}
	
	public void set_low ( int n ){
		low = n;
	}
	
	public int get_low() {
		return ( low );
	}
	
	public void set_low_halves ( float n ){
		low_halves = n;
	}
	
	public float get_low_halves() {
		return ( low_halves );
	}
	
	public void set_count_cards ( boolean n ){
		count_cards = n;
	}
	
	public boolean get_count_cards ( ){
		return ( count_cards );
	}

	
	public void set_run ( boolean run ){
		run_flag = run;
	}
	
	public boolean get_run() {
		return ( run_flag );
	}

}
