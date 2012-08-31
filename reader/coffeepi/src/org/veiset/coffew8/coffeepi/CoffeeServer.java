package org.veiset.coffew8.coffeepi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class CoffeeServer extends ServerResource {

	// Setting verbose to false will increase performance
	// as the server wont have to ident the JSON code
	private final static boolean verbose = true;
	private static CoffeeManager coffee;

	public static void main(String[] args) throws Exception {
		// SIZE = Math.pow(2,15), Interval = 1 second will allow us
		// to cache data for the last 8 hours.
		coffee = new CoffeeManager((int) Math.pow(2, 15), 1);
		// Create the HTTP server and listen on port 8182
		new Server(Protocol.HTTP, 8183, CoffeeServer.class).start();
	}

	@Get("XML")
	public JsonRepresentation request() {
		String path = CoffeeFilter.path(getReference().getPath());
		JSONArray json = new JSONArray();
		if (CoffeeFilter.unixtime(path)) {
			json = get(Long.parseLong(path));
		} else if (path == "") {
			json = get(0);
		}
		JsonRepresentation jsr = new JsonRepresentation(json);
		if (verbose) {
			jsr.setIndenting(true);
		}
		return jsr;
	}

	public JSONArray get(long unixtime) {
		return toJSON(coffee.get(unixtime));
	}

	public JSONArray toJSON(CoffeeState[] states) {
		try {
			JSONArray list = new JSONArray();
			for (CoffeeState cs : states) {
				JSONObject entry = new JSONObject();
				if (cs.getUnixtime() > 0) {
					entry.put("time", cs.getUnixtime());
					entry.put("weight", cs.getWeight());
					list.put(entry);
				}
			}
			return list;
		} catch (Exception e) {
			return new JSONArray();
		}
	}
}
