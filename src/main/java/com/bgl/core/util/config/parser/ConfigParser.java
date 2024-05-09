package com.bgl.core.util.config.parser;

import com.bgl.core.util.config.Config;
import com.bgl.core.util.config.exception.ConfigParserException;

import java.util.HashMap;
import java.util.Map;

public class ConfigParser {

    public static Config parse(String args[]) throws ConfigParserException {

        Map<String, String> configs = new HashMap<>();
        String inputFilePath;
        String dictionaryPath;

        if (args.length != 2) {
            throw new ConfigParserException("There should be two parameters passed.Please pass the phone number file path along with the dictionary file path");
        }

        for (int i = 0; i < args.length; i++) {
            String path = args[i];
            String[] splitted = path.split("=");
            if(splitted.length==2) {
                configs.put(splitted[0], splitted[1]);
            }
        }

        inputFilePath = configs.get("input");
        dictionaryPath = configs.get("dictionary");

        if (configs.get("dictionary") == null) {
            throw new ConfigParserException("The file path to the dictionary not provided ");
        }

        if (configs.get("input") == null) {
            throw new ConfigParserException("The file path to the input not provided ");
        }

        return new Config(dictionaryPath, inputFilePath);
    }
}
