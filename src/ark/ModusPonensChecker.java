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
		
		
		//Check if kb entails q (should be true)
		System.out.println(TTModelChecking.ttEntails(kb, q));
		
		//Check if kb entails not q (should be false)
		System.out.println(TTModelChecking.ttEntails(kb, new Negation(q)));
		
		//Check if kb entails (p and (not q)) -> should be false
		System.out.println(TTModelChecking.ttEntails(kb, new Conjunction(p,new Negation(q))));
		
		//Check if kb entails (p and q) -> should be true
		System.out.println(TTModelChecking.ttEntails(kb, new Conjunction(p,q)));
		
		//Check kb entailment of q using dpll (should be true)
		System.out.println(DPLL.dpllSatisfiable(new Conjunction(sentence, q)));
	}
	

}
