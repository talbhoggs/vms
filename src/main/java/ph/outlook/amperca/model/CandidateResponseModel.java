package ph.outlook.amperca.model;

import java.util.List;

public class CandidateResponseModel {

    private String position;
    private List<Candidate> candidates;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(List<Candidate> candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "CadidateResponseModel [position=" + position + ", candidates=" + candidates
                + "]";
    }

}
