package musiccoordinatorproject.domain.song;

import java.util.Map;

public record Song(
		String name,
		String artist,
		String reason
		) {

	public static Song fromMap(Map<String, Object> map) {
		return new Song((String)map.get("name"), (String)map.get("artist"), (String)map.get("reason"));
	}
	
}
