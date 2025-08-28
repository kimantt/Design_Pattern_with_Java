package OOP.j_adapter.user;

import OOP.j_adapter.auth.AuthService;
import OOP.j_adapter.auth.SocialLoginProvider;

public class UserController {

	private final AuthService userService;
	
	public UserController(AuthService userService) {
		this.userService = userService;
	}

	public String googleLogin() {
		userService.socialLogin(SocialLoginProvider.GOOGLE, "abc");
		return "200 OK";
	}
	
	public String naverLogin() {
		userService.socialLogin(SocialLoginProvider.NAVER, "abc");
		return "200 OK";
	}
}
