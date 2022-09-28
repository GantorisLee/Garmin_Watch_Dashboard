package coachingmateanalytics.coachingmate.dao;


import coachingmateanalytics.coachingmate.entity.UserPartner;

import coachingmateanalytics.coachingmate.utils.Consts;
import com.alibaba.fastjson.JSON;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    /***
     * @Description test remote mongodb using collection name
     * @Date 23:24 22/9/20
     * @param user
     * @return {@link }
     */
    public void saveUser(UserPartner user) {
        mongoTemplate.save(user, Consts.MONGODB_USER_COLLECTIN_NAME);
    }

    public UserPartner findUserByUsername(String username) {
        Query query=new Query(Criteria.where("username").is(username));
        UserPartner user =  mongoTemplate.findOne(query , UserPartner.class,Consts.MONGODB_USER_COLLECTIN_NAME);
        return user;
    }
    
    public UserPartner findUserByEmail(String email) {
        Query query=new Query(Criteria.where("email").is(email));
        UserPartner user =  mongoTemplate.findOne(query , UserPartner.class,Consts.MONGODB_USER_COLLECTIN_NAME);
        return user;
    }


    public int updateUser(UserPartner user) {
        Query query=new Query(Criteria.where("username").is(user.getUsername()));
        Update update= Update.update("userAccessToken", user.getUserAccessToken()).set("userAccessSecret", user.getUserAccessSecret());
        UpdateResult result =mongoTemplate.updateMulti(query,update,UserPartner.class,Consts.MONGODB_USER_COLLECTIN_NAME);
        return (int) result.getMatchedCount();
    }
//    @Override
    public int getMaxUserid() {
    	Query query=new Query();
    	query.with(Sort.by(Sort.Direction.DESC, "userId"));
    	List<UserPartner> users = mongoTemplate.find(query, UserPartner.class,Consts.MONGODB_USER_COLLECTIN_NAME);
    	if(users.size()==0) {
    		return 0;
    	}
    	return (int) users.get(0).getUserId();
    	
    }

    @Override
    public void deleteUserByUsername(String username) {
        Query query=new Query(Criteria.where("username").is(username));
        mongoTemplate.remove(query,UserPartner.class,Consts.MONGODB_USER_COLLECTIN_NAME);
    }

}
