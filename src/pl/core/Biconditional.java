package pl.core;

import java.util.List;

public class Biconditional extends BinaryCompoundSentence {
	
	public Biconditional(Sentence lhs, Sentence rhs) {
		super(BinaryConnective.IFF, lhs, rhs);
	}

	/**
	 * Return true if this Biconditional is satisfied by the given Model.
	 * That is, if either both its arguments are satisfied by the Model or
	 * both arguments are not satisfied by the Model.
	 */
	public boolean isSatisfiedBy(Model model) {
		return lhs.isSatisfiedBy(model) == rhs.isSatisfiedBy(model);
	}

	//added by avi
	@Override
	public List<Symbol> getSymbols() {
		// TODO Auto-generated method stub
		return null;
	}
}
