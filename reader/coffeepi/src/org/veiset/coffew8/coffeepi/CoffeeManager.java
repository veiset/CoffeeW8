package org.veiset.coffew8.coffeepi;

import java.util.Timer;
import java.util.TimerTask;



import com.phidgets.PhidgetException;

public class CoffeeManager extends TimerTask {

	private RingBuffer unixRing;
	private CoffeeReader reader;

	public CoffeeManager(int bufferSize, int interval) {
		setUnixRing(new RingBuffer(bufferSize));
		try {
			setReader(new CoffeeReader());
		} catch (PhidgetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, 0, (int) interval * 1000);
	}

	public CoffeeState[] get(long unixtime) {
		return getUnixRing().getElementsAfter(new CoffeeState(unixtime, 0));
	}

	public CoffeeState mostRecent() {
		return unixRing.current();
	}

	public void read() {
		try {
			getUnixRing().add(getReader().readWeight());
		} catch (PhidgetException e) {
			e.printStackTrace();
		}

	}

	public RingBuffer getUnixRing() {
		return unixRing;
	}

	public void setUnixRing(RingBuffer unixRing) {
		this.unixRing = unixRing;
	}

	public CoffeeReader getReader() {
		return reader;
	}

	public void setReader(CoffeeReader reader) {
		this.reader = reader;
	}

	@Override
	public void run() {
		read();
	}

}
