package com.bgl.core.util.config.exception;

public class ConfigParserException extends Exception{



    public ConfigParserException(String message){
        super("Cannot Parse parameters : "+message);
    }
}
