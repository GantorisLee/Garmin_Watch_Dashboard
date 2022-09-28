
package coachingmateanalytics.coachingmate;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import java.util.Date;

public class upComingDataprocessTest {

    @Test
    public void testApp() throws JSONException {

        // test upcoming string to json object
        System.out.println("hello world");
        JSONObject obj = new JSONObject("{\"activities\":[{\"durationInSeconds\":15,\"activeKilocalories\":1,\"averageSpeedInMetersPerSecond\":0.37,\"averageHeartRateInBeatsPerMinute\":99,\"distanceInMeters\":5.62,\"activityName\":\"Running\",\"userId\":\"5073e79f-df60-45dc-92f2-bc0ef300f1f0\",\"deviceName\":\"forerunner935\",\"steps\":8,\"averageRunCadenceInStepsPerMinute\":25.828125,\"averagePaceInMinutesPerKilometer\":45.045044,\"activityId\":8623463169,\"startTimeInSeconds\":1649748853,\"userAccessToken\":\"227a7c55-590d-498f-97ad-fb6ba3cb259f\",\"startTimeOffsetInSeconds\":36000,\"maxPaceInMinutesPerKilometer\":8.888888,\"maxHeartRateInBeatsPerMinute\":107,\"summaryId\":\"8623463169\",\"maxRunCadenceInStepsPerMinute\":156.0,\"maxSpeedInMetersPerSecond\":1.875,\"activityType\":\"RUNNING\"}]}");
        JSONObject obj2 = new JSONObject("{\"activityDetails\":[{\"userId\":\"5073e79f-df60-45dc-92f2-bc0ef300f1f0\",\"userAccessToken\":\"227a7c55-590d-498f-97ad-fb6ba3cb259f\",\"summaryId\":\"8654619722-detail\",\"activityId\":8654619722,\"summary\":{\"activityId\":8654619722,\"activityName\":\"Running\",\"durationInSeconds\":12,\"startTimeInSeconds\":1650193374,\"startTimeOffsetInSeconds\":36000,\"activityType\":\"RUNNING\",\"averageHeartRateInBeatsPerMinute\":87,\"deviceName\":\"forerunner935\",\"maxHeartRateInBeatsPerMinute\":92},\"samples\":[{\"startTimeInSeconds\":1650193374,\"elevationInMeters\":37.79999923706055,\"airTemperatureCelcius\":33.0,\"heartRate\":86,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":0,\"clockDurationInSeconds\":0,\"movingDurationInSeconds\":0},{\"startTimeInSeconds\":1650193375,\"elevationInMeters\":37.79999923706055,\"airTemperatureCelcius\":33.0,\"heartRate\":86,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":1,\"clockDurationInSeconds\":1,\"movingDurationInSeconds\":0},{\"startTimeInSeconds\":1650193384,\"elevationInMeters\":36.79999923706055,\"airTemperatureCelcius\":33.0,\"heartRate\":90,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":10,\"clockDurationInSeconds\":10,\"movingDurationInSeconds\":0},{\"startTimeInSeconds\":1650193385,\"elevationInMeters\":37.0,\"airTemperatureCelcius\":33.0,\"heartRate\":92,\"speedMetersPerSecond\":0.0,\"stepsPerMinute\":0.0,\"totalDistanceInMeters\":0.0,\"timerDurationInSeconds\":11,\"clockDurationInSeconds\":11,\"movingDurationInSeconds\":0}],\"laps\":[{\"startTimeInSeconds\":1650193374}]}]}");
        JSONObject obj3 = new JSONObject("{\"epochs\":[{\"activeKilocalories\":3,\"durationInSeconds\":300,\"distanceInMeters\":0}]}");

        // test utc data
        Date now = new Date();
        System.out.println(now.getTime());

        // test activity details
        JSONArray array = obj3.getJSONArray("activities");
        for (int i = 0; i < array.length(); i++) {
            JSONObject activity = array.getJSONObject(i);
        }

        // test activity details
        JSONArray array2 = obj3.getJSONArray("activityDetails");
        for (int i = 0; i < array.length(); i++) {
            JSONObject activityDetails = array2.getJSONObject(i);
        }

        // test epochs
        JSONArray array3 = obj3.getJSONArray("epochs");
        for (int i = 0; i < array.length(); i++) {
            JSONObject epoch = array3.getJSONObject(i);
        }
    }

}