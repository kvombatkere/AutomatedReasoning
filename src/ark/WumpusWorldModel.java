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

public class WumpusWorldModel implements Model, Cloneable {

	private HashMap<Symbol, Boolean> assignments = new HashMap<>();
	public WumpusWorldModel() {
		//initialize assignment map to none
		assignments.put(new Symbol("P1,1"), null);
		assignments.put(new Symbol("P1,2"), null);
		assignments.put(new Symbol("P2,1"), null);
		assignments.put(new Symbol("P2,2"), null);
		assignments.put(new Symbol("P3,1"), null);
		assignments.put(new Symbol("B1,1"), null);
		assignments.put(new Symbol("B2,1"), null);

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
		Collection<Sentence> sentences = kb.sentences();
		for(Sentence s: sentences) {
			if(!(s.isSatisfiedBy(this))) {
				return false;
			}
		}
		return true;
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

	//main method for sanity checking
	public static void main(String[] args) throws CloneNotSupportedException {
		WumpusWorldKB kb = new WumpusWorldKB();
		WumpusWorldModel wwModel = new WumpusWorldModel();
		
		Symbol p11 = kb.intern("P1,1");
		Symbol p12 = kb.intern("P1,2");
		Symbol p21 = kb.intern("P2,1");
		Symbol p22 = kb.intern("P2,2");
		Symbol p31 = kb.intern("P3,1");
		Symbol b11 = kb.intern("B1,1");
		Symbol b21 = kb.intern("B2,1");
		
		System.out.println(wwModel.ttEntails(kb, b11));
		System.out.println(wwModel.ttEntails(kb, b21));

	}
	
} //end class WumpusWorldModel
