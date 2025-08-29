package musiccoordinatorproject.infra.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonProvider {

	private static Gson INSTANCE;
	
	static {
		INSTANCE = new GsonBuilder()
				.setPrettyPrinting()
				.create();
	}
	
	public static Gson gson() {
		return INSTANCE;
	}
	
}
