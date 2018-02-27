package pl.core;

import java.util.List;

abstract public class CompoundSentence implements Sentence {
	
	List<Symbol> symList;
	
	public List<Symbol> getSymbols(){
		return symList;
	}
}
