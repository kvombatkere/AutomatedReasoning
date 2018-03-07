//CSC 442: AI Project 02 - Automated Reasoning
//March 2018
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//DoorsOfEnlightenmentKB
//Knowledge base for Smullyan's problem

package ark;

import pl.core.Biconditional;
import pl.core.Conjunction;
import pl.core.Disjunction;
import pl.core.Implication;
import pl.core.KB;
import pl.core.Negation;
import pl.core.Symbol;

public class DoorsOfEnlightenmentKB extends KB{

	public DoorsOfEnlightenmentKB() {
		super();
		Symbol A = intern("A");
		Symbol B = intern("B");
		Symbol C = intern("C");
		Symbol D = intern("D");
		Symbol E = intern("E");
		Symbol F = intern("F");
		Symbol G = intern("G");
		Symbol H = intern("H");
		
		Symbol X = intern("X");
		Symbol Y = intern("Y");
		Symbol Z = intern("Z");
		Symbol W = intern("W"); //W is never used but included for completeness
		
		//A: X is a good door.
		add(new Biconditional(A, X));
		//B: At least one of the doors Y or Z is good.
		add(new Biconditional(B, new Disjunction(Y, Z)));
		//C: A and B are both knights.
		add(new Biconditional(C, new Conjunction(A, B)));
		//D: X and Y are both good doors.
		add(new Biconditional(D, new Conjunction(X, Y)));
		//E: X and Z are both good doors.
		add(new Biconditional(E, new Conjunction(X, Z)));
		//F: Either D or E is a knight.
		add(new Biconditional(F, new Disjunction(new Conjunction(D, new Negation(E)), new Conjunction(new Negation(D), E))));
		//G: If C is a knight, so is F.
		add(new Biconditional(G, new Implication(C, F)));
		//H: If G and I (meaning H) are knights, so is A.
		add(new Biconditional(H, new Implication(new Conjunction(G, H), A)));
	}
}
