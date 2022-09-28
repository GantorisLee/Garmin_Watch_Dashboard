package coachingmateanalytics.coachingmate.entity;

public class Badge {
    private String badge_id;
    private String url;
    private String title;

    public Badge(String badge_id, String url, String title) {
        this.badge_id = badge_id;
        this.url = url;
        this.title = title;
    }

    public String getBadge_id() {
        return badge_id;
    }

    public void setBadge_id(String badge_id) {
        this.badge_id = badge_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}