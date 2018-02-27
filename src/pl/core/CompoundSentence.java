package pl.core;

import java.util.List;

abstract public class CompoundSentence extends Sentence {
	
	List<Symbol> symList;
	
	public List<Symbol> getSymbols(){
		return symList;
	}
}
