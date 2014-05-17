package pl.spio.ecommerce.account;

import javax.ejb.Local;

@Local
public interface GroupManager {
	Group getGroup(long groupId);

	void createGroup(Group group);

	void modifyGroup(Group group);

	void deleteGroup(long groupId);
}