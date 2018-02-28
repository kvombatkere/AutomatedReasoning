package pl.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * A Model is an assignment of boolean values (true or false) to
 * PropositionalSymbols.
 */
public class Model{
	protected HashMap<Symbol, Boolean> assignments = new HashMap<>();
	
	public Model() {}
	
	public Model(HashMap<Symbol, Boolean> assignments) {
		this.assignments = assignments;
	}
	
	/**
	 * Set the value assigned to the given PropositionSymbol in this
	 * Model to the given boolean VALUE.
	 */
	public void set(Symbol sym, boolean value) {
		assignments.replace(sym, value);
	}

	/**
	 * Returns the boolean value associated with the given PropositionalSymbol
	 * in this Model.
	 */
	public Boolean get(Symbol sym) {
		return assignments.get(sym);
	}
	
	/**
	 * Return true if this Model satisfies (makes true) the given KB.
	 */
	public Boolean satisfies(KB kb) {
		Collection<Sentence> sentences = kb.sentences();
		for(Sentence s: sentences) {
			if(!(s.isSatisfiedBy(this))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return true if this Model satisfies (makes true) the given Sentence.
	 */
	public Boolean satisfies(Sentence sentence) {
		if(sentence.isSatisfiedBy(this)) {
			return true;
		}
		else {
		return false;
		}
	}
	
	/**
	 * Print the assignments in this Model to System.out.
	 */
	public void dump() {
		for(Symbol s: assignments.keySet()) {
			System.out.println(s.toString() + " = " + assignments.get(s));
		}	
	}
	
	public Model assign(Symbol s, Boolean b) {
		this.set(s, b);
		return this;
	}
	
	/**
	 * Creates and returns deep cloned object
	 */
	public Model getClone() {
		
		return this;
	}

}
