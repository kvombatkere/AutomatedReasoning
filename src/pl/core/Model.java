package pl.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * A Model is an assignment of boolean values (true or false) to
 * PropositionalSymbols.
 */
@SuppressWarnings({ "serial", "unused" })
public class Model implements Serializable{

	//Model was changed from an interface to a class and all methods were implemented
	//Only the assign and deep clone methods were added, all others were in original class as method signatures
	
	//ARK added HashMap to contain values and assignments

	protected HashMap<Symbol, Boolean> assignments = new HashMap<>();
	
	public Model() {}
	
	public Model(HashMap<Symbol, Boolean> assignments) {
		this.assignments = assignments;
	}
	
	//adding getter for assignments
	public HashMap<Symbol, Boolean> getAss(){
		return this.assignments;
	}
	
	/**
	 * Set the value assigned to the given PropositionSymbol in this
	 * Model to the given boolean VALUE.
	 */
	public void set(Symbol sym, Boolean value) {
		assignments.put(sym, value);
	}
	
	//

	/**
	 * Returns the boolean value associated with the given PropositionalSymbol
	 * in this Model.
	 */
	public Boolean get(Symbol sym) {
		return assignments.get(sym);
	}
	
	/**
	 * Return true if this Model satisfies (makes true) the given KB.
	 */
	public Boolean satisfies(KB kb) {
		//I flipped the return statements in this, they looked wrong before?
		Collection<Sentence> sentences = kb.sentences();
		
		for(Sentence s: sentences) {
			if(!(s.isSatisfiedBy(this))) {
				return Boolean.FALSE;
			}

		}
		return Boolean.TRUE;
	}

	/**
	 * Return true if this Model satisfies (makes true) the given Sentence.
	 */
	public Boolean satisfies(Sentence sentence) {

		if(sentence.isSatisfiedBy(this)) {
			return Boolean.TRUE;
		}
		else {
			return Boolean.FALSE;
		}
	}
	
	/**
	 * Print the assignments in this Model to System.out.
	 */
	public void dump() {
		for(Symbol s: assignments.keySet()) {
			System.out.println(s.toString() + " = " + assignments.get(s));
		}	
	}
	
	//ARK
	public Model assign(Symbol s, Boolean b) {
		assignments.put(s, b);
		return this;
	}
	
	//Method to enable cloning of the object
	//Code Source: https://alvinalexander.com/java/java-deep-clone-example-source-code
	/**
	* This method makes a "deep clone" of any Java object it is given.
	*/
	public static Object deepClone(Object object) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ObjectOutputStream oos = new ObjectOutputStream(baos);
		    oos.writeObject(object);
		    ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		    ObjectInputStream ois = new ObjectInputStream(bais);
		    return ois.readObject();
		}
		catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
	} //end deepClone()
		 

}
