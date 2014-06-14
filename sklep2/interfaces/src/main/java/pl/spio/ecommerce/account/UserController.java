package pl.spio.ecommerce.account;


import java.util.List;

import javax.ejb.Local;
@Local
public interface UserController {

	 User findUser(String username);

	List<User> getAllUsers();

	void removeUser(long userIdToRemove);
	}
