package org.veiset.coffew8.coffeepi;

import org.junit.Before;
import org.junit.Test;

public class CoffeeManagerTest {
	
	private CoffeeManager cm;
	private final static int SIZE = 500;
	
	@Before
	public void setup() {
		cm = new CoffeeManager(SIZE, 1);
	}
	
	@Test
	public void coffeeManagerHasReader() {
		
	}

}
