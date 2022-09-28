package coachingmateanalytics.coachingmate.entity;

import java.nio.Buffer;
import java.util.Date;

public class Athlete {
    private String user_id;
    private String[] coach_ids;
    private String user_login;
    private String user_pass;
    private String user_activation_key;
    private String user_email;
    private String user_status;
    private String serial_num;
    private String oauth_access_token;
    private String oauth_access_token_secret;
    private String display_name;
    private String mobile_phone;
    private String biography;
    private String[] planner_ids;
    private String[] friend_ids;
    private String[] badge_ids;
    private Buffer avatar;
    private Date created_date;

    public Athlete(String user_id, String user_login, String user_pass, String user_activation_key, String user_email, String user_status, String display_name, Date created_date) {
        this.user_id = user_id;
        this.user_login = user_login;
        this.user_pass = user_pass;
        this.user_activation_key = user_activation_key;
        this.user_email = user_email;
        this.user_status = user_status;
        this.display_name = display_name;
        this.created_date = created_date;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String[] getCoach_ids() {
        return coach_ids;
    }

    public void setCoach_ids(String[] coach_ids) {
        this.coach_ids = coach_ids;
    }

    public String getUser_login() {
        return user_login;
    }

    public void setUser_login(String user_login) {
        this.user_login = user_login;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getUser_activation_key() {
        return user_activation_key;
    }

    public void setUser_activation_key(String user_activation_key) {
        this.user_activation_key = user_activation_key;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }

    public String getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(String serial_num) {
        this.serial_num = serial_num;
    }

    public String getOauth_access_token() {
        return oauth_access_token;
    }

    public void setOauth_access_token(String oauth_access_token) {
        this.oauth_access_token = oauth_access_token;
    }

    public String getOauth_access_token_secret() {
        return oauth_access_token_secret;
    }

    public void setOauth_access_token_secret(String oauth_access_token_secret) {
        this.oauth_access_token_secret = oauth_access_token_secret;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String[] getPlanner_ids() {
        return planner_ids;
    }

    public void setPlanner_ids(String[] planner_ids) {
        this.planner_ids = planner_ids;
    }

    public String[] getFriend_ids() {
        return friend_ids;
    }

    public void setFriend_ids(String[] friend_ids) {
        this.friend_ids = friend_ids;
    }

    public String[] getBadge_ids() {
        return badge_ids;
    }

    public void setBadge_ids(String[] badge_ids) {
        this.badge_ids = badge_ids;
    }

    public void setAvatar(Buffer avatar) {
        this.avatar = avatar;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Buffer getAvatar() {
        return avatar;
    }

}