package OOP.j_adapter.auth.adapter;

import OOP.j_adapter.api.google.GoogleApi;
import OOP.j_adapter.api.google.GoogleProfile;
import OOP.j_adapter.auth.SocialLogin;
import OOP.j_adapter.user.UserProfile;

public class GoogleAdapter implements SocialLogin {

	private final GoogleApi api = new GoogleApi();
	
	@Override
	public UserProfile login(String token) {
		GoogleProfile profile = api.getProfile(token);
		return new UserProfile(profile.username(), profile.email());
	}

}
