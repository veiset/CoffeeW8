package org.veiset.coffew8.coffeepi;

public class UnixtimeRingBuffer {

	private final CoffeeState[] stack;
	private int position;
	private int interval = 3;

	/**
	 * 
	 * @param size
	 *            total elements in ring buffer
	 * @param interval
	 *            unixtime step in seconds
	 */
	public UnixtimeRingBuffer(int size, int interval) {
		this.interval = interval;
		stack = new CoffeeState[size];
		for (int i = 0; i < size; i++) {
			stack[i] = new CoffeeState(0, 0);
		}
		position = 0;
	}

	/**
	 * 
	 * @param bufferSize
	 */
	public UnixtimeRingBuffer(int bufferSize) {
		interval = 1; // default interval if none is given
		stack = new CoffeeState[bufferSize];
		for (int i = 0; i < bufferSize; i++) {
			stack[i] = new CoffeeState(0, 0);
		}
		position = 0;
	}

	public boolean dataInvariant(){
		return position >= 0 && position < size();
	}
	
	/**
	 * 
	 * @return current expected step length in seconds
	 */
	public int getInterval() {
		return interval;
	}

	/**
	 * 
	 * @return number of elements in the ring buffer
	 */
	public int size() {
		return stack.length;
	}

	/**
	 * 
	 * @return current position to newest added element
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * 
	 * @param state
	 *            new state to take place of the oldest state in the ring buffer
	 */
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

	/**
	 * 
	 * @return most recent state
	 */
	public CoffeeState current() {
		return stack[position];
	}

	/**
	 * 
	 * @param id
	 *            element in the list, makes little sense to use this alone
	 * @return state of given id
	 */
	public CoffeeState get(int id) {
		try {
			return stack[id];
		} catch (ArrayIndexOutOfBoundsException e) {
			return null;
		}
	}

	/**
	 * 
	 * @param unixtime
	 * 
	 * @return all data newer than given unixtime
	 */
	public CoffeeState[] getDataSince(long unixtime) {
		int lastId = idNewerThanUnix(unixtime);
		if (lastId == position)
			return null;
		else if (lastId == -1)
			return getLast(size());
		else
			return getLast(Math.abs(position - lastId));
	}

	/**
	 * 
	 * @param unixtime
	 *            Last time checked for data
	 * @return id of last relevant data or -1 if not found 
	 */
	public int idNewerThanUnix(long unixtime) {
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

	/**
	 * 
	 * @param number
	 * @return
	 */
	public CoffeeState[] getLast(int number) {
		if (number <= 0) {
			return null;
		}
		if (number > size())
			number = size();

		assert number > 0 && number <= size() : "number="+number;
		
		CoffeeState[] range = new CoffeeState[number];

		int id;
		for (int i = 0; i < number; i++) {
			if (position - i >= 0) {
				id = position - i;
			} else {
				id = (size() - i) + position;
			}
			
			assert id >= 0 && id < size() : "id="+id;
			assert i >= 0 && i < range.length : "i="+i;
			
			range[i] = get(id);
		}
		return range;
	}

	public CoffeeState getLast() {
		return get(position);
	}

}
