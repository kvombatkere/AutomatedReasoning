//CSC 442: AI Project 02 - Automated Reasoning
//March 2018
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//TTModelChecking - implements TTEntails Algorithm

package ark;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import pl.cnf.CNFConverter;
import pl.cnf.Clause;
import pl.cnf.Literal;
import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;

public interface TTModelChecking {
	
	//Method to check entailment
	public static Boolean ttEntails(KB kb, Sentence alpha){
		List<Symbol> symbols = new ArrayList<Symbol>(kb.symbols());
		List<Symbol> alphaSymbols = new ArrayList<Symbol>(getSymbols(alpha));
		for(Symbol sym: alphaSymbols) {
			if(!symbols.contains(sym)) {
				symbols.add(sym);
			}
		}
		//System.out.println(symbols);
		return(ttCheckAll(kb, alpha, symbols, new Model()));
	}
	
	//Method to enumerate Truth Table for model
	public static Boolean ttCheckAll(KB kb, Sentence alpha, List<Symbol> symbols, Model model ){
//		System.out.println(model.getAss().size());
//		model.dump();
//		System.out.println("------------------------");
		if (symbols.isEmpty()) {
			if (model.satisfies(kb)) {
				return model.satisfies(alpha);
			} 
			
			else {	
				return Boolean.TRUE;
			}
		} 
		else {
			
			Symbol p = symbols.remove(0);
			
			//Change to create model clone first for readability
			Model modelCloneT = (Model) Model.deepClone(model);
			Model modelCloneF = (Model) Model.deepClone(model);
			
			return (ttCheckAll(kb, alpha, (List<Symbol>) Model.deepClone(symbols), modelCloneT.assign(p, Boolean.TRUE))
					&&
					ttCheckAll(kb, alpha,(List<Symbol>) Model.deepClone(symbols), modelCloneF.assign(p, Boolean.FALSE)));		
		}
	}
	
	
	//Kinda jank way to get symbols from a sentence(converting to CNF), but figured i'd throw it in here
	public static List<Symbol> getSymbols(Sentence alpha){
		Set<Clause> clauses = CNFConverter.convert(alpha);
		List<Symbol> symbols = new ArrayList<Symbol>();
		for(Clause cl: clauses){
			for(Literal lit: cl) {
				if(!symbols.contains(lit.getContent())) {
				symbols.add(lit.getContent());
				}
			}
		}
		return symbols;
	}

}
