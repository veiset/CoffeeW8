package org.veiset.coffew8.coffeepi;
import static jaxt.framework.Assert.*;
/** 
 * These axioms are required for class {@link org.veiset.coffew8.coffeepi.RingBuffer} and its subclasses.
 * 
 * @note All axioms must be public static void methods
 */
public class RingBufferRequiredAxioms implements jaxt.framework.RequiredAxioms<org.veiset.coffew8.coffeepi.RingBuffer> {
	
	public static void addedElementIsCurrent(RingBuffer b, Integer s){
		b.add(s);
		assertSame(s, b.current().getWeight());
	}
	
	public static void addedElementsIsReversedInGetLast(RingBuffer buffer, Integer[] weights){
		for(Integer w: weights)
			buffer.add(w);
		
		CoffeeState[] last = buffer.getLast(weights.length);
		for(int i = 0; i < last.length && i < buffer.size(); i++){
			assertSame(weights[weights.length-1-i], last[i].getWeight());
		}
	}
	
	public static void elementsMustBeTotallyOrdered(Integer[] weights){
		assertTrue(weights.length > 0);

		RingBuffer buffer = new RingBuffer(weights.length);
		for(Integer w: weights)
			buffer.add(w);
		
		CoffeeState[] lastStates = buffer.getLast(buffer.size());
		CoffeeState prev = lastStates[0];
		
		for(int i = 1; i < lastStates.length; i++){
			assertTrue(prev.compareTo(lastStates[i]) >= 0 );
			prev = lastStates[i];
		}
	}
}
