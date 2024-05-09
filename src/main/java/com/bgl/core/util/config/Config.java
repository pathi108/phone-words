package com.bgl.core.util.config;

public class Config {
    private final String dictionaryFilePath;
    private final String inputFilePath;

    public Config(String dictionaryFilePath, String inputFilePath) {
        this.dictionaryFilePath = dictionaryFilePath;
        this.inputFilePath = inputFilePath;
    }

    public String getDictionaryFilePath() {
        return dictionaryFilePath;
    }

    public String getInputFilePath() {
        return inputFilePath;
    }
}
