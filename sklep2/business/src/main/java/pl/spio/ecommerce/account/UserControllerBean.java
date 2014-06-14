package pl.spio.ecommerce.account;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;



@Stateless
public class UserControllerBean implements UserController{
	
	@PersistenceContext(unitName = "postgres")
	private EntityManager manager;

	public User findUser(String username) {
		TypedQuery<User> query = manager.createNamedQuery(
				"User.findByUsername", User.class).setParameter("username",
				username);
		return query.getSingleResult();
	}

	@Override
	public List<User> getAllUsers() {
		TypedQuery<User> query = manager.createNamedQuery(
				"User.findAllUsers", User.class);
		return query.getResultList();
	}

	@Override
	public void removeUser(long userIdToRemove) {
		TypedQuery<User> query = manager.createNamedQuery(
				"User.deleteUser", User.class).setParameter("userIdToRemove",
				userIdToRemove);
		query.executeUpdate();
		
	}
}