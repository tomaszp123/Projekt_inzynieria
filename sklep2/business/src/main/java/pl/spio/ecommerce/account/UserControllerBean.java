package pl.spio.ecommerce.account;
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
}