package org.veiset.coffew8.coffeepi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.phidgets.PhidgetException;

public class CoffeeReaderTest {

	private CoffeeReader reader;

	@Before
	public void setup() throws PhidgetException {
		reader = new CoffeeReader();
	}

	@Test
	public void readingSensorReturnCoffeeState() throws PhidgetException {
		assertEquals(reader.readWeight().getClass(), CoffeeState.class);
	}

	@Test
	public void readingSensorShouldNotTakeMoreThanOneSecond() throws PhidgetException {
		CoffeeState firstRead = reader.readWeight();
		assertTrue(reader.readWeight().getUnixtime() - firstRead.getUnixtime() <= 1);
	}

	@Test
	public void secondReadShouldNotHaveOlderDateThanFirstreadWeight() throws PhidgetException {
		CoffeeState firstRead = reader.readWeight();
		assertTrue(firstRead.getUnixtime() <= reader.readWeight().getUnixtime());
	}

}
