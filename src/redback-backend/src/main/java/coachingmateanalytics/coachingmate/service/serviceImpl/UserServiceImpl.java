package coachingmateanalytics.coachingmate.service.serviceImpl;

import coachingmateanalytics.coachingmate.dao.UserDaoImpl;
import coachingmateanalytics.coachingmate.dao.UserDao;
import coachingmateanalytics.coachingmate.entity.UserPartner;
import coachingmateanalytics.coachingmate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Date: 24/9/20 00:50
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    

    @Override
    public UserPartner loginCheck(String username, String password) {
        UserPartner userPartner = userDao.findUserByUsername(username);
        if(null == userPartner || !userPartner.getPassword().equals(password)) return null;
        return userPartner;
    }
    
    @Override
    public UserPartner getUser(String username) {
        UserPartner userPartner = userDao.findUserByUsername(username);
        if(null == userPartner) return null;
        return userPartner;
    }

    @Override
    public UserPartner register(String fullname, String username, String password, String email) {
        UserPartner userPartner = userDao.findUserByUsername(username);
        UserPartner userPartner1 = userDao.findUserByEmail(email);
        int maxId=userDao.getMaxUserid();
        if(userPartner != null || userPartner1!= null) return null;
        Random random = new Random();
        UserPartner newUserPartner = new UserPartner();
        newUserPartner.setFullname(fullname);
        newUserPartner.setUsername(username);
        newUserPartner.setPassword(password);
        newUserPartner.setEmail(email);
        newUserPartner.setUserId(maxId+1);	
        userDao.saveUser(newUserPartner);
        return newUserPartner;
    }
}
