//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//ModusPonensModel

package ark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.WumpusWorldKB;

//This and ModusPonensModel can probably be generalized to a common model class

public class WumpusWorldChecker implements TTModelChecking{

	//main method for sanity checking
	public static void main(String[] args) throws CloneNotSupportedException {
		WumpusWorldKB kb = new WumpusWorldKB();
		
		Symbol p11 = kb.intern("P1,1");
		Symbol p12 = kb.intern("P1,2");
		Symbol p21 = kb.intern("P2,1");
		Symbol p22 = kb.intern("P2,2");
		Symbol p31 = kb.intern("P3,1");
		Symbol b11 = kb.intern("B1,1");
		Symbol b21 = kb.intern("B2,1");
		
		System.out.println(TTModelChecking.ttEntails(kb, b11));
		System.out.println(TTModelChecking.ttEntails(kb, b21));

	}
	
} //end class WumpusWorldModel
