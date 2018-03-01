package ark;

import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import java.util.List;
import java.util.Set;

import pl.cnf.CNFConverter;
import pl.cnf.Clause;

public class DPLL {
	
	public static Boolean dpllSatisfiable(Sentence s) {
		Set<Clause> clauses = CNFConverter.convert(s);
		return true;
	}

	public static Boolean dpll(Set<Clause> clauses, List<Symbol> symbols, Model model ) {
		return true;
	}
}
