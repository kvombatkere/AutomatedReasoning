package pl.core;

import java.util.List;

//Sentence changed from interface to abstract class
public abstract class Sentence {
	
	//ARK: symlist added, should probably be removed
	List<Symbol> symlist;
	/**
	 * Return true if this Sentence is satisfied by the given Model.
	 */
	public abstract boolean isSatisfiedBy(Model model);
	
	//ARK: getSymbols added, should probably also be removed
	public abstract List<Symbol> getSymbols();
	
	
}
