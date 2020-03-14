package ph.outlook.amperca.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name="PARTY_LIST")
public class PartyList {

	@Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "NAME", unique = true)
    @Size(min=3, max = 100, message = "field length must be in between 3 to 100 characters")
	private String name;
	
	@Column(name = "CREATED", insertable = false)
    private Timestamp created;

	@Column(name = "LAST_UPDATED", insertable = false)
    private Timestamp lastUpdated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	public Timestamp getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "PartyList [id=" + id + ", name=" + name + "]";
	}
}
