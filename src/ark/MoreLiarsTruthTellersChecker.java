package ark;

import pl.core.Symbol;

public class MoreLiarsTruthTellersChecker implements TTModelChecking, DPLL {
	
	public static void main(String[] args) {
		MoreLiarsTruthTellersKB kb = new MoreLiarsTruthTellersKB();
		
		Symbol A = kb.intern("A");
		Symbol B = kb.intern("B");
		Symbol C = kb.intern("C");
		Symbol D = kb.intern("D");
		Symbol E = kb.intern("E");
		Symbol F = kb.intern("F");
		Symbol G = kb.intern("G");
		Symbol H = kb.intern("H");
		Symbol I = kb.intern("I");
		Symbol J = kb.intern("J");
		Symbol K = kb.intern("K");
		Symbol L = kb.intern("L");
		
		System.out.println(TTModelChecking.ttEntails(kb, A));
		System.out.println(TTModelChecking.ttEntails(kb, B));
		System.out.println(TTModelChecking.ttEntails(kb, C));
		System.out.println(TTModelChecking.ttEntails(kb, D));
		System.out.println(TTModelChecking.ttEntails(kb, E));
		System.out.println(TTModelChecking.ttEntails(kb, F));
		System.out.println(TTModelChecking.ttEntails(kb, G));
		System.out.println(TTModelChecking.ttEntails(kb, H));
		System.out.println(TTModelChecking.ttEntails(kb, I));
		System.out.println(TTModelChecking.ttEntails(kb, J));
		System.out.println(TTModelChecking.ttEntails(kb, K));
		System.out.println(TTModelChecking.ttEntails(kb, L));
		
	}

}
