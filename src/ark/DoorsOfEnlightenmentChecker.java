//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//DoorsOfEnlightenmentChecker

package ark;

import pl.core.Symbol;

public class DoorsOfEnlightenmentChecker {

	public static void main(String[] args) {
		
		System.out.println("Basic Model Checking and Propositional Inference for the Doors of Enlightenment Problem\n");
	
		//Part A
		System.out.println("Smullyan's Problem:");
		DoorsOfEnlightenmentKB kb = new DoorsOfEnlightenmentKB();
		
		/*Symbol A = kb.intern("A");
		Symbol B = kb.intern("B");
		Symbol C = kb.intern("C");
		Symbol D = kb.intern("D");
		Symbol E = kb.intern("E");
		Symbol F = kb.intern("F");
		Symbol G = kb.intern("G");
		Symbol H = kb.intern("H");*/
		
		Symbol X = kb.intern("X");
		Symbol Y = kb.intern("Y");
		Symbol Z = kb.intern("Z");
		Symbol W = kb.intern("W");
		
		System.out.println("Displaying Knowledge Base:");
		kb.dump();
				
		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");
		final long TTstart = System.currentTimeMillis();

		System.out.println("X leads to the Inner Sanctum : " + TTModelChecking.ttEntails(kb, X));
		System.out.println("Y leads to the Inner Sanctum : " + TTModelChecking.ttEntails(kb, Y));
		System.out.println("Z leads to the Inner Sanctum : " + TTModelChecking.ttEntails(kb, Z));
		System.out.println("W leads to the Inner Sanctum : " + TTModelChecking.ttEntails(kb, W));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - TTstart) + " ms");
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		final long DPLLstart = System.currentTimeMillis();
		
		//Check kb entailment of door status using DPLL and proof by contradiction
		System.out.println("X leads to the Inner Sanctum : " + DPLL.proofByContradiction(kb, X));
		System.out.println("Y leads to the Inner Sanctum : " + DPLL.proofByContradiction(kb, Y));
		System.out.println("Z leads to the Inner Sanctum : " + DPLL.proofByContradiction(kb, Z));
		System.out.println("W leads to the Inner Sanctum : " + DPLL.proofByContradiction(kb, W));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - DPLLstart) + " ms");
		
		/*System.out.println("Which priests can be proved to be knights?");
		System.out.println("A: " + TTModelChecking.ttEntails(kb, A));
		System.out.println("B: " + TTModelChecking.ttEntails(kb, B));
		System.out.println("C: " + TTModelChecking.ttEntails(kb, C));
		System.out.println("D: " + TTModelChecking.ttEntails(kb, D));
		System.out.println("E: " + TTModelChecking.ttEntails(kb, E));
		System.out.println("F: " + TTModelChecking.ttEntails(kb, F));
		System.out.println("G: " + TTModelChecking.ttEntails(kb, G));
		System.out.println("H: " + TTModelChecking.ttEntails(kb, H));*/
		
		
		//Part B
		System.out.println("\nLiu's Problem:");

		DOELiuKB Liukb = new DOELiuKB();
		
		/*Symbol LiuA = Liukb.intern("A");
		Symbol LiuB = Liukb.intern("B");
		Symbol LiuC = Liukb.intern("C");
		Symbol LiuD = Liukb.intern("D");
		Symbol LiuE = Liukb.intern("E");
		Symbol LiuF = Liukb.intern("F");
		Symbol LiuG = Liukb.intern("G");
		Symbol LiuH = Liukb.intern("H");*/
		
		Symbol LiuX = Liukb.intern("X");
		Symbol LiuY = Liukb.intern("Y");
		Symbol LiuZ = Liukb.intern("Z");
		Symbol LiuW = Liukb.intern("W");
		
		System.out.println("Displaying Knowledge Base:");
		Liukb.dump();
		
		System.out.println("\nAIMA Figure 7.10 Truth Table Enumeration method");
		final long TTstartLiu = System.currentTimeMillis();

		System.out.println("X leads to the Inner Sanctum : " + TTModelChecking.ttEntails(Liukb, LiuX));
		System.out.println("Y leads to the Inner Sanctum : " + TTModelChecking.ttEntails(Liukb, LiuY));
		System.out.println("Z leads to the Inner Sanctum : " + TTModelChecking.ttEntails(Liukb, LiuZ));
		System.out.println("W leads to the Inner Sanctum : " + TTModelChecking.ttEntails(Liukb, LiuW));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - TTstartLiu) + " ms");
		
		System.out.println("\nAIMA Figure 7.17 DPLL with Proof by Contradiction");
		final long DPLLstartLiu = System.currentTimeMillis();
		
		//Check kb entailment of door status using DPLL and proof by contradiction
		System.out.println("X leads to the Inner Sanctum : " + DPLL.proofByContradiction(Liukb, LiuX));
		System.out.println("Y leads to the Inner Sanctum : " + DPLL.proofByContradiction(Liukb, LiuY));
		System.out.println("Z leads to the Inner Sanctum : " + DPLL.proofByContradiction(Liukb, LiuZ));
		System.out.println("W leads to the Inner Sanctum : " + DPLL.proofByContradiction(Liukb, LiuW));
		
		System.out.println("Computed in " + (System.currentTimeMillis() - DPLLstartLiu) + " ms");
		
		/*System.out.println("Which priests can be proved to be knights?");
		System.out.println("A: " + TTModelChecking.ttEntails(Liukb, LiuA));
		System.out.println("B: " + TTModelChecking.ttEntails(Liukb, LiuB));
		System.out.println("C: " + TTModelChecking.ttEntails(Liukb, LiuC));
		System.out.println("D: " + TTModelChecking.ttEntails(Liukb, LiuD));
		System.out.println("E: " + TTModelChecking.ttEntails(Liukb, LiuE));
		System.out.println("F: " + TTModelChecking.ttEntails(Liukb, LiuF));
		System.out.println("G: " + TTModelChecking.ttEntails(Liukb, LiuG));
		System.out.println("H: " + TTModelChecking.ttEntails(Liukb, LiuH));*/
		
	}
}
