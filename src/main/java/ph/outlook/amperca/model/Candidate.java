package ph.outlook.amperca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name="CANDIDATE")
public class Candidate {
	
	@Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer partyId;
	private Integer positionId;

	@Column(name = "name")
    @Size(max = 100, message = "field length must not exceed 100 characters")
	private String firstName;
	@Column(name = "name")
    @Size(max = 100, message = "field length must not exceed 100 characters")
	private String lastName;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPartyId() {
		return partyId;
	}
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
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

	@Override
	public String toString() {
		return "Candidate [id=" + id + ", partyId=" + partyId + ", positionId=" + positionId + ", firstName="
				+ firstName + ", lastName=" + lastName + "]";
	}

}
