package ph.outlook.amperca.model;

import java.util.List;

public class ElectionResponseModel {
    private String electionName;
    private List<CandidateResponseModel> positions;
    public String getElectionName() {
        return electionName;
    }
    public void setElectionName(String electionName) {
        this.electionName = electionName;
    }
    public List<CandidateResponseModel> getPositions() {
        return positions;
    }
    public void setPositions(List<CandidateResponseModel> positions) {
        this.positions = positions;
    }
}
