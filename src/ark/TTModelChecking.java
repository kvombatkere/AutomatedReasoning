package ark;

import java.util.ArrayList;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;

public interface TTModelChecking {
	
	
	//Method to check entailment
	public static Boolean ttEntails(KB kb, Sentence alpha){
		List<Symbol> symbols = new ArrayList<Symbol>(kb.symbols());
		return(ttCheckAll(kb, alpha, symbols, new Model()));
	}
	
	//Method to enumerate Truth Table for model
	public static Boolean ttCheckAll(KB kb, Sentence alpha, List<Symbol> symbols, Model model ){
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
<<<<<<< HEAD

=======
		
>>>>>>> f4a325d4a86bd0953d7db36efa5af8aa253bcaaf
			return (ttCheckAll(kb, alpha, symbols,
			(((Model) Model.deepClone(model)).assign(p, Boolean.TRUE))) &&
			ttCheckAll(kb, alpha, symbols,
			((Model) Model.deepClone(model)).assign(p, Boolean.FALSE)));
		}
	}

}
