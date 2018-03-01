//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//AmyBobCalPartBKB

package ark;

import pl.core.Conjunction;
import pl.core.KB;
import pl.core.Negation;
import pl.core.Symbol;

public class AmyBobCalPartBKB extends KB{

	public AmyBobCalPartBKB() {
		super();
		Symbol A = intern("Amy");
		Symbol B = intern("Bob");
		Symbol C = intern("Cal");
		
		add(new Conjunction(A, new Negation(C)));
		add(new Conjunction(B, new Conjunction(A, C)));
		add(new Conjunction(C, new Conjunction(B, new Conjunction(A, C))));
		
	}
	
	public static void main(String[] args) {
		new AmyBobCalPartAKB().dump();
	}

	
}
