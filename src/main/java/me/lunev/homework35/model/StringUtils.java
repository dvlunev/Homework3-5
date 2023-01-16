package me.lunev.homework35.model;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNullBlankOrEmpty(String s) {
        return s == null || s.isBlank() || s.isEmpty();
    }
}
