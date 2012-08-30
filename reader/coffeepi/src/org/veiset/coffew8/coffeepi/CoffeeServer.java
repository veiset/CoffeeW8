package org.veiset.coffew8.coffeepi;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.restlet.Server;
import org.restlet.data.MediaType;
import org.restlet.data.Protocol;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.Variant;
import org.restlet.resource.Get;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

public class CoffeeServer extends ServerResource {

	private CyclicStack stack;

	public static void main(String[] args) throws Exception {
		// Create the HTTP server and listen on port 8182
		new Server(Protocol.HTTP, 8183, CoffeeServer.class).start();
	}

	@Get
	public JsonRepresentation request() {
		return new JsonRepresentation(toJSON());
	}

	public Representation represent(Variant variant) throws ResourceException {
		Representation result = null;
		if (variant.getMediaType().equals(MediaType.APPLICATION_JSON)) {
			result = new JsonRepresentation(toJSON());
		}
		return result;
	}

	public JSONArray json() {
		return toJSON();
	}

	public JSONArray toJSON() {
		int unix = (int) (System.currentTimeMillis() / 1000L)-100;
		try {
			Random r = new Random();
			JSONArray list = new JSONArray();
			for (int i = 0; i < 100; i++) {
				JSONObject entry = new JSONObject();
				entry.put("time", unix+i);
				entry.put("weight", r.nextInt(1000));
				list.put(entry);
			}
			return list;
		} catch (Exception e) {
			return null;
		}
	}
}
