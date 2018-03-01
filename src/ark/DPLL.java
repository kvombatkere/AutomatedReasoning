package ark;

import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import java.util.List;
import java.util.Set;

import pl.cnf.CNFConverter;
import pl.cnf.Clause;
import pl.cnf.Literal;
import pl.cnf.Literal.Polarity;

public class DPLL {
	
	public static Boolean dpllSatisfiable(Sentence s, List<Symbol> symbols) {
		Set<Clause> clauses = CNFConverter.convert(s);
		return dpll(clauses, symbols, new Model());
	}

	public static Boolean dpll(Set<Clause> clauses, List<Symbol> symbols, Model model ) {

		//if some clause in clauses is false in model then return false
		for(Clause clause: clauses) {
			if(!clause.isSatisfiedBy(model)) {
				return false;
			}
		}
		
		//if every clause in clauses is true in model then return true
		if(allClausesTrue(clauses, model)){
			return true;
		}
		
		//Improve efficiency by looking for symbols that have same polarity in all clauses and assigning value to make them true
		Literal pure = findPureSymbol(symbols, clauses, model);
		if(pure != null) {
			//reminder to check about cloning symbols
			symbols.remove(pure);
			Boolean value;
			
			//If literal is a negation, assign it false to make it true
			if(pure.getPolarity() == Polarity.NEGATIVE) {
				value = false;
			}
			//if positive, assign true
			else if(pure.getPolarity() == Polarity.POSITIVE) {
				value = true;
			}
			//this should never happen (i chose true randomly), but wanted to include both polarity options for readability
			else {
				value = true;
			}
			Model modelClonePure = (Model) Model.deepClone(model);
			return dpll(clauses, symbols, modelClonePure.assign(pure.getContent(), value ));
		}
		
		//Unit Propagation
		Literal unit = findUnitClause(symbols, clauses, model);	
		if(unit != null) {
			//reminder to check about cloning symbols
			symbols.remove(unit);
			Boolean value;
			
			//If literal is a negation, assign it false to make it true
			if(unit.getPolarity() == Polarity.NEGATIVE) {
				value = false;
			}
			//if positive, assign true
			else if(unit.getPolarity() == Polarity.POSITIVE) {
				value = true;
			}
			//this should never happen (i chose true randomly), but wanted to include both polarity options for readability
			else {
				value = true;
			}
			Model modelCloneUnit = (Model) Model.deepClone(model);
			
			return dpll(clauses, symbols, modelCloneUnit.assign(unit.getContent(), value ));
		}
		
		Symbol p = symbols.remove(0);
		Model modelCloneT = (Model) Model.deepClone(model);
		Model modelCloneF = (Model) Model.deepClone(model);
		
		return (dpll(clauses, symbols, modelCloneT.assign(p, true))
			   ||
			   dpll(clauses, symbols, modelCloneF.assign(p, false)));
			
		
	}
	
	
	//method to determine if all clauses are true in model
	public static Boolean allClausesTrue(Set<Clause> clauses, Model model) {
		for(Clause clause: clauses) {
			if(!clause.isSatisfiedBy(model)) {
				return false;
			}
		}
		
		return true;
	}
	
	//method to find (symbol, value) pair of pure symbol..i think literal might work for this but not positive
	public static Literal findPureSymbol(List<Symbol> symbols, Set<Clause> clauses, Model model) {
		return null;
	}
	
	public static Literal findUnitClause(List<Symbol> symbols, Set<Clause> clauses, Model model) {
		return null;
	}
}
