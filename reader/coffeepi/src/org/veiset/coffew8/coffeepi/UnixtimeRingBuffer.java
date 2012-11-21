package org.veiset.coffew8.coffeepi;

public class UnixtimeRingBuffer {

	private final CoffeeState[] buffer;
	private int position;
	private int interval = 3;

	/**
	 * 
	 * @param bufferSize
	 *            total elements in ring buffer
	 * @param interval
	 *            unixtime step in seconds
	 */
	public UnixtimeRingBuffer(int bufferSize, int interval) {
		assert interval > 0 : "precondition: interval="+interval;
		assert bufferSize > 0 : "precondition: size="+bufferSize;
		
		this.interval = interval;
		buffer = new CoffeeState[bufferSize];
		for (int i = 0; i < bufferSize; i++) {
			buffer[i] = new CoffeeState(0, 0);
		}
		position = 0;
		
		assert dataInvariant() : "postcondition: invariant";
		assert buffer.length == bufferSize : "postcondition: stack.length=" +buffer.length + ", size="+bufferSize;
		assert this.interval == interval : "postcondition: this.interval="+this.interval + ",interval="+interval;
	}

	/**
	 * 
	 * @param bufferSize
	 */
	public UnixtimeRingBuffer(int bufferSize) {
		assert bufferSize > 0 : "precondition: size="+bufferSize;
		
		interval = 1; // default interval if none is given
		buffer = new CoffeeState[bufferSize];
		for (int i = 0; i < bufferSize; i++) {
			buffer[i] = new CoffeeState(0, 0);
		}
		position = 0;

		assert dataInvariant() : "postcondition: invariant";
		assert interval > 0 : "postcondition: interval="+interval;
		assert buffer.length == bufferSize : "postcondition: stack.length=" +buffer.length + ", size="+bufferSize;
	}

	public boolean dataInvariant(){
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
		return buffer.length;
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
		buffer[position] = state;
		
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
		return get(position);
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
			return buffer[id];
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
		
		int number = getNumberOfElementsNewerThan(unixtime);
		
		assert number >= 0 && number < size() : "number="+number;
		assert dataInvariant() : "postcondition: invariant";
		return getLast(number);
	}

	/**
	 * 
	 * @param unixtime
	 *            Last time checked for data
	 * @return id of last relevant data (or -1 if all?)
	 */
	//getIdOfOldestNewerThanUnixTime
	public int getNumberOfElementsNewerThan(long unixtime) {
		assert dataInvariant() : "precondition: invariant";
		
		int id;
		int count = 0;
		for (int i = 0; i < size(); i++) {
			if (position - i >= 0) {
				id = position - i;
			} else {
				id = (size() - i) + position;
			}
			
			assert id >= 0 && id < size() : "id="+id;
			
			if (get(id).getUnixtime() < unixtime) {
				
				assert count >= 0 && count < size() : "postcondition: count="+count;
				assert dataInvariant() : "postcondition: invariant";
				return count;
			}
			count++;
		}
		assert dataInvariant() : "postcondition: invariant"; 
		return  size()-1;
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

}
