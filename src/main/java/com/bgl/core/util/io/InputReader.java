package com.bgl.core.util.io;

import com.bgl.core.util.config.exception.ConfigParserException;
import com.bgl.core.util.io.validator.Validate;
import com.bgl.core.util.io.validator.exception.InvalidInputException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    private static String regex = "[\\p{Punct}\\s]";

    public static List<String> loadInputFile(String filePath) throws IOException, InvalidInputException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String cleaned = removePunctuationAndSpaces(line);
                Validate.validatePhoneNumber(cleaned);
                lines.add(cleaned);
            }
        }
        return lines;
    }

    public static List<String> loadDictionary(String filePath) throws IOException, InvalidInputException, ConfigParserException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                Validate.validateDictionary(line);
                lines.add(line.toUpperCase());
            }
        }
        if (lines.isEmpty()) {
            throw new ConfigParserException("Dictionary cannot be empty");
        }

        return lines;
    }


    private static String removePunctuationAndSpaces(String input) {
        return input.replaceAll(regex, "");
    }

}
