package coachingmateanalytics.coachingmate.entity;

import java.util.Date;

public class Session {
    private String session_id;
    private Date date;
    private Number club_id;
    private String title;
    private String util;
    private Number distance;
    private Number hour;
    private Number minute;
    private String family_name;
    private String level;
    private String[] keywords;
    private String activity_type_id;
    private String activity_type;
    private Date add_time;
    private Number rpe_load;
    private String image;
    private String[] videos;
    private String exercise_type;
    private String rpe;
    private String added_by;
    private String[] components;
    private String perceived_efforts;
    private String[] exercises;
    private String[] sport_keywords;
    private Object description;

    public Session(String session_id, Date date, String title, String util, Number distance, Number hour, Number minute, String family_name, String level, String[] keywords, String activity_type, String rpe, String added_by, Object description) {
        this.session_id = session_id;
        this.date = date;
        this.title = title;
        this.util = util;
        this.distance = distance;
        this.hour = hour;
        this.minute = minute;
        this.family_name = family_name;
        this.level = level;
        this.keywords = keywords;
        this.activity_type = activity_type;
        this.rpe = rpe;
        this.added_by = added_by;
        this.description = description;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Number getClub_id() {
        return club_id;
    }

    public void setClub_id(Number club_id) {
        this.club_id = club_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUtil() {
        return util;
    }

    public void setUtil(String util) {
        this.util = util;
    }

    public Number getDistance() {
        return distance;
    }

    public void setDistance(Number distance) {
        this.distance = distance;
    }

    public Number getHour() {
        return hour;
    }

    public void setHour(Number hour) {
        this.hour = hour;
    }

    public Number getMinute() {
        return minute;
    }

    public void setMinute(Number minute) {
        this.minute = minute;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public String getActivity_type_id() {
        return activity_type_id;
    }

    public void setActivity_type_id(String activity_type_id) {
        this.activity_type_id = activity_type_id;
    }

    public String getActivity_type() {
        return activity_type;
    }

    public void setActivity_type(String activity_type) {
        this.activity_type = activity_type;
    }

    public Date getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Date add_time) {
        this.add_time = add_time;
    }

    public Number getRpe_load() {
        return rpe_load;
    }

    public void setRpe_load(Number rpe_load) {
        this.rpe_load = rpe_load;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String[] getVideos() {
        return videos;
    }

    public void setVideos(String[] videos) {
        this.videos = videos;
    }

    public String getExercise_type() {
        return exercise_type;
    }

    public void setExercise_type(String exercise_type) {
        this.exercise_type = exercise_type;
    }

    public String getRpe() {
        return rpe;
    }

    public void setRpe(String rpe) {
        this.rpe = rpe;
    }

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public String[] getComponents() {
        return components;
    }

    public void setComponents(String[] components) {
        this.components = components;
    }

    public String getPerceived_efforts() {
        return perceived_efforts;
    }

    public void setPerceived_efforts(String perceived_efforts) {
        this.perceived_efforts = perceived_efforts;
    }

    public String[] getExercises() {
        return exercises;
    }

    public void setExercises(String[] exercises) {
        this.exercises = exercises;
    }

    public String[] getSport_keywords() {
        return sport_keywords;
    }

    public void setSport_keywords(String[] sport_keywords) {
        this.sport_keywords = sport_keywords;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }
}