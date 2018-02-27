//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//ModusPonensModel

package ark;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.ModusPonensKB;

public class ModusPonensModel implements Model, TTModelChecking{

	private ModusPonensKB kb = new ModusPonensKB();
	@Override
	public void set(Symbol sym, boolean value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean get(Symbol sym) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean satisfies(KB kb) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean satisfies(Sentence sentence) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dump() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Model assign(List<Symbol> variables, List<Boolean> values) {
		for(int i=0; i<variables.size(); i++) {
			this.set(variables.get(i), values.get(i));
		}
		return this;
	}
	
	//Method to check entailment
	public boolean ttEntails(KB kb, Sentence alpha) {
		List<Symbol> symbols = new ArrayList<Symbol>(kb.symbols());
		symbols.addAll(alpha.getSymbols());
		return(ttCheckAll(kb, alpha, symbols, new ModusPonensModel()));
	}
	
	
	//Method to enumerate Truth Table for model
	public boolean ttCheckAll(KB kb, Sentence alpha, List<Symbol> symbols, Model model ) {
		
		if (symbols.isEmpty()) {
			if (model.satisfies(kb)) {
			return model.satisfies(alpha);
			} 
			else {
			return true;
			}
			 
			 } 
		else {
			 
			Symbol p = symbols.remove(0);
			
			return (ttCheckAll(kb, alpha, symbols,
			model.getClone().assign(Arrays.asList(p), Arrays.asList(Boolean.TRUE))) &&
			ttCheckAll(kb, alpha, symbols,
			model.getClone().assign(Arrays.asList(p), Arrays.asList(Boolean.FALSE))));
			}
	}


}
