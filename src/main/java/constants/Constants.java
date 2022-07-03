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
        public static final String ZAKUPKA_CATALOG_PAGE = "https://zakupka.com";
        public static final String SATOM_CATALOG_PAGE = "https://satom.ru";
        public static final String BY_CATALOG_PAGE = "https://tomas.by";
        public static final String KZ_CATALOG_PAGE = "https://tomas.kz";
    }
}
