package org.veiset.coffew8.coffeepi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.veiset.coffew8.coffeepi.CyclicStack;

public class CyclicStackTest {

	final CoffeeState DATA = new CoffeeState(100000, 50);
	// Should be >= 2, as you cannot test correct pointer movement with only one
	// element.
	final int SIZE = 5;
	final int INTERVAL = 3;
	private CyclicStack stack;

	@Before
	public void setup() {
		stack = new CyclicStack(SIZE, INTERVAL);
	}

	@Test
	public void newStackIsGivenSize() {
		assertEquals(stack.size(), SIZE);
	}

	@Test
	public void pointerIsNullAtNewStack() {
		assertEquals(stack.getPosition(), 0);
	}

	@Test
	public void pointerIsIncreasedByOneWhenNotAtEndOfStack() {
		int pointer = stack.getPosition();
		stack.add(DATA);
		assertEquals(stack.getPosition(), pointer + 1);
	}

	@Test
	public void pointerCyclesTheStack() {
		for (int i = 0; i < SIZE; i++) {
			stack.add(DATA);
		}
		assertEquals(stack.getPosition(), 0);
	}

	@Test
	public void getEmptyElementIsNull() {
		assertNull(stack.get(0));
	}

	@Test
	public void addedElementIsAdded() {
		stack.add(DATA);
		assertEquals(stack.get(stack.getPosition()), DATA);
	}

	@Test
	public void getRangeNtoNIsNull() {
		assertNull(stack.getLast(0));
	}

	@Test
	public void lastElementsLargerThanSizeShouldReturnAll() {
		assertEquals(stack.getLast(SIZE + 1).length, SIZE);
	}

	@Test
	public void getLastShouldReturnNElements() {
		assertEquals(stack.getLast(3).length, 3);
	}

	@Test
	public void getLastShouldContainElementAtCurrentPos() {
		stack.add(new CoffeeState(5, 50));
		assertEquals(stack.getLast(1)[0], stack.get(stack.getPosition()));
	}

	@Test
	public void resolveUnixtimeZeroIsMinusOne() {
		stack.add(new CoffeeState(5, 50));
		stack.add(new CoffeeState(11, 50));
		stack.add(new CoffeeState(14, 50));
		stack.add(new CoffeeState(17, 50));
		stack.add(new CoffeeState(19, 50));
		stack.add(new CoffeeState(23, 50));
		stack.add(new CoffeeState(42, 50));
		stack.add(new CoffeeState(55, 50));
		assertEquals(stack.resolve(0), -1);
	}

}