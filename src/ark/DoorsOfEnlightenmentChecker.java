//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//DoorsOfEnlightenmentChecker

package ark;

import pl.core.Symbol;

public class DoorsOfEnlightenmentChecker {

	public static void main(String[] args) {
		//instantiate knowledge base
		DoorsOfEnlightenmentKB kb = new DoorsOfEnlightenmentKB();
		
		Symbol A = kb.intern("A");
		Symbol B = kb.intern("B");
		Symbol C = kb.intern("C");
		Symbol D = kb.intern("D");
		Symbol E = kb.intern("E");
		Symbol F = kb.intern("F");
		Symbol G = kb.intern("G");
		Symbol H = kb.intern("H");
		
		Symbol X = kb.intern("X");
		Symbol Y = kb.intern("Y");
		Symbol Z = kb.intern("Z");
		Symbol W = kb.intern("W");
		
		System.out.println("Which doors can be proved to lead to the inner sanctum?");
		System.out.println("X: " + TTModelChecking.ttEntails(kb, X));
		System.out.println("Y: " + TTModelChecking.ttEntails(kb, Y));
		System.out.println("Z: " + TTModelChecking.ttEntails(kb, Z));
		System.out.println("W: " + TTModelChecking.ttEntails(kb, W));
		
		System.out.println("Which priests can be proved to be knights?");
		System.out.println("A: " + TTModelChecking.ttEntails(kb, A));
		System.out.println("B: " + TTModelChecking.ttEntails(kb, B));
		System.out.println("C: " + TTModelChecking.ttEntails(kb, C));
		System.out.println("D: " + TTModelChecking.ttEntails(kb, D));
		System.out.println("E: " + TTModelChecking.ttEntails(kb, E));
		System.out.println("F: " + TTModelChecking.ttEntails(kb, F));
		System.out.println("G: " + TTModelChecking.ttEntails(kb, G));
		System.out.println("H: " + TTModelChecking.ttEntails(kb, H));
	}
}
