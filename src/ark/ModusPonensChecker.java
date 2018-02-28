//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//ModusPonensChecker

package ark;

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
public class ModusPonensChecker implements TTModelChecking{
	
	public static void main(String[] args){
		ModusPonensKB kb = new ModusPonensKB();

		Symbol q = kb.intern("Q");
		Symbol p = kb.intern("P");
		
		//Check if Modus Ponens entails q (should be true)
		System.out.println(TTModelChecking.ttEntails(kb, q));
		
		//Check if Modus Ponens entails not q (should be false)
		System.out.println(TTModelChecking.ttEntails(kb, new Negation(q)));
		
		//Check if Modus Ponens entails (p and (not q)) -> should be false
		System.out.println(TTModelChecking.ttEntails(kb, new Conjunction(p,new Negation(q))));
		
		//Check if Modus Ponens entails (p and q) -> should be true
		System.out.println(TTModelChecking.ttEntails(kb, new Conjunction(p,q)));
	}
	

}
