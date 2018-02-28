package pl.core;

import java.util.List;

public abstract class Sentence {
	
	List<Symbol> symlist;
	/**
	 * Return true if this Sentence is satisfied by the given Model.
	 */
	public abstract boolean isSatisfiedBy(Model model);
	
	public abstract List<Symbol> getSymbols();
	
	
}
