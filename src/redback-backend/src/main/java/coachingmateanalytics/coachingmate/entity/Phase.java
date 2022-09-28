package coachingmateanalytics.coachingmate.entity;

public class Phase {
    private String phase_id;
    private String phase_name;
    private String description;

    public Phase(String phase_id, String phase_name, String description) {
        this.phase_id = phase_id;
        this.phase_name = phase_name;
        this.description = description;
    }

    public String getPhase_id() {
        return phase_id;
    }

    public void setPhase_id(String phase_id) {
        this.phase_id = phase_id;
    }

    public String getPhase_name() {
        return phase_name;
    }

    public void setPhase_name(String phase_name) {
        this.phase_name = phase_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}