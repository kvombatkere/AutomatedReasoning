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
		
		System.out.println("Basic Model Checking/Propositional Entailment for Horn Clauses Problem\n");
		System.out.println("Displaying Knowledge Base:");
		HCkb.dump();
		
		System.out.println("\nMythical: " + TTModelChecking.ttEntails(HCkb, mythical));
		System.out.println("Magical: " + TTModelChecking.ttEntails(HCkb, magical));
		System.out.println("Horned: " + TTModelChecking.ttEntails(HCkb, horned));		
	}

}
