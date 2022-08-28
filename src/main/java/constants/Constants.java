package constants;

public class Constants {
    /**
     * Clear browser cookies after each iteration
     */

    public static final Boolean CLEAR_COOKIES_AND_STORAGE = true;


    public static class TimeoutVariable{
        public static final int IMPLICIT_WAIT = 4;
        public static final int PAGE_LOAD_WAIT = 10;
        public static final int EXPLICIT_WAIT = 10;
    }

    public static class Urls{
        public static final String ROZETKA_PAGE = "https://rozetka.com.ua/";
        public static final String HOST_URL = "http://localhost:4444/wd/hub/";

    }
}
