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
	//ARK: getSymbols added, should probably also be removed
>>>>>>> 4aae176b069c60cbcbce63cf9312cbf06ccbcda6
	public abstract List<Symbol> getSymbols();
	
	
}
