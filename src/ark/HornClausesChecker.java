//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//HornClausesChecker

package ark;

import pl.core.*;

public class HornClausesChecker implements TTModelChecking{

	public static void main(String[] args) {
		HornClausesKB HCkb = new HornClausesKB();
		
		//Symbols for the different elements in KB
		Symbol mythical = HCkb.intern("Mythical");
		Symbol magical = HCkb.intern("Magical");
		Symbol horned = HCkb.intern("Horned");
		
		System.out.println("Basic Model Checking and Propositional Inference for Horn Clauses Problem\n");
		System.out.println("Displaying Knowledge Base:");
		HCkb.dump();
		
		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");
		final long TTstart = System.currentTimeMillis();
		
		System.out.println("Mythical is entailed : " + TTModelChecking.ttEntails(HCkb, mythical));
		System.out.println("Magical is entailed : " + TTModelChecking.ttEntails(HCkb, magical));
		System.out.println("Horned is entailed : " + TTModelChecking.ttEntails(HCkb, horned));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - TTstart) + " ms");
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		final long DPLLstart = System.currentTimeMillis();
		
		//Check kb entailment of mythical, magical, and horned using DPLL and proof by contradiction
		System.out.println("Mythical can be proved : " + DPLL.proofByContradiction(HCkb, mythical));
		System.out.println("Magical can be proved : " + DPLL.proofByContradiction(HCkb, magical));
		System.out.println("Horned can be proved : " + DPLL.proofByContradiction(HCkb, horned));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - DPLLstart) + " ms");

	}

}
