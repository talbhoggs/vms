package ph.outlook.amperca.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CandidateRequestModel {
	
	@Size(min=3, max = 100, message = "Please enter you First Name")
	private String firstName;
	
	@Size(min=3, max = 100, message = "Please enter you Last Name")
	private String lastName;
	
	@NotNull(message = "Please select a political party")
	private Integer partyId;
	
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
	
	public Integer getPartyId() {
		return partyId;
	}
	
	public void setPartyId(Integer partyId) {
		this.partyId = partyId;
	}
	
	
}
