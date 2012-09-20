package org.veiset.coffew8.coffeepi;

import java.util.Timer;
import java.util.TimerTask;

public class CoffeeManager extends TimerTask {

	private UnixtimeRingBuffer unixRing;
	private CoffeeReader reader;

	public CoffeeManager(int bufferSize, int interval) {
		setUnixRing(new UnixtimeRingBuffer(bufferSize, interval));
		setReader(new CoffeeReader());
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this, 0, (int) interval * 1000);
	}

	public CoffeeState[] get(long unixtime) {
		return getUnixRing().getDataSince(unixtime);
	}
	
	public CoffeeState mostRecent() {
		return unixRing.current();
	}

	public void read() {
		CoffeeState cs = getReader().readWeight();
		getUnixRing().add(cs);
	}

	public UnixtimeRingBuffer getUnixRing() {
		return unixRing;
	}

	public void setUnixRing(UnixtimeRingBuffer unixRing) {
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
