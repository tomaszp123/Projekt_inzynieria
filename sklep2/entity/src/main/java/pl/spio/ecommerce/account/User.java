package pl.spio.ecommerce.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = "public")
public class User implements Serializable {
	@Id
	@SequenceGenerator(name = "usrSeqGen", sequenceName = "USR_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usrSeqGen")
	@Column(name = "USR_ID", unique = true, nullable = false)
	private long id;
	@Column(name = "USR_USERNAME", length = 255, unique = true, nullable = false)
	private String username;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USR_GROUP_ID", nullable = false)
	private Group group;
	@Column(name = "USR_ACTIVE", nullable = false)
	private Boolean active;
	@Column(name = "USR_FISRT_NAME", length = 31, nullable = true)
	private String firstName;
	@Column(name = "USR_LAST_NAME", length = 31, nullable = true)
	private String lastName;
	@Column(name = "USR_PASSWORD_HASH", length = 64, nullable = true)
	private String passwordHash;
}
