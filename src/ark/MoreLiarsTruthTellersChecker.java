package ark;

import pl.core.Conjunction;
import pl.core.Negation;
import pl.core.Sentence;
import pl.core.Symbol;

public class MoreLiarsTruthTellersChecker implements TTModelChecking, DPLL {
	
	public static void main(String[] args) {
		MoreLiarsTruthTellersKB kb = new MoreLiarsTruthTellersKB();
		
		Symbol A = kb.intern("A");
		Symbol B = kb.intern("B");
		Symbol C = kb.intern("C");
		Symbol D = kb.intern("D");
		Symbol E = kb.intern("E");
		Symbol F = kb.intern("F");
		Symbol G = kb.intern("G");
		Symbol H = kb.intern("H");
		Symbol I = kb.intern("I");
		Symbol J = kb.intern("J");
		Symbol K = kb.intern("K");
		Symbol L = kb.intern("L");
		
		System.out.println("Basic Model Checking and Propositional Inference for More Liars and Truth Tellers Problem\n");
		System.out.println("Displaying Knowledge Base:");
		kb.dump();
		
		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");

		System.out.println("The following can be entailed");
		System.out.println("Amy is a truth teller : " + TTModelChecking.ttEntails(kb, A));
		System.out.println("Bob is a truth teller : " + TTModelChecking.ttEntails(kb, B));
		System.out.println("Cal is a truth teller : " + TTModelChecking.ttEntails(kb, C));
		System.out.println("Dee is a truth teller : " + TTModelChecking.ttEntails(kb, D));
		System.out.println("Eli is a truth teller : " + TTModelChecking.ttEntails(kb, E));
		System.out.println("Fay is a truth teller : " + TTModelChecking.ttEntails(kb, F));
		System.out.println("Gil is a truth teller : " + TTModelChecking.ttEntails(kb, G));
		System.out.println("Hal is a truth teller : " + TTModelChecking.ttEntails(kb, H));
		System.out.println("Ida is a truth teller : " + TTModelChecking.ttEntails(kb, I));
		System.out.println("Jay is a truth teller : " + TTModelChecking.ttEntails(kb, J));
		System.out.println("Kay is a truth teller : " + TTModelChecking.ttEntails(kb, K));
		System.out.println("Lee is a truth teller : " + TTModelChecking.ttEntails(kb, L));
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		
		//Check kb entailment of Amy, Bob, and Cal's truthfulness using DPLL and proof by contradiction
		System.out.println("Amy can be proved truthful : " + DPLL.proofByContradiction(kb, A));
		System.out.println("Bob can be proved truthful : " + DPLL.proofByContradiction(kb, B));
		System.out.println("Cal can be proved truthful : " + DPLL.proofByContradiction(kb, C));
		System.out.println("Dee can be proved truthful : " + DPLL.proofByContradiction(kb, D));
		System.out.println("Eli can be proved truthful : " + DPLL.proofByContradiction(kb, E));
		System.out.println("Fay can be proved truthful : " + DPLL.proofByContradiction(kb, F));
		System.out.println("Gil can be proved truthful : " + DPLL.proofByContradiction(kb, G));
		System.out.println("Hal can be proved truthful : " + DPLL.proofByContradiction(kb, H));
		System.out.println("Ida can be proved truthful : " + DPLL.proofByContradiction(kb, I));
		System.out.println("Jay can be proved truthful : " + DPLL.proofByContradiction(kb, J));
		System.out.println("Kay can be proved truthful : " + DPLL.proofByContradiction(kb, K));
		System.out.println("Lee can be proved truthful : " + DPLL.proofByContradiction(kb, L));

				
	}

}
