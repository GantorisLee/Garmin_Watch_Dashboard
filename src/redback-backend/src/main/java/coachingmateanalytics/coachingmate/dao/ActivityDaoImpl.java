package coachingmateanalytics.coachingmate.dao;

import coachingmateanalytics.coachingmate.utils.Consts;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date: 24/9/20 10:16
 * @Description:
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

@Component
public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveMongodb(JSONObject activity, String savePosition) {
        Document doc = Document.parse(activity.toString());
        mongoTemplate.save(doc, savePosition);
    }


    @Override
    public void saveActivityString(String activity) {
        Document doc = Document.parse(activity);
        mongoTemplate.save(doc, Consts.MONGODB_ACTIVITY_DETAIL_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findByAccessToken(String accessToken, String savePosition) {
        Query query = Query.query(Criteria.where("userAccessToken").is(accessToken));
        List<Document> Activities = mongoTemplate.find(query, Document.class,savePosition);

        List<String> myList = new ArrayList<>();
        for (Document activity : Activities){
            try {
                activity.remove("_id");
                JSONObject myActivity = new JSONObject(activity.toJson());
                myList.add(myActivity.toString());
            } catch (Exception e){
                System.out.println("error in transform document to json");
            }
        }
        return Activities;
    }


}
