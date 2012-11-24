package org.veiset.coffew8.coffeepi;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.Server;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Options;
import org.restlet.resource.ServerResource;

public class CoffeeServer extends ServerResource {

	// Setting verbose to false will increase performance
	// as the server wont have to indent the JSON code
	private final static boolean verbose = true;
	private final static int interval = 1000; // mseconds
	private static CoffeeManager coffee;

	/**
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// SIZE = Math.pow(2,15), Interval = 1 second will allow us
		// to cache data for the last 8 hours.
		coffee = new CoffeeManager((int) Math.pow(2, 15), interval);
		// Create the HTTP server and listen on port 8182
		new Server(Protocol.HTTP, 8183, CoffeeServer.class).start();
	}

	/**
	 * 
	 * @return
	 */
	@Get("json")
	public JsonRepresentation request() {
		String path = CoffeeFilter.path(getReference().getPath());
		JSONArray json = new JSONArray();
		if (CoffeeFilter.unixtime(path)) {
			json = get(Long.parseLong(path));
		} else if (path == "") {
			json = get(0);
		} else if (CoffeeFilter.unixtimeWithCallback(path)) {
			json = get(5);
		}
		JsonRepresentation jsr = new JsonRepresentation(json);
		if (verbose) {
			jsr.setIndenting(true);
		}
		jsr.setMediaType(MediaType.APPLICATION_JSON);
		return jsr;
	}

	/**
	 * 
	 * @param entity
	 */
	@Options
	public void doOptions(Representation entity) {
		Form responseHeaders = (Form) getResponse().getAttributes().get(
				"org.restlet.http.headers");
		if (responseHeaders == null) {
			responseHeaders = new Form();
			getResponse().getAttributes().put("org.restlet.http.headers",
					responseHeaders);
		}
		responseHeaders.add("Access-Control-Allow-Origin", "*");
		responseHeaders.add("Access-Control-Allow-Methods", "GET, OPTIONS");
		responseHeaders.add("Access-Control-Allow-Headers",
				"origin, x-requested-with, content-type");
		responseHeaders.add("Access-Control-Allow-Credentials", "false");
		responseHeaders.add("Access-Control-Max-Age", "60");
	}

	/**
	 * 
	 * @param unixtime
	 * @return
	 */
	public JSONArray get(long unixtime) {
		return toJSON(coffee.get(unixtime));
	}

	/**
	 * 
	 * @param states
	 * @return
	 */
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
