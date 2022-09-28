package coachingmateanalytics.coachingmate.entity;

import java.util.Date;

public class Program {
    private String program_id;
    private String[] session_ids;
    private Number club_id;
    private String title;
    private Date start_date;
    private String phase_id;
    private String phase;
    private String activity_type_id;
    private String activity_type;
    private String level;
    private Number weeks;

    public Program(String program_id, String title, Date start_date, String phase, String activity_type, String level, Number weeks) {
        this.program_id = program_id;
        this.title = title;
        this.start_date = start_date;
        this.phase = phase;
        this.activity_type = activity_type;
        this.level = level;
        this.weeks = weeks;
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }

    public String[] getSession_ids() {
        return session_ids;
    }

    public void setSession_ids(String[] session_ids) {
        this.session_ids = session_ids;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getPhase_id() {
        return phase_id;
    }

    public void setPhase_id(String phase_id) {
        this.phase_id = phase_id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Number getWeeks() {
        return weeks;
    }

    public void setWeeks(Number weeks) {
        this.weeks = weeks;
    }
}