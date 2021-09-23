package service;

import model.User;

public class LoginServiceImpl implements LoginService {

	@Override
	public boolean isValid(User user) {
		if(user.getUserName().equals("Admin") && user.getPassword().equals("password")) {
			return true;
		} else {
			return false;
		}
	}

}
