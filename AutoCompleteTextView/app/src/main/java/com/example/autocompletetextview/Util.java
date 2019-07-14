package com.example.autocompletetextview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static String[] REPLACES = {"a", "e", "i", "o", "u", "c"};
    public static Pattern[] PATTERN = null;
    public static void compilePatterns(){
        PATTERN = new Pattern[REPLACES.length];
        PATTERN[0] = Pattern.compile("[áãâà]", Pattern.CASE_INSENSITIVE);
        PATTERN[1] = Pattern.compile("[éèâ]", Pattern.CASE_INSENSITIVE);
        PATTERN[2] = Pattern.compile("[íìî]", Pattern.CASE_INSENSITIVE);
        PATTERN[3] = Pattern.compile("[óòôõ]", Pattern.CASE_INSENSITIVE);
        PATTERN[4] = Pattern.compile("[úùû]", Pattern.CASE_INSENSITIVE);
        PATTERN[5] = Pattern.compile("[ç]", Pattern.CASE_INSENSITIVE);
    }

    public static String removeAcentos(String text){
        if(PATTERN == null){
            compilePatterns();
        }
        String result = text;
        for (int i=0; i <PATTERN.length; i++){
            Matcher matcher = PATTERN[i].matcher(result);
            result = matcher.replaceAll(REPLACES[i]);
        }
        return result.toUpperCase();
    }

}
