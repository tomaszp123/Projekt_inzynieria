package pl.spio.ecommerce.account;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "GROUPS", schema = "public")
public class Group implements Serializable {
	@Id
	@SequenceGenerator(name = "grpSeqGen", sequenceName = "GRP_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "grpSeqGen")
	@Column(name = "GRP_ID", unique = true, nullable = false)
	private long id;
	@Column(name = "GRP_GROUPNAME", length = 64, nullable = false)
	private String groupname;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
}
