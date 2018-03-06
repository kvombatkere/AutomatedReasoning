package ark;

import pl.core.Conjunction;
import pl.core.Implication;
import pl.core.KB;
import pl.core.Model;
import pl.core.Negation;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.ModusPonensKB;
import pl.examples.WumpusWorldKB;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pl.cnf.CNFConverter;
import pl.cnf.Clause;
import pl.cnf.Literal;
import pl.cnf.Literal.Polarity;

public interface DPLL {
	
	//use DPLL satisfiability and proof by contradiction to prove or disprove the sentence
	//returns true if the sentence s is entailed, false o/w
	public static Boolean proofByContradiction(KB kb, Sentence s) {	
		//convert knowledge base to a sentence
		Sentence Skb = kb.getKBAsSentence();
		
		//check if conjunction of knowledge base and sentence is satisfiable
		//Boolean sSatisfiable = DPLL.dpllSatisfiable(new Conjunction(Skb, s));
		//check if conjunction of knowledge base and negation of sentence is satisfiable
		Boolean convSatisfiable = DPLL.dpllSatisfiable(new Conjunction(Skb, new Negation(s)));
		
		//if satisfiability requires the input sentence, it must be true
		if(!convSatisfiable.booleanValue()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
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
		
		return dpll(clauses, symList, new Model());
	}

	
	//main DPLL algorithm
	@SuppressWarnings("unused")
	public static Boolean dpll(Set<Clause> clauses, List<Symbol> symbols, Model model) {
	
		
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
			return true;
		}
	
			
		//Improve efficiency by looking for symbols that have same polarity in all clauses and assigning value to make them true
		Literal pure = findPureSymbol(symbols, eliminateClauses(clauses, model), model);

		if(pure != null) {

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
				
<<<<<<< HEAD

=======
		//Unit Propagation
		//System.out.println("Before findUnitClause call:" + symbols);
>>>>>>> 66f4de7b4b69996d0dab4c9726bc3de80927a947

		Literal unit = findUnitClause(symbols, clauses, model);	
		//System.out.println(unit);
		unit = null;
<<<<<<< HEAD

=======
		
>>>>>>> 66f4de7b4b69996d0dab4c9726bc3de80927a947
		if(unit != null) {
			
			//reminder to check about cloning symbols
			symbols.remove(unit.getContent());
			//System.out.println(symbols);

			Boolean value = null;
			
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
				System.out.println("uh oh");
			}
			
			Model modelCloneUnit = (Model) Model.deepClone(model);
			return dpll(clauses, (List<Symbol>) Model.deepClone(symbols), modelCloneUnit.assign(unit.getContent(), value));
		}
		
		//Algorithm defaults to truth table enumeration if can't use above heuristics
		Symbol p = symbols.remove(0);
		Model modelCloneT = (Model) Model.deepClone(model);
		Model modelCloneF = (Model) Model.deepClone(model);
		
		return (dpll(clauses, (List<Symbol>) Model.deepClone(symbols), modelCloneT.assign(p, true))
			   ||
			   dpll(clauses, (List<Symbol>) Model.deepClone(symbols), modelCloneF.assign(p, false)));
			
		
	}
	
	
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
	
	
	//method to find (symbol, value) pair of pure symbol..i think literal might work for this but not positive
	public static Literal findPureSymbol(List<Symbol> symbols, Set<Clause> initClauses, Model model) {
		
		boolean breakAgain = false;
		boolean pure = false;
		//eliminateClauses currently not doing anything, just there as placeholder
		Set<Clause> clauses = eliminateClauses(initClauses, model);
		for (Symbol sym: symbols) {
			Literal lit = new Literal(sym);
			
			for(Clause cl: clauses) {
			
				for(Literal l: cl) {

					if(l.getContent() == sym && l.getPolarity() != lit.getPolarity()) {
						//System.out.println("nope");
						pure = false;
						breakAgain = true;
						break;
					}		
					
					if(l.getContent() == sym) {
						lit.setPolarity(l.getPolarity());
						pure = true;
					}
				}
				
				if(breakAgain) {
					breakAgain = false;
					break;

			}
		
		//return null if can't find pure symbol

			}
			if(pure) {
		//		System.out.println("Found Pure Symbol: "+ lit);
				return lit;
			}
			
		}
		return null;
	}
	
	//helper method for findPureSymbol to get rid of clauses that are already true
	public static Set<Clause> eliminateClauses(Set<Clause> clauses, Model model){
		//commented out because it causes a null pointer exception right now
	//	Set<Clause> clauseClone = (Set<Clause>) Model.deepClone(clauses);
		Set<Clause> reduced = new HashSet<Clause>();
		reduced.addAll(clauses);
		Iterator<Clause> iterator = reduced.iterator();
		//right now do nothing, just placeholder
		while(iterator.hasNext()) {
			Clause cl = iterator.next(); 
			if(cl.isSatisfiedBy(model) != null)
				if (cl.isSatisfiedBy(model)) {
				iterator.remove();
			//	System.out.println("remove clause");
			}
		}
		return reduced;
	}
	
