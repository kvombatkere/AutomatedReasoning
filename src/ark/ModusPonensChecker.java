//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//ModusPonensChecker

package ark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import pl.core.Conjunction;
import pl.core.Implication;
import pl.core.KB;
import pl.core.Model;
import pl.core.Negation;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.ModusPonensKB;


//This class was created from scratch
public class ModusPonensChecker implements TTModelChecking, DPLL{
	

	public static void main(String[] args){
		ModusPonensKB kb = new ModusPonensKB();
		
		Symbol q = kb.intern("Q");
		Symbol p = kb.intern("P");
		
		Sentence sentence = new Conjunction(new Implication(p,q), p);
		
		System.out.println("Basic Model Checking and Propositional Inference for Modus Ponens\n");
		System.out.println("Displaying Knowledge Base:");
		kb.dump();
		
		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");
		final long TTstart = System.currentTimeMillis();
		
		//Check if kb entails q (should be true)
		System.out.println("q is entailed : " + TTModelChecking.ttEntails(kb, q));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - TTstart) + " ms");
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		final long DPLLstart = System.currentTimeMillis();

		//Check kb entailment of q using DPLL and proof by contradiction
		System.out.println("q can be proved : " + DPLL.proofByContradiction(kb, q));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - DPLLstart) + " ms");

	}
	

}
