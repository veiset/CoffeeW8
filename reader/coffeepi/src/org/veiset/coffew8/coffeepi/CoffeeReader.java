package org.veiset.coffew8.coffeepi;

import com.phidgets.InterfaceKitPhidget;
import com.phidgets.PhidgetException;

public class CoffeeReader {

	static InterfaceKitPhidget ik;

	/**
	 * 
	 * @throws PhidgetException
	 */
	public CoffeeReader() throws PhidgetException {
		ik = new InterfaceKitPhidget();
		ik.openAny();
		ik.waitForAttachment();
		System.out.println("Found Phidget-interface kit with serial: " + ik.getSerialNumber());
	}

	/**
	 * 
	 * @return
	 * @throws PhidgetException
	 */
	public int readWeight() throws PhidgetException {
		return ik.getSensorRawValue(0);
	}

}
