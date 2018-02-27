//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//ModusPonensModel

package ark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.WumpusWorldKB;

//This and ModusPonensModel can probably be generalized to a common model class

public class WumpusWorldModel implements Model, Cloneable {

	private HashMap<Symbol, Boolean> assignments = new HashMap<>();
	private WumpusWorldKB kb = new WumpusWorldKB();
	
	public WumpusWorldModel() {
		//initialize assignment map to none
		assignments.put(new Symbol("P1"), null);
		assignments.put(new Symbol("P2"), null);
		assignments.put(new Symbol("P3"), null);
		assignments.put(new Symbol("B1"), null);
		assignments.put(new Symbol("B2"), null);

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
	public Boolean satisfies(KB kb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Boolean satisfies(Sentence sentence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dump() {
		for(Symbol s: assignments.keySet()) {
			System.out.println(s.toString() + " = " + assignments.get(s));
		}
	}
	
	//assign just calls set, but returns the model for use in TT-entails algorithm
	@Override
	public Model assign(Symbol s, Boolean b) {
		this.set(s,  b);
		return this;
	}
	
	
	//Method to check entailment
	public boolean ttEntails(KB kb, Sentence alpha) throws CloneNotSupportedException {
		List<Symbol> symbols = new ArrayList<Symbol>(kb.symbols());
		symbols.addAll(alpha.getSymbols());
		return(ttCheckAll(kb, alpha, symbols, new WumpusWorldModel()));
	}//end ttEntails
	
	//Method to enumerate Truth Table for model
	public boolean ttCheckAll(KB kb, Sentence alpha, List<Symbol> symbols, Model model ) throws CloneNotSupportedException {
		
		if (symbols.isEmpty()) {
			if (model.satisfies(kb)) {
			return model.satisfies(alpha);
			} 
			else {
			return true;
			}
			 
		} 
		else {
			Symbol p = symbols.remove(0);
			return (ttCheckAll(kb, alpha, symbols,
			((Model) ((WumpusWorldModel) model).clone()).assign(p, Boolean.TRUE)) &&
			ttCheckAll(kb, alpha, symbols,
			((Model) ((WumpusWorldModel) model).clone()).assign(p, Boolean.FALSE)));
		}
	} //end ttCheckAll

}
