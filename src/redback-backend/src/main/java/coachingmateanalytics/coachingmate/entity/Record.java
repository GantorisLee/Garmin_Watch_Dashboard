package coachingmateanalytics.coachingmate.entity;

import java.util.Date;

public class Record {
    private Number record_id;
    private Number lap_id;
    private String  statistic_id;
    private Date timestamp;
    private Number position_lat;
    private Number position_long;
    private Number distance;
    private Number speed;
    private Number altitude;
    private Number heart_rate;
    private Number cadence;

    public Record(Number record_id, Number lap_id, String statistic_id, Date timestamp, Number position_lat, Number position_long, Number distance, Number speed, Number altitude, Number heart_rate, Number cadence) {
        this.record_id = record_id;
        this.lap_id = lap_id;
        this.statistic_id = statistic_id;
        this.timestamp = timestamp;
        this.position_lat = position_lat;
        this.position_long = position_long;
        this.distance = distance;
        this.speed = speed;
        this.altitude = altitude;
        this.heart_rate = heart_rate;
        this.cadence = cadence;
    }

    public Number getRecord_id() {
        return record_id;
    }

    public void setRecord_id(Number record_id) {
        this.record_id = record_id;
    }

    public Number getLap_id() {
        return lap_id;
    }

    public void setLap_id(Number lap_id) {
        this.lap_id = lap_id;
    }

    public String getStatistic_id() {
        return statistic_id;
    }

    public void setStatistic_id(String statistic_id) {
        this.statistic_id = statistic_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Number getPosition_lat() {
        return position_lat;
    }

    public void setPosition_lat(Number position_lat) {
        this.position_lat = position_lat;
    }

    public Number getPosition_long() {
        return position_long;
    }

    public void setPosition_long(Number position_long) {
        this.position_long = position_long;
    }

    public Number getDistance() {
        return distance;
    }

    public void setDistance(Number distance) {
        this.distance = distance;
    }

    public Number getSpeed() {
        return speed;
    }

    public void setSpeed(Number speed) {
        this.speed = speed;
    }

    public Number getAltitude() {
        return altitude;
    }

    public void setAltitude(Number altitude) {
        this.altitude = altitude;
    }

    public Number getHeart_rate() {
        return heart_rate;
    }

    public void setHeart_rate(Number heart_rate) {
        this.heart_rate = heart_rate;
    }

    public Number getCadence() {
        return cadence;
    }

    public void setCadence(Number cadence) {
        this.cadence = cadence;
    }
}