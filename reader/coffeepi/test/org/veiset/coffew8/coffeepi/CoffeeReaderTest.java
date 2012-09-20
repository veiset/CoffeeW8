package org.veiset.coffew8.coffeepi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CoffeeReaderTest {

	private CoffeeReader reader;

	@Before
	public void setup() {
		reader = new CoffeeReader();
	}

	@Test
	public void readingSensorReturnCoffeeState() {
		assertEquals(reader.readWeight().getClass(), CoffeeState.class);
	}

	@Test
	public void readingSensorShouldNotTakeMoreThanOneSecond() {
		CoffeeState firstRead = reader.readWeight();
		assertTrue(reader.readWeight().getUnixtime() - firstRead.getUnixtime() <= 1);
	}

	@Test
	public void secondReadShouldNotHaveOlderDateThanFirstreadWeight() {
		CoffeeState firstRead = reader.readWeight();
		assertTrue(firstRead.getUnixtime() <= reader.readWeight().getUnixtime());
	}

}
