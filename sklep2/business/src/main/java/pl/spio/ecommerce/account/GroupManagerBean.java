package pl.spio.ecommerce.account;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class GroupManagerBean implements GroupManager {
	@PersistenceContext(unitName = "postgres")
	private EntityManager em;

	@Override
	public Group getGroup(long groupId) {
		return em.find(Group.class, groupId);
	}

	@Override
	public void createGroup(Group group) {
		em.persist(group);
	}

	@Override
	public void modifyGroup(Group group) {
		Group current = getGroup(group.getId());
		current.setGroupname(group.getGroupname());
	}

	@Override
	public void deleteGroup(long groupId) {
		em.remove(getGroup(groupId));
	}
}
