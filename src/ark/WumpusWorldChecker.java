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

<<<<<<< HEAD
		System.out.println(TTModelChecking.ttEntails(kb, p12));
		System.out.println(TTModelChecking.ttEntails(kb, b21));

=======
		System.out.println("\nPit in (1,2): " + TTModelChecking.ttEntails(kb, p12));
		System.out.println("Pit in (3,1): " + TTModelChecking.ttEntails(kb, p31));
		System.out.println(TTModelChecking.ttEntails(kb, p31));
>>>>>>> 9f24e0197636f036c8c9f08d7a9587db6cb7686c
	}
	
} //end class WumpusWorldModel
