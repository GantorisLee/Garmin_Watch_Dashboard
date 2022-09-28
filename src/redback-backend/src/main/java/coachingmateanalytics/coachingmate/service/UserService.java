package coachingmateanalytics.coachingmate.service;


import coachingmateanalytics.coachingmate.entity.UserPartner;

public interface UserService {
    UserPartner loginCheck(String username, String password);
    UserPartner register(String fullname, String username, String password, String email);
    UserPartner getUser(String username);
}
