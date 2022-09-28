package coachingmateanalytics.coachingmate.entity;

import java.util.Date;

public class Exercise {
    private String exercise_id;
    private String title;
    private String description;
    private String[] components;
    private String tips;
    private String[] body_sections;
    private String type;
    private Date created_at;
    private Number added_by;

    public Exercise(String exercise_id, String title, String description, String[] components, String tips, String[] body_sections, String type, Date created_at, Number added_by) {
        this.exercise_id = exercise_id;
        this.title = title;
        this.description = description;
        this.components = components;
        this.tips = tips;
        this.body_sections = body_sections;
        this.type = type;
        this.created_at = created_at;
        this.added_by = added_by;
    }

    public String getExercise_id() {
        return exercise_id;
    }

    public void setExercise_id(String exercise_id) {
        this.exercise_id = exercise_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getComponents() {
        return components;
    }

    public void setComponents(String[] components) {
        this.components = components;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String[] getBody_sections() {
        return body_sections;
    }

    public void setBody_sections(String[] body_sections) {
        this.body_sections = body_sections;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Number getAdded_by() {
        return added_by;
    }

    public void setAdded_by(Number added_by) {
        this.added_by = added_by;
    }
}