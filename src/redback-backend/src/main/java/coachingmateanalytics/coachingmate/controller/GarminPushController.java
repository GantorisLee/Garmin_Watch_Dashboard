package coachingmateanalytics.coachingmate.controller;

import coachingmateanalytics.coachingmate.service.FrontEndService;


import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: Qi Li, Sirui Liang
 * @Date: 23/4/22 16:07
 * @Description:
 * There are several changes from original version
 * adjust the path to my garmin developer path
 * save all the athlete data as <Document> format
 * base on newest api, add athlete features
 */

@RestController
public class GarminPushController {
    private static final Logger logger = LoggerFactory.getLogger(GarminPushController.class);
    public static final String STORE_PATH="D:/coachingmate/public/garmin_raw/";

    @Autowired
    FrontEndService frontEndService;

    @PostMapping("/activities")
    @ApiOperation(value = "push2 data url", notes = "configure2 this url to end point configuration, " +
            "and the garmin endpoint will transfer the data to this server")
    public ResponseEntity<String> activityReceiverFromGarmin(@RequestBody String info){
        logger.info("start push activity Receiver From Garmin data");
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            JSONObject obj = new JSONObject(info);
            JSONArray array = obj.getJSONArray("activities");
            for (int i = 0; i < array.length(); i++) {
                JSONObject activity = array.getJSONObject(i);
                frontEndService.saveActivity(activity);
            }
        }
        catch (Exception e){
            httpHeaders.set("Get json fault", "120");
            return ResponseEntity.status(503).headers(httpHeaders).body("Failed to process. Reason : " + e.getMessage());
        }
        httpHeaders.set("Location", "public/garmin_raw");
        return ResponseEntity.accepted().headers(httpHeaders).body("Accept the pushed file");
    }


    @PostMapping("/activityDetails")
    @ApiOperation(value = "push data url", notes = "configure this url to end point configuration, " +
            "and the garmin endpoint will transfer the data to this server")
    public ResponseEntity<String> activityDetailsReceiverFromGarmin(@RequestBody String info) {
        logger.info("start push activity details Receiver From Garmin data");
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            JSONObject obj = new JSONObject(info);
            JSONArray array = obj.getJSONArray("activityDetails");
            for (int i = 0; i < array.length(); i++) {
                JSONObject activityDetail = array.getJSONObject(i);
                frontEndService.saveActivityDetails(activityDetail);
            }
        }
        catch (Exception e){
            httpHeaders.set("Get json fault", "120");
            return ResponseEntity.status(503).headers(httpHeaders).body("Failed to process. Reason : " + e.getMessage());
        }
        httpHeaders.set("Location", "public/garmin_raw");
        return ResponseEntity.accepted().headers(httpHeaders).body("Accept the pushed file");
    }

    @PostMapping("/epochs")
    @ApiOperation(value = "push data url", notes = "configure this url to end point configuration, " +
            "and the garmin endpoint will transfer the data to this server")
    public ResponseEntity<String> epochsReceiverFromGarmin(@RequestBody String info) {
        logger.info("start push epochs Receiver From Garmin data");
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            JSONObject obj = new JSONObject(info);
            JSONArray array = obj.getJSONArray("epochs");
            for (int i = 0; i < array.length(); i++) {
                JSONObject epoch = array.getJSONObject(i);
                frontEndService.saveEpoch(epoch);
            }
        }
        catch (Exception e){
            httpHeaders.set("Get json fault", "120");
            return ResponseEntity.status(503).headers(httpHeaders).body("Failed to process. Reason : " + e.getMessage());
        }
        httpHeaders.set("Location", "public/garmin_raw");
        return ResponseEntity.accepted().headers(httpHeaders).body("Accept the pushed file");
    }
}

