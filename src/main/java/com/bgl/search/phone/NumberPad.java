package com.bgl.search.phone;

import java.util.*;

public class NumberPad {
    private static HashMap<String, List<Character>> buttonLettersByDigit = new HashMap<>();


    public static List<Character> get(String digit) {
        if (buttonLettersByDigit.isEmpty()) {
            init();
        }
        List<Character> characters = buttonLettersByDigit.get(digit);
        return characters == null ? Collections.emptyList() : characters;
    }

    public static void init() {
        buttonLettersByDigit.put("2", Arrays.asList('A', 'B', 'C'));
        buttonLettersByDigit.put("3", Arrays.asList('D', 'E', 'F'));
        buttonLettersByDigit.put("4", Arrays.asList('G', 'H', 'I'));
        buttonLettersByDigit.put("5", Arrays.asList('J', 'K', 'L'));
        buttonLettersByDigit.put("6", Arrays.asList('M', 'N', 'O'));
        buttonLettersByDigit.put("7", Arrays.asList('P', 'Q', 'R', 'S'));
        buttonLettersByDigit.put("8", Arrays.asList('T', 'U', 'V'));
        buttonLettersByDigit.put("9", Arrays.asList('W', 'X', 'Y', 'Z'));
    }

}
