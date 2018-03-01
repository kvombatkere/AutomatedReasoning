package pl.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pl.cnf.CNFConverter;
import pl.cnf.Clause;
import pl.cnf.Literal;

//Sentence changed from interface to abstract class
public abstract class Sentence {
	
	//ARK: symlist added, should probably be removed
	List<Symbol> symlist;
	
	/**
	 * Return true if this Sentence is satisfied by the given Model.
	 */
	public abstract boolean isSatisfiedBy(Model model);

	//Still figuring out best way to get list of symbols in a given sentence
	//ARK: getSymbols added, should probably also be removed

	public abstract List<Symbol> getSymbols();
	
}
