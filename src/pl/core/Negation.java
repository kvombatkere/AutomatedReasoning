package pl.core;

import java.util.List;

public class Negation extends UnaryCompoundSentence {
	
	public Negation(Sentence argument) {
		super(UnaryConnective.NOT, argument);
	}

	/**
	 * Return true if this Negation is satisfied by the given Model.
	 * That is, if its argument is not satisfied by the Model.
	 */
	public boolean isSatisfiedBy(Model model) {
		return !argument.isSatisfiedBy(model);
	}

	//added by avi
	@Override
	public List<Symbol> getSymbols() {
		// TODO Auto-generated method stub
		return null;
	}



}
