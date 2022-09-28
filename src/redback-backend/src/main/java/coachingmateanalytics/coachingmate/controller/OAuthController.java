package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.dao.UserDao;
import coachingmateanalytics.coachingmate.entity.RequestToken;
import coachingmateanalytics.coachingmate.entity.UserPartner;
import coachingmateanalytics.coachingmate.service.OAuthService;
import coachingmateanalytics.coachingmate.utils.Consts;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This Controller exercises an implementation of the core oauth process.
 *
 *
 */
@Controller
@RequestMapping("/auth")
public class OAuthController {
    private static final Logger logger = LoggerFactory.getLogger(OAuthController.class);

    @Autowired
    OAuthService oauthService;

    @Autowired
    UserDao userDao;

    //The Garmin Connect API Oauth request_token URL
    @Value("${requestToken.url}")
    private String requestTokenUrl;

    //The Garmin Connect API Oauth access_token URL
    @Value("${oauthAccessToken.url}")
    private String oauthAccessTokenUrl;

    /**
     * Initiate the request_token portion of the 3-legged oauth process, then redirect to the oauthConfirm step
     * so the user can enter their Garmin Connect username and password.
     * @return A ResponseEntity sending the user to the manual oauthConfirm page.
     */
    @RequestMapping("/requestToken")
    @ApiOperation(value = "oauth RequestToken", notes = "Acquire Unauthorized Request Token and Token Secret ")
    public ResponseEntity<Map<String, String>> oauthRequestToken(@ApiParam(required = true, type = "String") String username) {
        logger.debug("user " + username + "request token");
        RequestToken reqToken = oauthService.getRequestToken(requestTokenUrl, username);
        String result = "";
        if (reqToken != null) {
            result  = oauthService.getOAuthConfirmURL(reqToken.getToken());
            logger.debug("the redirect url : " + result);
        }
        Map<String, String> map = new HashMap<>();
        map.put("url", result);
        return ResponseEntity.accepted().body(map);
    }

    /**
     * The third oauth leg. Provide the oauth token and the verifier value from the first two steps
     * to generate a user access token associated with the user. From this point on that user is opted in
     * to your program.
     * @param oauthToken
     * @param oauthVerifierValue
     * @return
     */
    @GetMapping("/accessToken")
    @ApiOperation(value = "callback url", notes = "this is used to receive the request from garmin connect")

    public String oauthAccessToken(@ApiParam(required = true, type = "String")
                                       @RequestParam(value = "oauth_token") String oauthToken,
                                   @ApiParam(required = true, type = "String")
                                   @RequestParam(value = "oauth_verifier") String oauthVerifierValue) {
        if (oauthVerifierValue != null && !oauthVerifierValue.isEmpty()) {
            String accessTokenUrl = oauthAccessTokenUrl + Consts.URL_DELIMTER + Consts.OAUTH_VERIFIER + Consts.VALUE_DELIMTER + oauthVerifierValue;
            oauthService.generateAccessToken(accessTokenUrl, oauthToken);
        }
        return "authoriseSuccess";
    }


    /**
     * A convenience endpoint to display user data if it exists, or generate it if it doesn't.
     * It just calls all of the above functionality.
     * This should not be part of your actual implementation!
     * @param username
     * @return
     */
    @RequestMapping(value = "/userAccessToken", method = RequestMethod.POST)
    @ApiOperation(value = "generate Access Token", notes = "when user first invoke this url, it will authorise" +
            "the user, when this user has been authorised, it just need to get token from mongodb")
    public String generateToken(@ApiParam(required = true, type = "String") @RequestParam String username) {
        UserPartner userPartner = userDao.findUserByUsername(username);
        if (userPartner.getUserAccessToken() != null) {
            return userPartner.getUsername();
        } else {
            return "redirect:/auth/requestToken/" + username;
        }
    }

}