//CSC 442: AI Project 02 - Automated Reasoning
//March 2018
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//AmyBobCalChecker

package ark;

import pl.core.Conjunction;
import pl.core.Negation;
import pl.core.Sentence;
import pl.core.Symbol;

public class AmyBobCalChecker implements TTModelChecking{

	public static void main(String[] args) {
		//Part A
		AmyBobCalPartAKB kbA = new AmyBobCalPartAKB();
		
		Symbol aA = kbA.intern("Amy");
		Symbol bA = kbA.intern("Bob");
		Symbol cA = kbA.intern("Cal");
		
		System.out.println("Basic Model Checking and Propositional Inference for Liars and Truth Tellers Problem Part A\n");
		System.out.println("Displaying Knowledge Base:");
		kbA.dump();
		
		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");
		final long TTstartA = System.currentTimeMillis();

		System.out.println("The following can be entailed");
		System.out.println("Amy is a truth teller : " + TTModelChecking.ttEntails(kbA, aA));
		System.out.println("Bob is a truth teller : " + TTModelChecking.ttEntails(kbA, bA));
		System.out.println("Cal is a truth teller: " + TTModelChecking.ttEntails(kbA, cA));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - TTstartA) + " ms");
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		final long DPLLstartA = System.currentTimeMillis();
				
		//Check kb entailment of Amy, Bob, and Cal's truthfulness using DPLL and proof by contradiction
		System.out.println("Amy can be proved truthful : " + DPLL.proofByContradiction(kbA, aA));
		System.out.println("Bob can be proved truthful : " + DPLL.proofByContradiction(kbA, bA));
		System.out.println("Cal can be proved truthful : " + DPLL.proofByContradiction(kbA, cA));

		System.out.println("Computed in " + (System.currentTimeMillis() - DPLLstartA) + " ms");

			
		//Part B
		AmyBobCalPartBKB kbB = new AmyBobCalPartBKB();
		
		Symbol aB = kbB.intern("Amy");
		Symbol bB = kbB.intern("Bob");
		Symbol cB = kbB.intern("Cal");
		
		System.out.println("\nBasic Model Checking and Propositional Inference for Liars and Truth Tellers Problem Part B\n");
		System.out.println("Displaying Knowledge Base:");
		kbB.dump();
		
		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");
		final long TTstartB = System.currentTimeMillis();

		System.out.println("The following can be entailed");
		System.out.println("Amy is a truth teller : " + TTModelChecking.ttEntails(kbB, aB));
		System.out.println("Bob is a truth teller : " + TTModelChecking.ttEntails(kbB, bB));
		System.out.println("Cal is a truth teller : " + TTModelChecking.ttEntails(kbB, cB));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - TTstartB) + " ms");
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		final long DPLLstartB = System.currentTimeMillis();
		
		//Check kb entailment of Amy, Bob, and Cal's truthfulness using DPLL and proof by contradiction
		System.out.println("Amy can be proved truthful : " + DPLL.proofByContradiction(kbB, aB));
		System.out.println("Bob can be proved truthful : " + DPLL.proofByContradiction(kbB, bB));
		System.out.println("Cal can be proved truthful : " + DPLL.proofByContradiction(kbB, cB));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - DPLLstartB) + " ms");
		
	}
}
