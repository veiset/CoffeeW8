package org.veiset.coffew8.coffeepi;

public class CoffeeState implements Comparable<CoffeeState>{

	private long unixtime;
	private int weight;

	public CoffeeState(long unixtime, int weight) {
		this.setUnixtime(unixtime);
		this.setWeight(weight);
	}

	public CoffeeState(int weight) {
		setUnixtime(System.currentTimeMillis() / 1000L);
		setWeight(weight);
	}

	public long getUnixtime() {
		return unixtime;
	}

	public void setUnixtime(long unixtime) {
		this.unixtime = unixtime;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String toString(){
		return unixtime + " : " + weight;
	}

	public int compareTo(CoffeeState coffeeState) {
		if(unixtime < coffeeState.getUnixtime())
			return -1;

		if(unixtime == coffeeState.unixtime)
			return 0;
			
		return 1;
	}
}
