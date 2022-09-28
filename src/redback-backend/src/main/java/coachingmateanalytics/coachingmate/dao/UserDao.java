package coachingmateanalytics.coachingmate.dao;


import coachingmateanalytics.coachingmate.entity.UserPartner;

public interface UserDao  {
	 
	 int getMaxUserid();
     void saveUser(UserPartner user);
     UserPartner findUserByUsername(String username);
     UserPartner findUserByEmail(String email);
     int updateUser(UserPartner user);
     void deleteUserByUsername(String username);
     

}