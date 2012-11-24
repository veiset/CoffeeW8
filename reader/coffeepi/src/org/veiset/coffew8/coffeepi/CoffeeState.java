package org.veiset.coffew8.coffeepi;

public class CoffeeState implements Comparable<CoffeeState>{

	private final long unixtimeMilli;
	private Integer weight;

	public CoffeeState(long unixtime, Integer weight) {
		this.unixtimeMilli = unixtime;
		this.setWeight(weight);
	}

	public CoffeeState(Integer weight) {
		this.unixtimeMilli = System.currentTimeMillis();
		setWeight(weight);
	}

	public long getUnixtime() {
		return unixtimeMilli;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String toString(){
		return unixtimeMilli + " : " + weight;
	}
	
	public boolean newerThan(CoffeeState coffeeState) {
		return this.compareTo(coffeeState) == 1 ? true : false;
	}

	public int compareTo(CoffeeState coffeeState) {
		if(unixtimeMilli < coffeeState.unixtimeMilli)
			return -1;

		if(unixtimeMilli == coffeeState.unixtimeMilli)
			return 0;

		return 1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ (int) (unixtimeMilli ^ (unixtimeMilli >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CoffeeState other = (CoffeeState) obj;
		if (unixtimeMilli != other.unixtimeMilli)
			return false;
		return true;
	}
	
}
