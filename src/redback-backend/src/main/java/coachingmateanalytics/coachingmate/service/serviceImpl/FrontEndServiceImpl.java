package coachingmateanalytics.coachingmate.service.serviceImpl;

import coachingmateanalytics.coachingmate.dao.RetrieveFromDatabaseDao;
import coachingmateanalytics.coachingmate.dao.UserDao;
import coachingmateanalytics.coachingmate.entity.UserPartner;
import coachingmateanalytics.coachingmate.service.FrontEndService;
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
public class FrontEndServiceImpl implements FrontEndService {

    @Autowired
    RetrieveFromDatabaseDao retrieveFromDatabaseDao;

    @Autowired
    UserDao userDao;

    @Override
    public void saveActivity(JSONObject activity) {
        retrieveFromDatabaseDao.saveMongodb(activity, Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
    }

    @Override
    public void saveActivityDetails(JSONObject activity) {
        retrieveFromDatabaseDao.saveMongodb(activity, Consts.MONGODB_ACTIVITY_DETAIL_COLLECTIN_NAME);
    }

    @Override
    public void saveEpoch(JSONObject epoch) {
        retrieveFromDatabaseDao.saveMongodb(epoch, Consts.MONGODB_EPOCH_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityByUsername(String username) {
        UserPartner user = userDao.findUserByUsername(username);
        return retrieveFromDatabaseDao.findByAccessToken(user.getUserAccessToken(), Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityByAccessToken(String accessToken) {
        return retrieveFromDatabaseDao.findByAccessToken(accessToken, Consts.MONGODB_ACTIVITY_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityDetailsByUsername(String username) {
        UserPartner user = userDao.findUserByUsername(username);
        return retrieveFromDatabaseDao.findByAccessToken(user.getUserAccessToken(), Consts.MONGODB_ACTIVITY_DETAIL_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findActivityDetailsByAccessToken(String accessToken) {
        return retrieveFromDatabaseDao.findByAccessToken(accessToken, Consts.MONGODB_ACTIVITY_DETAIL_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findEpochByUsername(String username) {
        UserPartner user = userDao.findUserByUsername(username);
        return retrieveFromDatabaseDao.findByAccessToken(user.getUserAccessToken(), Consts.MONGODB_EPOCH_COLLECTIN_NAME);
    }

    @Override
    public List<Document> findEpochByAccessToken(String accessToken) {
        return retrieveFromDatabaseDao.findByAccessToken(accessToken, Consts.MONGODB_EPOCH_COLLECTIN_NAME);
    }
}
