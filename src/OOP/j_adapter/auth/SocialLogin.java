package OOP.j_adapter.auth;

import OOP.j_adapter.user.UserProfile;

public interface SocialLogin {
	UserProfile login(String token);
}
