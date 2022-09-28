package coachingmateanalytics.coachingmate.dao;

import org.bson.Document;
import org.json.JSONObject;

import java.util.List;

/**
 * @Date: 24/9/20 10:14
 * @Description:
 */
public interface ActivityDao {
    void saveMongodb(JSONObject activity, String savePosition);
    void saveActivityString(String activity);

    List<Document> findByAccessToken(String accessToken, String savePosition);
}
