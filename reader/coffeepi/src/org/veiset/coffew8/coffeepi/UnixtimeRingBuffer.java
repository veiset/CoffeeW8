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
		assert interval > 0 : "precondition: interval="+interval;
		assert size > 0 : "precondition: size="+size;
		
		this.interval = interval;
		stack = new CoffeeState[size];
		for (int i = 0; i < size; i++) {
			stack[i] = new CoffeeState(0, 0);
		}
		position = 0;
		
		assert dataInvariant() : "postcondition: invariant";
		assert stack.length == size : "postcondition: stack.length=" +stack.length + ", size="+size;
		assert this.interval == interval : "postcondition: this.interval="+this.interval + ",interval="+interval;
	}

	/**
	 * 
	 * @param bufferSize
	 */
	public UnixtimeRingBuffer(int bufferSize) {
		assert bufferSize > 0 : "precondition: size="+bufferSize;
		
		interval = 1; // default interval if none is given
		stack = new CoffeeState[bufferSize];
		for (int i = 0; i < bufferSize; i++) {
			stack[i] = new CoffeeState(0, 0);
		}
		position = 0;

		assert dataInvariant() : "postcondition: invariant";
		assert interval > 0 : "postcondition: interval="+interval;
		assert stack.length == bufferSize : "postcondition: stack.length=" +stack.length + ", size="+bufferSize;
	}

	public boolean dataInvariant(){
		//check for null-entries
		for(CoffeeState s: stack){
			if(s == null)
				return false;
		}
		
		return position >= 0 && position < size();
	}
	
	/**
	 * 
	 * @return current expected step length in seconds
	 */
	public int getInterval() {
		assert dataInvariant() : "pre-/postcondition: invariant";
		return interval;
	}

	/**
	 * 
	 * @return number of elements in the ring buffer
	 */
	public int size() {
		assert dataInvariant() : "pre-/postcondition: invariant";
		return stack.length;
	}

	/**
	 * 
	 * @return current position to newest added element
	 */
	public int getPosition() {
		assert dataInvariant() : "pre-/postcondition: invariant";
		return position;
	}

	/**
	 * 
	 * @param state
	 *            new state to take place of the oldest state in the ring buffer
	 */
	public void add(CoffeeState state) {
		assert dataInvariant() : "precondition: invariant";
		assert state != null : "precondition: state="+state;
		
		increasePosition();
		stack[position] = state;
		
		assert dataInvariant() : "postcondition: invariant";
	}

	private void increasePosition() {
		assert dataInvariant() : "precondition: invariant";
		position += 1;
		if (position == size()) {
			position = 0;
		}
		assert dataInvariant() : "postcondition: invariant";
	}

	/**
	 * 
	 * @return most recent state
	 */
	public CoffeeState current() {
		assert dataInvariant() : "pre-/postcondition: invariant";
		return stack[position];
	}

	/**
	 * 
	 * @param id
	 *            element in the list, makes little sense to use this alone
	 * @return state of given id
	 */
	public CoffeeState get(int id) {
		assert dataInvariant() : "precondition: invariant";
		assert id >= 0 && id < size() : "precondition: id="+id;
		
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
		assert dataInvariant() : "precondition: invariant";
		
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
	 * @return id of last relevant data (or -1 if all?)
	 */
	public int idNewerThanUnix(long unixtime) {
		assert dataInvariant() : "precondition: invariant";
		
		int id;
		for (int i = 0; i < size(); i++) {
			if (position - i >= 0) {
				id = position - i;
			} else {
				id = (size() - i) + position;
			}
			if (get(id).getUnixtime() < unixtime) {
				assert id >= 0 && id < size() : "postcondition: id="+id;
				assert dataInvariant() : "postcondition: invariant";
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
		assert dataInvariant() : "precondition: invariant";
		
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
		assert dataInvariant() : "pre-/postcondition: invariant";
		return get(position);
	}

}
