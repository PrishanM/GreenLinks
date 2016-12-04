package com.evensel.greenlinks.utils;

/**
 * Created by Prishan Maduka on 12/4/2016.
 */
public class ValidatorUtil {

    public static boolean isEmptyText(String text){
        return text.isEmpty();
    }

    public static boolean isValidTextLength(String text,int length){
        if(text.length()!=length){
            return false;
        }else {
            return true;
        }
    }
}
