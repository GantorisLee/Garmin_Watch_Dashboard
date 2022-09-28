package coachingmateanalytics.coachingmate.service.serviceImpl;

import coachingmateanalytics.coachingmate.dao.ActivityDao;
import coachingmateanalytics.coachingmate.dao.UserDao;
import coachingmateanalytics.coachingmate.entity.UserPartner;
import coachingmateanalytics.coachingmate.service.ActivityService;
import coachingmateanalytics.coachingmate.utils.Consts;
import org.bson.Document;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date: 24/9/20 16:05
 * @Description:
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityDao activityDao;

    @Autowired
    UserDao userDao;

    @Override
    public void saveActivity(JSONObject activity) {
        activityDao.saveMongodb(activity, Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
    }

    @Override
    public void saveActivityDetails(JSONObject activity) {
        activityDao.saveMongodb(activity, Consts.MONGODB_ACTIVITY_DETAIL_COLLECTIN_NAME);
    }

    @Override
    public void saveEpoch(JSONObject epoch) {
        activityDao.saveMongodb(epoch, Consts.MONGODB_EPOCH_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityByUsername(String username) {
        UserPartner user = userDao.findUserByUsername(username);
        return activityDao.findByAccessToken(user.getUserAccessToken(), Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityByAccessToken(String accessToken) {
        return activityDao.findByAccessToken(accessToken, Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityDetailsByUsername(String username) {
        UserPartner user = userDao.findUserByUsername(username);
        return activityDao.findByAccessToken(user.getUserAccessToken(), Consts.MONGODB_ACTIVITY_DETAIL_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityDetailsByAccessToken(String accessToken) {
        return activityDao.findByAccessToken(accessToken, Consts.MONGODB_ACTIVITY_DETAIL_COLLECTIN_NAME);
    }
}
