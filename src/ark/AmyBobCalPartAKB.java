//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//AmyBobCalPartAKB

package ark;

import pl.core.Biconditional;
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
		
		//Amy says, "Cal and I are truthful."
		add(new Biconditional(A, new Conjunction(A, C)));
		//Bob says, "Cal is a liar."
		add(new Biconditional(B, new Negation(C)));
		//Cal says, "Bob speaks the truth or Amy lies."
		add(new Biconditional(C, new Disjunction(B, new Negation(A))));

	}
	
	public static void main(String[] args) {
		new AmyBobCalPartAKB().dump();
	}

	
}
