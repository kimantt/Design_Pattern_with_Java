package OOP.j_adapter.auth;

import OOP.j_adapter.auth.adapter.GoogleAdapter;
import OOP.j_adapter.auth.adapter.NaverAdapter;
import OOP.j_adapter.user.UserProfile;

public class AuthService {

	public void socialLogin(SocialLoginProvider provider, String token) {
		SocialLogin socialLogin = switch (provider) {
		case NAVER -> new NaverAdapter();
		case GOOGLE -> new GoogleAdapter();
		default -> throw new IllegalArgumentException("Unexpected value: " + provider);
		};
		
		UserProfile userProfile = socialLogin.login(token);
		System.out.println(userProfile.username() + " 로그인 로직 시작");
	}
	
}
