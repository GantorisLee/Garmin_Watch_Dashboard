package coachingmateanalytics.coachingmate.entity;

public class Laps {
    private Number lap_id;
    private String statistic_id;
    private Number start_position_lat;
    private Number start_position_long;
    private Number end_position_lat;
    private Number end_position_long;
    private Number total_elapsed_time;
    private Number total_distance;
    private Number total_cycles;
    private Number total_calories;
    private Number total_fat_calories;
    private Number avg_speed;
    private Number max_speed;
    private Number avg_power;
    private Number max_power;
    private Number total_ascent;
    private Number total_descent;
    private Number normalized_power;
    private Number avg_stroke_distance;
    private Number num_active_lengths;
    private Number avg_cadence;
    private Number max_cadence;
    private String sport;

    public Laps(Number lap_id, String statistic_id, Number start_position_lat, Number start_position_long, Number end_position_lat, Number end_position_long, Number total_elapsed_time, Number total_distance, Number total_cycles, Number total_calories, Number total_fat_calories, Number avg_speed, Number max_speed, Number avg_power, Number max_power, Number total_ascent, Number total_descent, Number normalized_power, Number avg_stroke_distance, Number num_active_lengths, Number avg_cadence, Number max_cadence, String sport) {
        this.lap_id = lap_id;
        this.statistic_id = statistic_id;
        this.start_position_lat = start_position_lat;
        this.start_position_long = start_position_long;
        this.end_position_lat = end_position_lat;
        this.end_position_long = end_position_long;
        this.total_elapsed_time = total_elapsed_time;
        this.total_distance = total_distance;
        this.total_cycles = total_cycles;
        this.total_calories = total_calories;
        this.total_fat_calories = total_fat_calories;
        this.avg_speed = avg_speed;
        this.max_speed = max_speed;
        this.avg_power = avg_power;
        this.max_power = max_power;
        this.total_ascent = total_ascent;
        this.total_descent = total_descent;
        this.normalized_power = normalized_power;
        this.avg_stroke_distance = avg_stroke_distance;
        this.num_active_lengths = num_active_lengths;
        this.avg_cadence = avg_cadence;
        this.max_cadence = max_cadence;
        this.sport = sport;
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

    public Number getStart_position_lat() {
        return start_position_lat;
    }

    public void setStart_position_lat(Number start_position_lat) {
        this.start_position_lat = start_position_lat;
    }

    public Number getStart_position_long() {
        return start_position_long;
    }

    public void setStart_position_long(Number start_position_long) {
        this.start_position_long = start_position_long;
    }

    public Number getEnd_position_lat() {
        return end_position_lat;
    }

    public void setEnd_position_lat(Number end_position_lat) {
        this.end_position_lat = end_position_lat;
    }

    public Number getEnd_position_long() {
        return end_position_long;
    }

    public void setEnd_position_long(Number end_position_long) {
        this.end_position_long = end_position_long;
    }

    public Number getTotal_elapsed_time() {
        return total_elapsed_time;
    }

    public void setTotal_elapsed_time(Number total_elapsed_time) {
        this.total_elapsed_time = total_elapsed_time;
    }

    public Number getTotal_distance() {
        return total_distance;
    }

    public void setTotal_distance(Number total_distance) {
        this.total_distance = total_distance;
    }

    public Number getTotal_cycles() {
        return total_cycles;
    }

    public void setTotal_cycles(Number total_cycles) {
        this.total_cycles = total_cycles;
    }

    public Number getTotal_calories() {
        return total_calories;
    }

    public void setTotal_calories(Number total_calories) {
        this.total_calories = total_calories;
    }

    public Number getTotal_fat_calories() {
        return total_fat_calories;
    }

    public void setTotal_fat_calories(Number total_fat_calories) {
        this.total_fat_calories = total_fat_calories;
    }

    public Number getAvg_speed() {
        return avg_speed;
    }

    public void setAvg_speed(Number avg_speed) {
        this.avg_speed = avg_speed;
    }

    public Number getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(Number max_speed) {
        this.max_speed = max_speed;
    }

    public Number getAvg_power() {
        return avg_power;
    }

    public void setAvg_power(Number avg_power) {
        this.avg_power = avg_power;
    }

    public Number getMax_power() {
        return max_power;
    }

    public void setMax_power(Number max_power) {
        this.max_power = max_power;
    }

    public Number getTotal_ascent() {
        return total_ascent;
    }

    public void setTotal_ascent(Number total_ascent) {
        this.total_ascent = total_ascent;
    }

    public Number getTotal_descent() {
        return total_descent;
    }

    public void setTotal_descent(Number total_descent) {
        this.total_descent = total_descent;
    }

    public Number getNormalized_power() {
        return normalized_power;
    }

    public void setNormalized_power(Number normalized_power) {
        this.normalized_power = normalized_power;
    }

    public Number getAvg_stroke_distance() {
        return avg_stroke_distance;
    }

    public void setAvg_stroke_distance(Number avg_stroke_distance) {
        this.avg_stroke_distance = avg_stroke_distance;
    }

    public Number getNum_active_lengths() {
        return num_active_lengths;
    }

    public void setNum_active_lengths(Number num_active_lengths) {
        this.num_active_lengths = num_active_lengths;
    }

    public Number getAvg_cadence() {
        return avg_cadence;
    }

    public void setAvg_cadence(Number avg_cadence) {
        this.avg_cadence = avg_cadence;
    }

    public Number getMax_cadence() {
        return max_cadence;
    }

    public void setMax_cadence(Number max_cadence) {
        this.max_cadence = max_cadence;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }
}