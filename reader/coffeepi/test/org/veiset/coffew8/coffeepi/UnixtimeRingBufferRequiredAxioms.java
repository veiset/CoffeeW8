package org.veiset.coffew8.coffeepi;
import static jaxt.framework.Assert.*;
/** 
 * These axioms are required for class {@link org.veiset.coffew8.coffeepi.UnixtimeRingBuffer} and its subclasses.
 * 
 * @note All axioms must be public static void methods
 */
public class UnixtimeRingBufferRequiredAxioms implements jaxt.framework.RequiredAxioms<org.veiset.coffew8.coffeepi.UnixtimeRingBuffer> {
	
	public static void addedElementIsCurrent(UnixtimeRingBuffer b, CoffeeState s){
		b.add(s);
		assertSame(s, b.current());
	}
	
	public static void addedElementsIsInGetLast(UnixtimeRingBuffer buffer, CoffeeState[] states){
		for(CoffeeState s: states)
			buffer.add(s);
		
		CoffeeState[] last = buffer.getLast(states.length);
		for(int i = 0; i < last.length && i < buffer.size(); i++){
			assertSame(states[states.length-1-i], last[i]);
		}
	}
	
}
