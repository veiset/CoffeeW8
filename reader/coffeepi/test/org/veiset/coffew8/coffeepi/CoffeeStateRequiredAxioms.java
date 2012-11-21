package org.veiset.coffew8.coffeepi;
import static jaxt.framework.Assert.*;

import org.veiset.coffew8.coffeepi.CoffeeState;
/** 
 * These axioms are required for class {@link org.veiset.coffew8.coffeepi.CoffeeState} and its subclasses.
 * 
 * @note All axioms must be public static void methods
 */
public class CoffeeStateRequiredAxioms implements jaxt.framework.RequiredAxioms<org.veiset.coffew8.coffeepi.CoffeeState> {
	
	public static void transitiveAxiom(CoffeeState a, CoffeeState b, CoffeeState c){
		if(a.newerThan(b) && b.newerThan(c))
			assertTrue(a.newerThan(c));
	}
	
	public static void irreflexiveNewerThanAxiom(CoffeeState a) {
		assertFalse(a.newerThan(a));
	}

	public static void asymmetricNewerThanAxiom(CoffeeState a, CoffeeState b){
		if(a.newerThan(b))
			assertFalse(b.newerThan(a));
	}
	
	public static void shouldRelateIncreasingAxiom(){
		CoffeeState a = new CoffeeState(0);
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			fail("unable to sleep");
		}
		CoffeeState b = new CoffeeState(1);
		assertTrue(b.newerThan(a));
	}
}
