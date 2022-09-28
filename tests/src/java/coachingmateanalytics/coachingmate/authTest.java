package coachingmateanalytics.coachingmate;
import coachingmateanalytics.coachingmate.service.HttpRequestAdapter;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class authTest {
    public static void main(String[] args) {
        // get consumer key and secret from the website
        // https://apis.garmin.com/tools/oauthAuthorizeUser
        String consumerkey = "96afaae3-5af3-4ce5-9a83-94ef96f777aa";
        String consumerSecret = "OUeTbGbtt3BzYXwVaB8NnvAXvGD33xnpySH";


        // Step 1: Acquire Unauthorized Request Token
        // For each user, the first step in getting user-approved data is acquiring a request token and token secret.
        // This request token does not have the ability to access data, nor is it user-specific yet.
        //
        //Enter your consumer secret below to generate the signature for getting the Request Token.

        // implement in coachingmateanalytics\coachingmate\service\OAuthService
        String requestTokenURL = "https://connectapi.garmin.com/oauth-service/oauth/request_token";

        RestTemplate signedRequestTemplate = new RestTemplateBuilder().additionalInterceptors(new ClientHttpRequestInterceptor() {
            @Override
            public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
                    throws IOException {
                DefaultOAuthConsumer consumer = new DefaultOAuthConsumer(consumerkey, consumerSecret);

                try {
                    consumer.sign(new HttpRequestAdapter(request, body));
                } catch (OAuthMessageSignerException | OAuthExpectationFailedException
                        | OAuthCommunicationException e) {
                    throw new RuntimeException("unable to sign request with consumer_key=" + consumerkey, e);
                }
                return execution.execute(request, body);
            }
        }).build();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);

        ResponseEntity<String> result =  signedRequestTemplate.exchange(requestTokenURL, HttpMethod.GET,httpEntity, String.class);
        // Get result
        String accessTokenSecret = result.getBody().toString();

        String oauth_token = accessTokenSecret.split("=")[1].split("&")[0];

        System.out.println(accessTokenSecret);

        // Step 2: Authorization of the Request Token
        //The request token from step 1 needs to be approved by the user.
        // This is done by redirecting to Garmin Connect where the user logs in and grants access to the data.
        // Garmin Connect will redirect the user to the given callback URL and append the OAuth verifier.

        // jump to website
        String oauthConfirmUrl = "http://connect.garmin.com/oauthConfirm";
        String URL_DELIMTER = "?";
        String OAUTH_TOKEN = "oauth_token";
        String VALUE_DELIMTER = "=";
        String CALLBACK_URL = "https://lk-redback2.herokuapp.com/auth/accessToken";
        String VARIABLE_DELIMTER = "&";
        String OAUTH_VERIFIER = "oauth_verifier";
        String url = oauthConfirmUrl + URL_DELIMTER + OAUTH_TOKEN + VALUE_DELIMTER + oauth_token + VARIABLE_DELIMTER + CALLBACK_URL + '=' + CALLBACK_URL;

        System.out.println("Please redirect to this url: \n"+ url);
        System.out.println("Please get the VERIFIER at the end of your authorization");

        Map<String, String> map = new HashMap<>();
        map.put("url", url);
        ResponseEntity.accepted().body(map);
    }
}
