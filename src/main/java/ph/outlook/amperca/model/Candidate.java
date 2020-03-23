package ph.outlook.amperca.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
public class Candidate {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "PARTY_LIST_ID")
    @NotNull
    private PartyList partList;

    @OneToOne
    @JoinColumn(name = "POSITION_ID")
    @NotNull
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ELECTION_ID")
    @NotNull
    private Election election;

    /*
     * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
     *
     * @JoinTable(name = "ELECTION_CANDIDATE", joinColumns = @JoinColumn(name =
     * "CANDIDATE_ID", referencedColumnName = "ID"), inverseJoinColumns
     * = @JoinColumn(name = "ELECTION_ID", referencedColumnName = "ID")) private
     * Set<Election> elections;
     */

    @Column(name = "FIRST_NAME")
    @Size(max = 100, message = "field length must not exceed 100 characters")
    private String firstName;

    @Column(name = "LAST_NAME")
    @Size(max = 100, message = "field length must not exceed 100 characters")
    private String lastName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public PartyList getPartList() {
        return partList;
    }

    public void setPartList(PartyList partList) {
        this.partList = partList;
    }

    /*
     * public Set<Election> getElections() { return elections; } public void
     * setElections(Set<Election> elections) { this.elections = elections; }
     */
    @Override
    public String toString() {
        return "Candidate [id=" + id + ", partyId=" + partList.getId() + ", positionId=" + position.getId()
                + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }

}
