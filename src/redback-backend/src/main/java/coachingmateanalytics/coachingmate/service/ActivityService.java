package coachingmateanalytics.coachingmate.service;

import org.bson.Document;
import org.json.JSONObject;

import java.util.List;

/**
 * @Date: 24/9/20 16:03
 * @Description:
 */
public interface ActivityService {
    void saveActivity(JSONObject activity);
    void saveActivityDetails(JSONObject activityDetails);
    void saveEpoch(JSONObject epoch);

    List<Document> findActivityByUsername(String username);
    List<Document> findActivityDetailsByUsername(String username);

    List<Document> findActivityByAccessToken(String accessToken);
    List<Document> findActivityDetailsByAccessToken(String accessToken);
}
