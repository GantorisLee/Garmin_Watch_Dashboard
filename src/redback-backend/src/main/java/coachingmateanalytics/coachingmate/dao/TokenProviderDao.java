package coachingmateanalytics.coachingmate.dao;

import coachingmateanalytics.coachingmate.entity.RequestToken;
import coachingmateanalytics.coachingmate.service.OauthConfiguration;
import coachingmateanalytics.coachingmate.utils.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenProviderDao
{
    private static final Logger logger = LoggerFactory.getLogger(TokenProviderDao.class);


    @Autowired
    OauthConfiguration oauthConfig;

    @Autowired
    TokenDao tokenDao;


    public String generateRequestTokenSecret(String url) {
        String tokenAndSecret = null;
        try{
            RestTemplate restTemplate = oauthConfig.getRestTemplate();
            ResponseEntity<String> result =  restTemplate.exchange(url, HttpMethod.GET,oauthConfig.httpEntity(), String.class);
            tokenAndSecret = result.getBody().toString();
            logger.info("value in tokenSecret is: {}",tokenAndSecret);
        }
        catch(Exception e){
            logger.error(e.getMessage());
        }

        return tokenAndSecret;

    }

    public String generateAccessTokenSecret(String url, String oauthToken) {
        String accessTokenSecret = null;
        RequestToken reqToken = tokenDao.findByToken(oauthToken);
        try{
            RestTemplate restTemplate = oauthConfig.getRestTemplate(oauthToken, reqToken.getSecret());
            ResponseEntity<String> result =  restTemplate.exchange(url, HttpMethod.POST,oauthConfig.httpEntity(),String.class);
            accessTokenSecret = result.getBody().toString();
            logger.info("value in accessTokenSecret is: {}",accessTokenSecret);
        }
        catch(Exception e){
            logger.error(e.getMessage());
        }
        return accessTokenSecret + Consts.VARIABLE_DELIMTER + reqToken.getUsername();
    }


}
