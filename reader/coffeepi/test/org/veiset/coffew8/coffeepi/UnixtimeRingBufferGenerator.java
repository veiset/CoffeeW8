package org.veiset.coffew8.coffeepi;

import java.lang.Object;
import org.veiset.coffew8.coffeepi.CoffeeState;
import org.veiset.coffew8.coffeepi.UnixtimeRingBuffer;
/**
 * This class was automatically generated from all axioms pertaining to the class UnixtimeRingBuffer, by JAxT. It may be modified.  {@link UnixtimeRingBuffer}
 */
public class UnixtimeRingBufferGenerator {
	/**
	 * TODO 
	 */
	public static org.veiset.coffew8.coffeepi.UnixtimeRingBuffer[] createUnixtimeRingBufferTestSet(
			int loopDepth) {
		org.veiset.coffew8.coffeepi.UnixtimeRingBuffer x[] = new UnixtimeRingBuffer[20];
		for (int i = 0; i < x.length; i++) {
			x[i] = new UnixtimeRingBuffer(i+1);
		}
		return x;
	}

	/**
	 * TODO 
	 */
	public static org.veiset.coffew8.coffeepi.CoffeeState[][] createACoffeeStateTestSet(
			int loopDepth) {
		org.veiset.coffew8.coffeepi.CoffeeState[] x[] = new CoffeeState[20][20];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++)
				x[i][j] = new CoffeeState(i + j);
		}
		return x;
	}

	/**
	 * TODO 
	 */
	public static org.veiset.coffew8.coffeepi.CoffeeState[] createCoffeeStateTestSet(
			int loopDepth) {
		org.veiset.coffew8.coffeepi.CoffeeState x[] = new CoffeeState[20];
		for (int i = 0; i < x.length; i++) {
			x[i] = new CoffeeState(i);
		}
		return x;
	}

	/**
	 * TODO 
	 */
	public static java.lang.Object[] createObjectTestSet(int loopDepth) {
		java.lang.Object x[] = { new Object() };
		return x;
	}

	/**
	 * TODO 
	 */
	public static int[] createIntTestSet(int loopDepth) {
		int x[] = { 1, 2, 255, 100, 70, 20, 19 };
		return x;
	}
}
