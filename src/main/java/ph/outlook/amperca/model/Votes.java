package ph.outlook.amperca.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Votes {

    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CANDIDATE_ID")
    private Candidate candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ELECTION_ID")
    private Election election;

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

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getCreated() {
        return created;
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

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    @Override
    public String toString() {
        return "Votes [id=" + id + ", candidate=" + candidate + ", voter=" + user + ", created=" + created
                + ", lastUpdated=" + lastUpdated + "]";
    }

}
