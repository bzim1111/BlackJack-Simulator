package blackjackSimulator;

public class Params {
	
	int num_iterations;
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

		
	public void set_run ( boolean run ){
		run_flag = run;
	}
	
	public boolean get_run() {
		return ( run_flag );
	}

}
