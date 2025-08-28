package OOP.j_adapter.api.google;

public class GoogleApi {

	public GoogleProfile getProfile(String token) {
		return new GoogleProfile("홍길동", "aaa@gmail.com");
	}
	
}
