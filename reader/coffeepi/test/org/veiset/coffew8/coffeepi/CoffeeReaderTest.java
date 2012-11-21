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

}
