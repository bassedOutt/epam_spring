package com.epam.spring.homework3.constants;


public class Constants {

    public static final int ROWS = 5;
    public static final int SEATS_PER_ROW = 10;

    public enum SESSION_SORTERS {
        BY_NAME("name"),
        BY_TIME("time"),
        BY_SEATS("seats");

        private final String sorter;


        SESSION_SORTERS(final String sorter) {
            this.sorter = sorter;
        }

        @Override
        public String toString() {
            return sorter;
        }
    }

    public static String USER = "USER";
    public static String ADMIN = "ADMIN";

    public static final String LOGIN_PATH = "/api/v1/login";
    public static final String TOKEN_REFRESH_PATH = "/api/v1/user/token/refresh";
    public static final String ROLE_CLAIM = "roles";
    public static final String API_URL = "api/v1";

}
