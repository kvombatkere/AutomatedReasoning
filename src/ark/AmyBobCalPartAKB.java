//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//AmyBobCalPartAKB

package ark;

import pl.core.Conjunction;
import pl.core.Disjunction;
import pl.core.KB;
import pl.core.Negation;
import pl.core.Symbol;

public class AmyBobCalPartAKB extends KB{

	public AmyBobCalPartAKB() {
		super();
		Symbol A = intern("Amy");
		Symbol B = intern("Bob");
		Symbol C = intern("Cal");
		
		add(new Conjunction(A, new Conjunction(A, C)));
		add(new Conjunction(B, new Negation(C)));
		add(new Conjunction(C, new Disjunction(B, new Negation(A))));
	}
	
	public static void main(String[] args) {
		new AmyBobCalPartAKB().dump();
	}

	
}
