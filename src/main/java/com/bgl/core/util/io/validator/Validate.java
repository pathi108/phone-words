package com.bgl.core.util.io.validator;

import com.bgl.core.util.io.validator.exception.InvalidInputException;

public class Validate {
    static String onlyNumbersRegex = "\\d+";
    static String onlyLettersRegex = "^[a-zA-Z]*$";

    public static void validatePhoneNumber(String text) throws InvalidInputException {
        if (!text.matches(onlyNumbersRegex)) {
            throw new InvalidInputException("Phone Number Should Only contain numbers");
        }
    }

    public static void validateDictionary(String text) throws InvalidInputException {
        if (!text.matches(onlyLettersRegex)) {
            throw new InvalidInputException("Dictionary values Should Only contain numbers");
        }
    }
}
