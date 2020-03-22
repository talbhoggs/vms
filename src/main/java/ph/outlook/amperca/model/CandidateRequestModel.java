package ph.outlook.amperca.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CandidateRequestModel {

	@Size(min = 3, max = 100, message = "Please enter you First Name")
	private String firstName;

	@Size(min = 3, max = 100, message = "Please enter you Last Name")
	private String lastName;

	@NotNull(message = "Please select a political party")
	private Integer partyId;

	@NotNull(message = "Please select a position")
	private Integer positionId;

	@NotNull(message = "Please select a election")
	private Integer electionId;

	public Integer getElectionId() {
		return electionId;
	}

	public void setElectionId(Integer electionId) {
		this.electionId = electionId;
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

	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public Integer getPartyId() {
		return partyId;
	}

	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}

}
