package org.veiset.coffew8.coffeepi;

import java.util.Random;

public class CoffeeReader {
	
	private int interval = 400;
	private int step = 0;
//	>>> step = 3000
//	>>> for x in range(1,step): print((1/step*x)*2*pi)

	public CoffeeState readWeight() {
		// dummy method
		step += 1;
		long unixtime = System.currentTimeMillis() / 1000L;
		double cos = Math.cos(((1.0/interval*step)*2*Math.PI));

		int weight = (int)(cos*3000);
		Random r = new Random();
		if (step == interval) step = 0;
		return new CoffeeState(unixtime, Math.abs(weight+r.nextInt(100)));
	}

}
