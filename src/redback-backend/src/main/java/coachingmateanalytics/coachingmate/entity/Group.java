package coachingmateanalytics.coachingmate.entity;

public class Group {
    private String[] group_id;
    private String[] athlete_ids;
    private String[] planner_ids;

    public Group(String[] group_id, String[] athlete_ids) {
        this.group_id = group_id;
        this.athlete_ids = athlete_ids;
    }

    public String[] getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String[] group_id) {
        this.group_id = group_id;
    }

    public String[] getAthlete_ids() {
        return athlete_ids;
    }

    public void setAthlete_ids(String[] athlete_ids) {
        this.athlete_ids = athlete_ids;
    }

    public String[] getPlanner_ids() {
        return planner_ids;
    }

    public void setPlanner_ids(String[] planner_ids) {
        this.planner_ids = planner_ids;
    }
}