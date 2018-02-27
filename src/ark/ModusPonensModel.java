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
import java.util.HashMap;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;
import pl.examples.ModusPonensKB;

<<<<<<< HEAD
public class ModusPonensModel implements Model, Cloneable{

	private ModusPonensKB kb = new ModusPonensKB();
	
=======
public class ModusPonensModel implements Model, TTModelChecking{
	
	private HashMap<Symbol, Boolean> assignments = new HashMap<>();
	private ModusPonensKB kb = new ModusPonensKB();
	
	public ModusPonensModel() {
		assignments.put(new Symbol("P"), null);
		assignments.put(new Symbol("Q"), null);
	}

>>>>>>> eac9c19c3a3ea65ed79a93c2f0e76a4619bfbe48
	@Override
	public void set(Symbol sym, boolean value) {
		assignments.replace(sym, value);
	}

	@Override
	public Boolean get(Symbol sym) {
		return assignments.get(sym);
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
	
<<<<<<< HEAD
	
	public Model assign(List<Symbol> variables, List<Boolean> values) {
		for(int i=0; i<variables.size(); i++) {
			this.set(variables.get(i), values.get(i));
		}
=======
	@Override
	public Model assign(Symbol s, Boolean b) {
		this.set(s, b);
>>>>>>> eac9c19c3a3ea65ed79a93c2f0e76a4619bfbe48
		return this;
	}
	
	//Method to check entailment
	public boolean ttEntails(KB kb, Sentence alpha) {
		List<Symbol> symbols = new ArrayList<Symbol>(kb.symbols());
		symbols.addAll(alpha.getSymbols());
		return(ttCheckAll(kb, alpha, symbols, new ModusPonensModel()));
	}
	
	
	//Method to enumerate Truth Table for model
	public boolean ttCheckAll(KB kb, Sentence alpha, List<Symbol> symbols, ModusPonensModel model ) {
		
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
<<<<<<< HEAD
			((Model) model.clone()).assign(Arrays.asList(p), Arrays.asList(Boolean.TRUE))) &&
			ttCheckAll(kb, alpha, symbols,
			((Model) model.clone()).assign(Arrays.asList(p), Arrays.asList(Boolean.FALSE))));

=======
			model.getClone().assign(p, Boolean.TRUE)) &&
			ttCheckAll(kb, alpha, symbols,
			model.getClone().assign(p, Boolean.FALSE)));
>>>>>>> eac9c19c3a3ea65ed79a93c2f0e76a4619bfbe48
			}
	}


	
	
	




}
