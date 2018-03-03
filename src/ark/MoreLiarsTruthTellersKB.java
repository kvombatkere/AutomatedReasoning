package ark;

import pl.core.Biconditional;
import pl.core.Conjunction;
import pl.core.Disjunction;
import pl.core.KB;
import pl.core.Negation;
import pl.core.Symbol;

public class MoreLiarsTruthTellersKB extends KB{

		public MoreLiarsTruthTellersKB() {
		super();
		Symbol A = intern("A");
		Symbol B = intern("B");
		Symbol C = intern("C");
		Symbol D = intern("D");
		Symbol E = intern("E");
		Symbol F = intern("F");
		Symbol G = intern("G");
		Symbol H = intern("H");
		Symbol I = intern("I");
		Symbol J = intern("J");
		Symbol K = intern("K");
		Symbol L = intern("L");
		

		//Amy says, “Hal and Ida are truth-tellers.”
		add(new Biconditional(A, new Conjunction(H, I)));
		
		//Bob says, “Amy and Lee are truth-tellers.”
		add(new Biconditional(B, new Conjunction(A, L)));
		
//		Cal says, “Bob and Gil are truth-tellers.”
		add(new Biconditional(C, new Conjunction(B, G)));
		
//		Dee says, “Eli and Lee are truth-tellers.”		
		add(new Biconditional(D, new Conjunction(E, L)));

//		Eli says, “Cal and Hal are truth-tellers.”
		add(new Biconditional(E, new Conjunction(C, H)));

//		Fay says, “Dee and Ida are truth-tellers.”
		add(new Biconditional(F, new Conjunction(D, I)));
		
//		Gil says, “Eli and Jay are liars.”
		add(new Biconditional(G, new Conjunction(new Negation(E), new Negation(J))));

//		Hal says, “Fay and Kay are liars.”
		add(new Biconditional(H, new Conjunction(new Negation(F), new Negation(K))));

//		Ida says, “Gil and Kay are liars.”
		add(new Biconditional(I, new Conjunction(new Negation(G), new Negation(K))));

//		Jay says, “Amy and Cal are liars.”
		add(new Biconditional(J, new Conjunction(new Negation(A), new Negation(C))));

//		Kay says, “Dee and Fay are liars.”
		add(new Biconditional(K, new Conjunction(new Negation(D), new Negation(F))));

//		Lee says, “Bob and Jay are liars.”
		add(new Biconditional(L, new Conjunction(new Negation(B), new Negation(J))));
		
		
		}
		
		
}
