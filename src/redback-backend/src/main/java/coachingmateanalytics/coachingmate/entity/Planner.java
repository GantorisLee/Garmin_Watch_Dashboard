package coachingmateanalytics.coachingmate.entity;

import java.util.Date;

public class Planner {
    private String planner_id;
    private String[] program_ids;
    private String title;
    private Date starting_date;
    private Number end_interval;
    private String display_countdown;
    private String reverse_countdown;
    private String added_by;
    private String tc_start_date;
    private String tc_interval;

    public Planner(String planner_id, String title, Date starting_date, Number end_interval, String display_countdown, String reverse_countdown, String added_by, String tc_start_date, String tc_interval) {
        this.planner_id = planner_id;
        this.title = title;
        this.starting_date = starting_date;
        this.end_interval = end_interval;
        this.display_countdown = display_countdown;
        this.reverse_countdown = reverse_countdown;
        this.added_by = added_by;
        this.tc_start_date = tc_start_date;
        this.tc_interval = tc_interval;
    }

    public String getPlanner_id() {
        return planner_id;
    }

    public void setPlanner_id(String planner_id) {
        this.planner_id = planner_id;
    }

    public String[] getProgram_ids() {
        return program_ids;
    }

    public void setProgram_ids(String[] program_ids) {
        this.program_ids = program_ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(Date starting_date) {
        this.starting_date = starting_date;
    }

    public Number getEnd_interval() {
        return end_interval;
    }

    public void setEnd_interval(Number end_interval) {
        this.end_interval = end_interval;
    }

    public String getDisplay_countdown() {
        return display_countdown;
    }

    public void setDisplay_countdown(String display_countdown) {
        this.display_countdown = display_countdown;
    }

    public String getReverse_countdown() {
        return reverse_countdown;
    }

    public void setReverse_countdown(String reverse_countdown) {
        this.reverse_countdown = reverse_countdown;
    }

    public String getAdded_by() {
        return added_by;
    }

    public void setAdded_by(String added_by) {
        this.added_by = added_by;
    }

    public String getTc_start_date() {
        return tc_start_date;
    }

    public void setTc_start_date(String tc_start_date) {
        this.tc_start_date = tc_start_date;
    }

    public String getTc_interval() {
        return tc_interval;
    }

    public void setTc_interval(String tc_interval) {
        this.tc_interval = tc_interval;
    }
}