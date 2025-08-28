package OOP.j_adapter;

import OOP.j_adapter.auth.AuthService;
import OOP.j_adapter.user.UserController;

public class Run {

	public static void main(String[] args) {
		UserController userController = new UserController(new AuthService());
		String response = userController.naverLogin();
		System.out.println(response);
	}

}
