package org.veiset.coffew8.coffeepi;
import static jaxt.framework.Assert.*;
/** 
 * These axioms are required for class {@link org.veiset.coffew8.coffeepi.RingBuffer} and its subclasses.
 * 
 * @note All axioms must be public static void methods
 */
public class RingBufferRequiredAxioms implements jaxt.framework.RequiredAxioms<org.veiset.coffew8.coffeepi.RingBuffer> {
	
	public static void addedElementIsCurrent(RingBuffer b, CoffeeState s){
		b.add(s);
		assertSame(s, b.current());
	}
	
	public static void addedElementsIsReversedInGetLast(RingBuffer buffer, CoffeeState[] states){
		for(CoffeeState s: states)
			buffer.add(s);
		
		CoffeeState[] last = buffer.getLast(states.length);
		for(int i = 0; i < last.length && i < buffer.size(); i++){
			assertSame(states[states.length-1-i], last[i]);
		}
	}
	
	public static void elementsMustBeTotallyOrdered(CoffeeState[] weights){
		assertTrue(weights.length > 0);

		RingBuffer buffer = new RingBuffer(weights.length);
		for(CoffeeState s: weights)
			buffer.add(s);
		
		CoffeeState[] lastStates = buffer.getLast(buffer.size());
		CoffeeState prev = lastStates[0];
		
		for(int i = 1; i < lastStates.length; i++){
			assertTrue(prev.compareTo(lastStates[i]) >= 0 );
			prev = lastStates[i];
		}
	}
}