	//method to find clauses with only one literal or clause with only one true literal 
	public static Literal findUnitClause(List<Symbol> symbols, Set<Clause> clauses, Model model) {
	//System.out.println("FIND UNIT CLAUSE FUNCTION CALL");//print when this method is called
		
		Literal unitLiteral = null;
		//System.out.println(clauses);
		//System.out.println("Assignments: " +model.getAss() + ", Symbols: " +  symbols);
		//Loop over all the clauses
		for(Clause clause: clauses) {
			//count to keep track of number of assigned values in clause
			int numAssignedValues = 0;
			
			//Get the total number of literals in the clause
			int numLiterals = clause.size();
			//System.out.println("Number of Literals to check: " + numLiterals);
			
			//if clause only has one literal, return that literal
			if(numLiterals == 1) {
				if(symbols.contains(clause.get(0))) {
					//System.out.println("Found Unit Clause: " + clause.get(0));
					return clause.get(0);
				}
			}
			
			//If the clause has more than one literal
			else {
				//Loop over all literals in a clause to check if it is a unit clause
				for(Literal li: clause) {
					Symbol symbolToCheck = li.getContent(); //the literal we want to check in the model
					
						//we have two cases that make a literal assigned false by the model
						//case 1-> li has negative polarity and and symbolToCheck == true
						//case 2-> li has positive polarity and symbolToCheck == false
						
						//increment the count for number of assigned literals if either of above cases is satisfied
						if(model.get(symbolToCheck)!= null && model.get(symbolToCheck) == true && li.getPolarity() == Polarity.NEGATIVE) {
							//System.out.println("~" + symbolToCheck + " already assigned false by model");
							numAssignedValues += 1;
						}
						
						else if(model.get(symbolToCheck)!= null && model.get(symbolToCheck) == false && li.getPolarity() == Polarity.POSITIVE) {
							//System.out.println(symbolToCheck + " already assigned false by model");
							numAssignedValues += 1;
						}
						
						//If neither of the above cases are satisfied, then the particular literal is a contender for being a unit clause
						else {
							//Check if the symbol to be checked is in the symbol list before assigning (prevent stack overflow)
							if(symbols.contains(symbolToCheck)) {
								unitLiteral = li;
							}
						}	
	
				}
				//After all literals have been checked, check if the clause is a unit clause
				if(numAssignedValues + 1 == numLiterals && unitLiteral != null) {

					return unitLiteral;
				}	
			}
		}
		//return null if can't find unit clause
		//System.out.println("No unit clause found");
		return null;
	}
	

	
	public static void main(String[] args) {		
//		//testing to see if null pointer problem is fixed
//		WumpusWorldKB wkb = new WumpusWorldKB();
//		Symbol p12 = wkb.intern("P1,2");
//	//	wkb.dump();
//		System.out.println("Wumpus World ~Pit(1,2) DPLL Satisfiable = " + DPLL.dpllSatisfiable(new Conjunction(wkb.getKBAsSentence(), new Negation(p12))));

		//testing stuff
		HornClausesKB hckb = new HornClausesKB();
	
		Symbol mythical = hckb.intern("Mythical");
		Symbol magical = hckb.intern("Magical");
		Symbol horned = hckb.intern("Horned");
		
		Sentence sKB = hckb.getKBAsSentence();
		System.out.println("Horn Clauses ~Mythical DPLL Satisfiable = " + DPLL.dpllSatisfiable(new Conjunction(sKB, new Negation(mythical))));
		System.out.println("Horn Clauses ~Magical DPLL Satisfiable = " + DPLL.dpllSatisfiable(new Conjunction(sKB, new Negation(magical))));
		System.out.println("Horn Clauses ~Horned DPLL Satisfiable = " + DPLL.dpllSatisfiable(new Conjunction(sKB, new Negation(horned))));

		
//		List<Symbol> symList = new ArrayList<Symbol>();
//		Set<Clause> clauses = CNFConverter.convert(sKB);
//
//		for(Clause cl: clauses){
//			for(Literal lit: cl) {
//				if(!symList.contains(lit.getContent())) {
//				symList.add(lit.getContent());
//				}
//			}
//		}
//		Symbol mammal = hckb.intern("Mammal");
//		
//		Model model = new Model();
//		model.set(mammal, true);
//		model.set(mythical, true);
//		System.out.println(clauses);
//		Literal lit = findPureSymbol(symList, clauses, model);
//		
//		Literal lit2 = findUnitClause(symList, clauses, model);
//		System.out.println(symList);
//	//	System.out.println(lit);
//		System.out.println("---------------------------------------");
//		Set<Clause> testClauses = CNFConverter.convert(hckb.getKBAsSentence());
//		System.out.println(testClauses);
//		Model modelTest = new Model();
//		modelTest.assign(mythical, true);
//		Set<Clause> reduced = eliminateClauses(testClauses, modelTest);
//		System.out.println(reduced);
		
	}
}