//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//WumpusWorldChecker

package ark;

import pl.core.Symbol;
import pl.examples.WumpusWorldKB;

//Class to check Wumpus World using TTEntails
public class WumpusWorldChecker implements TTModelChecking{

	public static void main(String[] args) throws CloneNotSupportedException {
		WumpusWorldKB kb = new WumpusWorldKB();
		
		Symbol p12 = kb.intern("P1,2");
		Symbol p31 = kb.intern("P3,1");
	
		System.out.println("Basic Model Checking/Propositional Entailment for Wumpus World Problem\n");
		System.out.println("Displaying Knowledge Base:");
		kb.dump();


		System.out.println("\nPit in (1,2) Entailed: " + TTModelChecking.ttEntails(kb, p12));
		System.out.println("Pit in (3,1) Entailed: " + TTModelChecking.ttEntails(kb, p31));


	}
	
} //end class WumpusWorldModel
