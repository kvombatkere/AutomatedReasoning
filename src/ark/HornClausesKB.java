package ark;

import pl.core.Biconditional;
import pl.core.Conjunction;
import pl.core.Disjunction;
import pl.core.Implication;
import pl.core.KB;
import pl.core.Negation;
import pl.core.Symbol;


public class HornClausesKB extends KB{
	
	public HornClausesKB() {
		super();
		
		//Symbols for the different elements in KB
		Symbol mythical = intern("Mythical");
		Symbol mortal = intern("Mortal");
		Symbol magical = intern("Magical");
		Symbol mammal = intern("Mammal");
		Symbol horned = intern("Horned");

		//if mythical => Immortal
		add(new Implication(mythical, new Negation(mortal)));
		
		//if NOT mythical => Mortal Mammal
		add(new Implication(new Negation(mythical), new Conjunction(mortal, mammal)));
		
		//if (immortal OR mammal) => horned
		add(new Implication(new Disjunction(new Negation(mortal), mammal), horned));

		//if horned => magical
		add(new Implication(horned, magical));
		
	}

	public static void main(String[] args) {
		new HornClausesKB().dump();
	}

}
