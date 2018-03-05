package ark;

<<<<<<< HEAD
import pl.core.Biconditional;
import pl.core.Conjunction;
import pl.core.Disjunction;
=======
import pl.core.Conjunction;
>>>>>>> 0a68406599d4a0a66a03f3233c35521a431df06f
import pl.core.Implication;
import pl.core.Model;
import pl.core.Negation;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.ModusPonensKB;
import pl.examples.WumpusWorldKB;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pl.cnf.CNFConverter;
import pl.cnf.Clause;
import pl.cnf.Literal;
import pl.cnf.Literal.Polarity;

public interface DPLL {
	
	//NOT CHECKED
	//Check if sentence is satisfiable by calling dpll
	public static Boolean dpllSatisfiable(Sentence s) {
		Set<Clause> clauses = CNFConverter.convert(s);

		//manually creating symbol list maybe, also idk if it should be array list
		List<Symbol> symList = new ArrayList<Symbol>();
		for(Clause cl: clauses){
			for(Literal lit: cl) {
				if(!symList.contains(lit.getContent())) {
				symList.add(lit.getContent());
				}
			}
		}
	//	System.out.println(symList);
		System.out.println(clauses);
		System.out.println(symList);
		return dpll(clauses, symList, new Model());
	}

	//NOT CHECKED
	//main DPLL algorithm
	@SuppressWarnings("unused")
	public static Boolean dpll(Set<Clause> clauses, List<Symbol> symbols, Model model ) {
		
		//THESE TWO IF STATEMENTS NEED FIXING, i think they need to be able to handle unknown(null) values	
		//if some clause in clauses is false in model then return false
		for(Clause clause: clauses) {
			if(clause.isSatisfiedBy(model) != null) {
				if(!clause.isSatisfiedBy(model)) {	
				return false;
				}
			}
		}		
		
		//if every clause in clauses is true in model then return true
		if(allClausesTrue(clauses, model)){
			model.dump();
		//	System.out.println(clauses);
			return true;
		}
	
		
		
		//Improve efficiency by looking for symbols that have same polarity in all clauses and assigning value to make them true
		Literal pure = findPureSymbol(symbols, clauses, model);
		System.out.println("findPure: " + pure);
		//TEMP FOR TESTING
	//	pure = null;
		
		if(pure != null) {
		//	System.out.println("got pure symbol");
			//reminder to check about cloning symbols
			symbols.remove(pure.getContent());
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
			return dpll(clauses, (List<Symbol>) Model.deepClone(symbols), modelClonePure.assign(pure.getContent(), value ));
		}
				
		//Unit Propagation
<<<<<<< HEAD
	//	Literal unit = findUnitClause(symbols, clauses, model);	

		//TEMP FOR TESTING
		Literal	unit = null;
=======
		//Literal unit = findUnitClause(symbols, clauses, model);	

		//TEMP FOR TESTING
		Literal unit = null;
>>>>>>> 0a68406599d4a0a66a03f3233c35521a431df06f
		
		if(unit != null) {
			
			//reminder to check about cloning symbols
			symbols.remove(unit.getContent());
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
			
			return dpll(clauses, (List<Symbol>) Model.deepClone(symbols), modelCloneUnit.assign(unit.getContent(), value));
		}
		
		//Algorithm defaults to truth table enumeration if can't use above heuristics
		Symbol p = symbols.remove(0);
		System.out.println("remove symbol");
		Model modelCloneT = (Model) Model.deepClone(model);
		Model modelCloneF = (Model) Model.deepClone(model);
		
		return (dpll(clauses, (List<Symbol>) Model.deepClone(symbols), modelCloneT.assign(p, true))
			   ||
			   dpll(clauses, (List<Symbol>) Model.deepClone(symbols), modelCloneF.assign(p, false)));
			
		
	}
	
