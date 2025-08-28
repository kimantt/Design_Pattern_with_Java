package OOP.j_adapter.api.naver;

public class NaverApi {

	public NaverProfile getProfile(String token) {
		return new NaverProfile("이몽룡", "aaa@naver.com");
	}
	
}
