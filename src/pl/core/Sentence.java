package pl.core;

import java.util.List;

public interface Sentence {
	
	/**
	 * Return true if this Sentence is satisfied by the given Model.
	 */
	public boolean isSatisfiedBy(Model model);
	public List<Symbol> getSymbols();
	
}
