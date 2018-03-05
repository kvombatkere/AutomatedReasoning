//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//WumpusWorldChecker

package ark;

import pl.core.Conjunction;
import pl.core.Negation;
import pl.core.Symbol;
import pl.examples.WumpusWorldKB;

//Class to check Wumpus World using TTEntails
public class WumpusWorldChecker implements TTModelChecking{

	public static void main(String[] args) throws CloneNotSupportedException {
		WumpusWorldKB kb = new WumpusWorldKB();
		
		Symbol p12 = kb.intern("P1,2");
	
		System.out.println("Basic Model Checking and Propositional Inference for Wumpus World Problem\n");
		System.out.println("Displaying Knowledge Base:");
		kb.dump();
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		final long DPLLstart = System.currentTimeMillis();
		
		//Check kb entailment of p12 using DPLL and proof by contradiction
		System.out.println("Pit in (1,2) can be proved : " + DPLL.proofByContradiction(kb, p12));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - DPLLstart) + " ms");

		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");
		final long TTstart = System.currentTimeMillis();

		System.out.println("Pit in (1,2) Entailed : " + TTModelChecking.ttEntails(kb, p12));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - TTstart) + " ms");

	}
	
} //end class WumpusWorldModel
