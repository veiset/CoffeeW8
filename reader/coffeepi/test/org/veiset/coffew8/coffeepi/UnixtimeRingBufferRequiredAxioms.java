package org.veiset.coffew8.coffeepi;
import static jaxt.framework.Assert.*;

import java.util.Random;


/** 
 * These axioms are required for class {@link org.veiset.coffew8.coffeepi.UnixtimeRingBuffer} and its subclasses.
 * 
 * @note All axioms must be public static void methods
 */
public class UnixtimeRingBufferRequiredAxioms implements jaxt.framework.RequiredAxioms<org.veiset.coffew8.coffeepi.UnixtimeRingBuffer> {
	
	public static void addedElementIsCurrent(UnixtimeRingBuffer b, Integer s){
		b.add(s);
		assertSame(s, b.current().getWeight());
	}
	
	public static void addedElementsIsReversedInGetLast(UnixtimeRingBuffer buffer, Integer[] weights){
		for(Integer w: weights)
			buffer.add(w);
		
		CoffeeState[] last = buffer.getLast(weights.length);
		for(int i = 0; i < last.length && i < buffer.size(); i++){
			assertSame(weights[weights.length-1-i], last[i].getWeight());
		}
	}
	
	public static void elementsMustBeTotallyOrdered(Integer[] weights){
		assertTrue(weights.length > 0);

		Random rand = new Random();
		UnixtimeRingBuffer buffer = new UnixtimeRingBuffer(weights.length);
		for(Integer w: weights){
			if(rand.nextBoolean()){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					fail("failed to sleep");
				}
			}
			buffer.add(w);
		}
		
		CoffeeState[] lastStates = buffer.getLast(buffer.size());
		CoffeeState prev = lastStates[0];
		
		for(int i = 1; i < lastStates.length; i++){
			assertTrue(prev.getUnixtime()+" >= "+lastStates[i].getUnixtime(), prev.newerThan(lastStates[i])  || prev.equals(lastStates[i]));
			prev = lastStates[i];
		}
	}
}
