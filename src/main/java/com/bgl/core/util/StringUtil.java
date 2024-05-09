package com.bgl.core.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {


    public static boolean containsMoreThanOneNumber(String input) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        int count = 0;
        while (matcher.find()) {
            count++;
            if (count > 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean endsWithAHyphen(String word) {
        return !word.isEmpty() && ('-' == word.charAt(word.length() - 1));


    }

    public static String leaveDigit(String word, String digit) {

        if ((word.length() != 0) && ('-' != word.charAt(word.length() - 1))) {
            word = word + "-";
        }
        return word + digit;
    }
}
