package org.veiset.coffew8.coffeepi;

import java.lang.Object;
import java.lang.Integer;
import org.veiset.coffew8.coffeepi.RingBuffer;
/**
 * This class was automatically generated from all axioms pertaining to the class RingBuffer, by JAxT. It may be modified.    {@link RingBuffer}
 */
public class RingBufferGenerator {
	/**
	 * TODO 
	 */
	public static org.veiset.coffew8.coffeepi.RingBuffer[] createRingBufferTestSet(
			int loopDepth) {
		org.veiset.coffew8.coffeepi.RingBuffer x[] = new RingBuffer[20];
		for (int i = 0; i < x.length; i++) {
			x[i] = new RingBuffer(i + 1);
		}
		return x;
	}

	/**
	 * TODO 
	 */
	public static Integer[][] createAIntegerTestSet(int loopDepth) {
		Integer[] x[] = new Integer[20][20];
		for (int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++)
				x[i][j] = i + j;
		}
		return x;
	}

	/**
	 * TODO 
	 */
	public static Integer[] createIntegerTestSet(int loopDepth) {
		Integer x[] = new Integer[20];
		for (int i = 0; i < x.length; i++) {
			x[i] = i;
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
