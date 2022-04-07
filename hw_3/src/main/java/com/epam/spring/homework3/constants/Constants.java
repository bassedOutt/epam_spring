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
}
