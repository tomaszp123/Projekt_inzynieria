package pl.spio.ecommerce.account;


import javax.ejb.Local;
@Local
public interface UserController {

	 User findUser(String username);
	}