	//NOT CHECKED
	//method to determine if all clauses are true in model
	public static Boolean allClausesTrue(Set<Clause> clauses, Model model) {
		for(Clause clause: clauses) {
			if(clause.isSatisfiedBy(model)!=null) { //null check
				if(!clause.isSatisfiedBy(model)) { //if any clause is not satisfied, return false
					return false;
				}
			}
			else { //if any clauses are still null, return false
				return false;
			}
		}
		//no clauses are unsatisfied or unknown
		return true;
	}
	
	//IN PROGRESS
	//method to find (symbol, value) pair of pure symbol..i think literal might work for this but not positive
	public static Literal findPureSymbol(List<Symbol> symbols, Set<Clause> initClauses, Model model) {
	//	System.out.println("looking for pure symbol");
		Polarity val = null;
		boolean breakAgain = false;
		boolean pure = false;
		Set<Clause> clauses = eliminateClauses(initClauses, model);
	//	System.out.println(clauses);
		for (Symbol sym: symbols) {
		//	System.out.println("Checking for symbol: " + sym);
			Literal lit = new Literal(sym);
			for(Clause cl: clauses) {
			//	System.out.println("checking clause: " + cl );
				for(Literal l: cl) {
					if(l.getContent() == sym && l.getPolarity() != lit.getPolarity()) {
				//		System.out.println("Found impure: " + lit);
						pure = false;
						breakAgain = true;
						break;
					}		
					
					if(l.getContent() == sym) {
				//		System.out.println("Still pure: " + lit);
						lit.setPolarity(l.getPolarity());
						pure = true;
					}
				}
				
				if(breakAgain) {
				//	System.out.println(lit + " not pure");
					breakAgain = false;
					break;

			}
		
		//return null if can't find pure symbol

			}
			if(pure) {
				return lit;
			}
			
		}
		return null;
	}
	
	//helper method for findPureSymbol to get rid of clauses that are already true
	public static Set<Clause> eliminateClauses(Set<Clause> clauses, Model model){
		//commented out because it causes a null pointer exception righ now
		Iterator<Clause> iterator = clauses.iterator();
		//right now do nothing, just placeholder
		while(iterator.hasNext()) {
			Clause cl = iterator.next();
			if(cl.isSatisfiedBy(model) != null && cl.isSatisfiedBy(model)) {
				iterator.remove();
			}
		}
		return clauses;
	}
	
