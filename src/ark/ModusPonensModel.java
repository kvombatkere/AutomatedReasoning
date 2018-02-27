//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//ModusPonensModel

package ark;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.ModusPonensKB;


public class ModusPonensModel implements Model{
	
	private HashMap<Symbol, Boolean> assignments = new HashMap<>();
	private ModusPonensKB kb = new ModusPonensKB();
	
	public ModusPonensModel() {
		assignments.put(new Symbol("P"), null);
		assignments.put(new Symbol("Q"), null);
	}

	@Override
	public void set(Symbol sym, boolean value) {
		assignments.replace(sym, value);
	}

	@Override
	public Boolean get(Symbol sym) {
		return assignments.get(sym);
	}



	@Override
	public Boolean satisfies(Sentence sentence) {

		if(sentence.isSatisfiedBy(this)) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public void dump() {
		for(Symbol s: assignments.keySet()) {
			System.out.println(s.toString() + " = " + assignments.get(s));
		}		
	}

	@Override
	public Model assign(Symbol s, Boolean b) {
		this.set(s, b);
		return this;
	}
	
	//Method to check entailment
	public Boolean ttEntails(KB kb, Sentence alpha) throws CloneNotSupportedException {
		List<Symbol> symbols = new ArrayList<Symbol>(kb.symbols());
		symbols.addAll(alpha.getSymbols());
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

	@Override
	public Boolean satisfies(KB kb) {
		// TODO Auto-generated method stub
		return null;
	}

}
