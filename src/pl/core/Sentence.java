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
	
<<<<<<< HEAD
	//Still figuring out best way to get list of symbols in a given sentence
=======
>>>>>>> 6d49469d8ab9dc05ee6675ad1cd76a31025e04f5
	//ARK: getSymbols added, should probably also be removed
	public abstract List<Symbol> getSymbols();
	
	
}
