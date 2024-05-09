package com.bgl;

import com.bgl.core.util.config.Config;
import com.bgl.core.util.config.exception.ConfigParserException;
import com.bgl.core.util.config.parser.ConfigParser;
import com.bgl.core.util.io.InputReader;
import com.bgl.core.util.io.validator.exception.InvalidInputException;
import com.bgl.search.PhoneWordDictionary;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

        Config config = ConfigParser.parse(args);


        List<String> inputs = InputReader.loadInputFile(config.getInputFilePath());

        List<String> dictionary = InputReader.loadDictionary(config.getDictionaryFilePath());

        PhoneWordDictionary phoneWordDictionaryTree = new PhoneWordDictionary();
        dictionary.forEach(phoneWordDictionaryTree::insert);

        inputs.forEach(input->phoneWordDictionaryTree.getPhoneWordsFor(input)
                .forEach(System.out::println));

        } catch (IOException e) {
            System.out.println("Cannot read file : "+e.getMessage());
        } catch (ConfigParserException | InvalidInputException e) {
            System.out.println(e.getMessage());
        }

    }


    
}
