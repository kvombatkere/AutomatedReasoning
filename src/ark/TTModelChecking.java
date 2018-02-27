package ark;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import pl.core.KB;
import pl.core.Model;
import pl.core.Sentence;
import pl.core.Symbol;

public interface TTModelChecking {
	
	//Method to 
	public boolean ttEntails(KB kb, Sentence alpha);
	
	
	//
	public boolean ttCheckAll(KB kb, Sentence alpha, List<Symbol> symbols, Model model );
	
	

}
