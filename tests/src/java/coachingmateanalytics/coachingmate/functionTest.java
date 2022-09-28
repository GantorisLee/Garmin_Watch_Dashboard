package coachingmateanalytics.coachingmate;

import org.bson.Document;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class functionTest {
    public static Document generateEpochDoc(Date dateTime) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
        String strDate = formatter.format(dateTime);

        Document dateUnit = new Document()
                .append("date", strDate)
                .append("calories", 0)
                .append("distance", 0.0);

        return dateUnit;
    }

    public static boolean isSameDay(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        return calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR)
                && calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH)
                && calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH);
    }


    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date();
        System.out.println(generateEpochDoc(date2).toString());
        System.out.println(isSameDay(date1, date2));
    }
}
