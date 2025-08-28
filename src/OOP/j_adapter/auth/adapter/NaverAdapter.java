package OOP.j_adapter.auth.adapter;

import OOP.j_adapter.api.naver.NaverApi;
import OOP.j_adapter.api.naver.NaverProfile;
import OOP.j_adapter.auth.SocialLogin;
import OOP.j_adapter.user.UserProfile;

public class NaverAdapter implements SocialLogin {

	private final NaverApi api = new NaverApi();
	
	@Override
	public UserProfile login(String token) {
		NaverProfile profile = api.getProfile(token);
		return new UserProfile(profile.name(), profile.mail());
	}

}
