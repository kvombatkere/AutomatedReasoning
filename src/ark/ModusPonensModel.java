//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//ModusPonensModel

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

//This and ModusPonensModel can probably be generalized to a common model class

public class ModusPonensModel extends Model{
	
	@Override
	public Model assign(Symbol s, Boolean b) {
		this.set(s, b);
		return this;
	}
	
	//Method to check entailment
	public Boolean ttEntails(KB kb, Sentence alpha) throws CloneNotSupportedException {
		List<Symbol> symbols = new ArrayList<Symbol>(kb.symbols());
		
		//create temporary new knowledge base for adding symbols
		KB kb2 = new KB();
		Symbol q = kb2.intern("Q");
		kb2.add(q);
		symbols.addAll(kb2.symbols());
		return(ttCheckAll(kb, alpha, symbols, new ModusPonensModel()));
	}
	
	
	//Method to enumerate Truth Table for model
	public Boolean ttCheckAll(KB kb, Sentence alpha, List<Symbol> symbols, Model model ) throws CloneNotSupportedException{
		
		if (symbols.isEmpty()) {
			if (model.satisfies(kb)) {
				return model.satisfies(alpha);
			} 
			else {
				return Boolean.TRUE;
			}
			 
			 } 
		else {
			 
			Symbol p = symbols.remove(0);

			try {
				return (ttCheckAll(kb, alpha, symbols,
				((Model) ((ModusPonensModel)model).clone()).assign(p, Boolean.TRUE)) &&
				ttCheckAll(kb, alpha, symbols,
				((Model) ((ModusPonensModel) model).clone()).assign(p, Boolean.FALSE)));
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;

			}
		}
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		ModusPonensKB kb = new ModusPonensKB();
		ModusPonensModel mpModel = new ModusPonensModel();

		Symbol q = kb.intern("Q");
		Symbol p = kb.intern("P");
		
		//Check if Modus Ponens entails q (should be true)
		System.out.println(mpModel.ttEntails(kb, q));
		
		//Check if Modus Ponens entails not q (should be false)
		System.out.println(mpModel.ttEntails(kb, new Negation(q)));
		
		//Check if Modus Ponens entails (p and (not q)) -> should be false
		System.out.println(mpModel.ttEntails(kb, new Conjunction(p,new Negation(q))));
		
		//Check if Modus Ponens entails (p and q) -> should be true
		System.out.println(mpModel.ttEntails(kb, new Conjunction(p,q)));
	}
	

}
