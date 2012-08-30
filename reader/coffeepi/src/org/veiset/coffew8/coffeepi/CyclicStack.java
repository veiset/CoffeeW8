package org.veiset.coffew8.coffeepi;

public class CyclicStack {

	private CoffeeState[] stack;
	private int position;
	private int interval = 3;

	public CyclicStack(int size, int interval) {
		this.interval = interval;
		stack = new CoffeeState[size];
		position = 0;
	}

	public int getInterval() {
		return interval;
	}

	public int size() {
		return stack.length;
	}

	public int getPosition() {
		return position;
	}

	public void add(CoffeeState state) {
		increasePosition();
		stack[position] = state;

	}

	private void increasePosition() {
		position += 1;
		if (position == size()) {
			position = 0;
		}
	}

	public CoffeeState current(int i) {
		return stack[position];
	}

	public CoffeeState get(int id) {
		try {
			return stack[id];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	public int resolve(long unixtime) {
		int id;
		for (int i = 0; i < size(); i++) {
			if (position - i >= 0) {
				id = position - i;
			} else {
				id = (size() - i) + position;
			}
			if (get(id).getUnixtime() < unixtime) {
				return id;
			}
		}
		return -1;
	}

	public CoffeeState[] getLast(int size) {
		if (size <= 0) {
			return null;
		}
		if (size > size())
			size = size();

		CoffeeState[] range = new CoffeeState[size];

		int id;
		for (int i = 0; i < size; i++) {
			if (position - i >= 0) {
				id = position - i;
			} else {
				id = (size() - i) + position;
			}
			range[i] = get(id);
		}
		return range;
	}

	@Override
	public String toString() {
		int id;
		String text = "";
		for (int i = 1; i < size() + 1; ++i) {
			if (position - i >= 0) {
				id = position - i;
			} else {
				id = (size() - i) + position;
			}
			if (id == position) {
				text += "->  " + id + " - " + get(id).getUnixtime() + "\n";
			} else {
				text += "    " + id + " - " + get(id).getUnixtime() + "\n";
			}
		}
		return text;
	}

}
