//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//WumpusWorldChecker

package ark;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.WumpusWorldKB;

//This class was created from scratch
public class WumpusWorldChecker implements TTModelChecking{

	//main method for testing
	public static void main(String[] args) throws CloneNotSupportedException {
		WumpusWorldKB kb = new WumpusWorldKB();
		
		Symbol p11 = kb.intern("P1,1");
		Symbol p12 = kb.intern("P1,2");
		Symbol p21 = kb.intern("P2,1");
		Symbol p22 = kb.intern("P2,2");
		Symbol p31 = kb.intern("P3,1");
		Symbol b11 = kb.intern("B1,1");
		Symbol b21 = kb.intern("B2,1");

		System.out.println(TTModelChecking.ttEntails(kb, p31));

	}
	
} //end class WumpusWorldModel