	//IN PROGRESS
	//method to find clauses with only one literal or clause with only one true literal 
	public static Literal findUnitClause(List<Symbol> symbols, Set<Clause> clauses, Model model) {
		System.out.println("Unit Clause FUNCTION CALL:");//print when this method is called

		Literal unitLiteral = null;

		//Loop over all the clauses
		for(Clause clause: clauses) {
			//count to keep track of number of assigned values in clause
			int numAssignedValues = 0;
			
			//Get the total number of literals in the clause
			int numLiterals = clause.size();
			
			//if clause only has one literal, return that literal
			if(numLiterals == 1) {
				return clause.get(0);
			}
			
			//Loop over all literals in a clause to check if it is a unit clause
			for(Literal li: clause) {
				Symbol symbolToCheck = li.getContent(); //the literal we want to check in the model
				
				//we have two cases that make a literal assigned false by the model
				//case 1-> li has negative polarity and and symbolToCheck == true
				//case 2-> li has positive polarity and symbolToCheck == false
				
				//increment the count for number of assigned literals if either of above cases is satisfied
				if(model.get(symbolToCheck) == true && li.getPolarity() == Polarity.NEGATIVE) {
					numAssignedValues += 1;
				}
				
				if(model.get(symbolToCheck) == false && li.getPolarity() == Polarity.POSITIVE) {
					numAssignedValues += 1;
				}
				
				
				//If neither of the above cases are satisfied, then the particular literal is a contender for being a unit clause
				else {
					unitLiteral = li;
				}	
			}
			
			//After all literals have been checked, check if the clause is a unit clause
			if(numAssignedValues + 1 == numLiterals) {
				System.out.println("Unit Clause found:" + unitLiteral);
				return unitLiteral;
			}
			
		}
		//return null if can't find unit clause
		return null;
	}
	
	
	public static void main(String[] args) {
		
		
		//testing to see if null pointer problem is fixed
<<<<<<< HEAD
//		WumpusWorldKB wkb = new WumpusWorldKB();
//		Symbol p12 = wkb.intern("P1,2");
//		wkb.add(p12);
//		wkb.dump();
//		System.out.println("DPLL Satisiable = " + DPLL.dpllSatisfiable(wkb.getKBAsSentence()));
=======
		WumpusWorldKB wkb = new WumpusWorldKB();
		Symbol p12 = wkb.intern("P1,2");
		wkb.dump();
		System.out.println("Wumpus World Pit(1,2) DPLL Satisiable = " + DPLL.dpllSatisfiable(new Conjunction(wkb.getKBAsSentence(), p12)));
>>>>>>> 0a68406599d4a0a66a03f3233c35521a431df06f

		//testing stuff
		HornClausesKB kb = new HornClausesKB();
<<<<<<< HEAD
		
=======
		Sentence s = kb.getKBAsSentence();
		Set<Clause> clauses = CNFConverter.convert(s);
		List<Symbol> symList = new ArrayList<Symbol>();
		Symbol mythical = kb.intern("Mythical");
		Symbol magical = kb.intern("Magical");
		
		System.out.println("Horn Clauses Mythical DPLL Satisfiable = " + DPLL.dpllSatisfiable(new Conjunction(s, new Negation(mythical))));
		System.out.println("Horn Clauses Magical DPLL Satisfiable = " + DPLL.dpllSatisfiable(new Conjunction(s, new Negation(magical))));

		for(Clause cl: clauses){
			for(Literal lit: cl) {
				if(!symList.contains(lit.getContent())) {
				symList.add(lit.getContent());
				}
			}
		}
		Symbol mammal = kb.intern("Mammal");
>>>>>>> 0a68406599d4a0a66a03f3233c35521a431df06f
		
		
//		List<Symbol> symList = new ArrayList<Symbol>();
//		
//		for(Clause cl: clauses){
//			for(Literal lit: cl) {
//				if(!symList.contains(lit.getContent())) {
//				symList.add(lit.getContent());
//				}
//			}
//		}
		Symbol horned = kb.intern("Horned");
	//	kb.add(new Negation(mythical));
		Sentence s = kb.getKBAsSentence();
		Symbol x = kb.intern("x");
		Symbol y = kb.intern("y");
		Symbol w = kb.intern("w");
		Symbol z = kb.intern("z");
		Sentence c1 = new Disjunction(x, y);
		c1 = new Disjunction(c1, w);
		Sentence c2 = new Disjunction(new Negation(z), y);
		Sentence c3 = new Disjunction(y, w);
		Sentence c4 = new Conjunction(c1, c2);
		Sentence c5 = new Conjunction(c3, c4);
		Sentence c7 = new Conjunction(z, new Negation(z));
		Sentence c6 = new Conjunction(c5, new Negation(x));
		Sentence c8 = new Conjunction(c6, c7);
//		System.out.println(CNFConverter.convert(c6));
	//	System.out.println(s);
	//	kb.dump();
	//	System.out.println(CNFConverter.convert(new Disjunction(new Negation(s), mythical)));
	//	Set<Clause> clauses = CNFConverter.convert(s);
//		System.out.println(in);
//		System.out.println(s);
	//	System.out.println(clauses);
		System.out.println(dpllSatisfiable(new Conjunction(horned, new Negation(horned))));
		
//		Literal lit = findPureSymbol(symList, clauses, model);
	//	System.out.println(symList);
	//	System.out.println(lit);
	}
}
