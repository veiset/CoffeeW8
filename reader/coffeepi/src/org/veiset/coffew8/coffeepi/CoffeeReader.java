package org.veiset.coffew8.coffeepi;

import java.util.Random;

public class CoffeeReader {

	public CoffeeState readWeight() {
		// dummy method
		long unixtime = System.currentTimeMillis() / 1000L;
		Random r = new Random();
		return new CoffeeState(unixtime, r.nextInt(3000));
	}

}
