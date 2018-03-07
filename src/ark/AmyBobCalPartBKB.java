//CSC 442: AI Project 02 - Automated Reasoning
//March 2018
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//AmyBobCalPartBKB

package ark;

import pl.core.Biconditional;
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
		
		//Amy says, "Cal is not honest."
		add(new Biconditional(A, new Negation(C)));
		//Bob says, "Amy and Cal never lie."
		add(new Biconditional(B, new Conjunction(A, C)));
		//Cal says, "Bob is correct."
		add(new Biconditional(C, new Conjunction(B, new Conjunction(A, C))));
		
	}
	
	public static void main(String[] args) {
		new AmyBobCalPartAKB().dump();
	}

	
}
