//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//DOELiuKB
//Knowledge base for Liu's Doors of Enlightenment problem

package ark;

import pl.core.Biconditional;
import pl.core.Conjunction;
import pl.core.Disjunction;
import pl.core.Implication;
import pl.core.KB;
import pl.core.Negation;
import pl.core.Symbol;

public class DOELiuKB extends KB{
	
	public DOELiuKB() {
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
		
		//from problem statement:
		add(new Disjunction(X, new Disjunction(Y, new Disjunction(Z, W))));
		
		//A: X is a good door.
		add(new Biconditional(A, X));
		
		//C: A and ... are both knights.
		add(new Biconditional(C, new Conjunction(A, new Disjunction(B, new Disjunction(C, new Disjunction(D, new Disjunction(E, new Disjunction(F, new Disjunction(G, H)))))))));
		
		//G: If C is a knight, ...
		add(new Biconditional(G, new Implication(C, C)));
		//Don't know what C implies, so use trivial C implies C
		
		//H: If G and I (meaning H) are knights, so is A.
		add(new Biconditional(H, new Implication(new Conjunction(G, H), A)));
	}

}
