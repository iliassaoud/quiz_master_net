import java.text.SimpleDateFormat;
import java.util.Date;

public class TimerUtils {
    public static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
    
    public static void sleep(int millis) {
        try { 
            Thread.sleep(millis); 
        } catch (InterruptedException e) { 
            Thread.currentThread().interrupt(); 
        }
    }
}