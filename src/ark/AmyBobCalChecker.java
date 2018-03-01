//CSC 442 Project 2
//Avi Webberman, Rebecca Van Dyke, Karan Vombatkere
//WumpusWorldChecker

package ark;

import pl.core.Symbol;

public class AmyBobCalChecker implements TTModelChecking{

	public static void main(String[] args) {
		//Part A
		AmyBobCalPartAKB kbA = new AmyBobCalPartAKB();
		
		Symbol aA = kbA.intern("Amy");
		Symbol bA = kbA.intern("Bob");
		Symbol cA = kbA.intern("Cal");
		
		System.out.println("Part A truthfulness:");
		System.out.println("Amy: " + TTModelChecking.ttEntails(kbA, aA));
		System.out.println("Bob: " + TTModelChecking.ttEntails(kbA, bA));
		System.out.println("Cal: " + TTModelChecking.ttEntails(kbA, cA));
		
		//Part B
		AmyBobCalPartBKB kbB = new AmyBobCalPartBKB();
		
		Symbol aB = kbB.intern("Amy");
		Symbol bB = kbB.intern("Bob");
		Symbol cB = kbB.intern("Cal");
		
		System.out.println("Part B truthfulness:");
		System.out.println("Amy: " + TTModelChecking.ttEntails(kbB, aB));
		System.out.println("Bob: " + TTModelChecking.ttEntails(kbB, bB));
		System.out.println("Cal: " + TTModelChecking.ttEntails(kbB, cB));
		
		
	}
}
