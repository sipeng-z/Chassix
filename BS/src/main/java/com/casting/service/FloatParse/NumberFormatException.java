package com.casting.service.FloatParse;

public class NumberFormatException extends IllegalArgumentException{


    private static final long serialVersionUID = 1L;

    public NumberFormatException(String s) {
        super(s);
    }

    static NumberFormatException forInputString(String s) {
        return new NumberFormatException("For input string: \"" + s + "\"");
    }

    }
