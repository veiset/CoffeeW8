package org.veiset.coffew8.coffeepi;

public class CoffeeFilter {

	public static String path(String s) {
		if (s.length() > 1)
			return s.substring(1);
		else
			return "";
	}

	public static boolean unixtime(String s) {
		return s.matches("^[0-9]+$");
	}
	
	public static boolean unixtimeWithCallback(String s) {
		return s.matches("^[0-9]+&callback.*$");
	}

}
