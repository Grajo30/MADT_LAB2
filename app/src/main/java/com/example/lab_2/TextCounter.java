package com.example.lab_2;

public class TextCounter {
    public static int getCharsCount(String text){
        return text.length();
    }

    public static int getWordsCount(String text) {
        int spaceCount = text.split(" ").length;
        int dotCount = text.split(".").length;
        int commaCount = text.split(",").length;

        return spaceCount+dotCount+commaCount;
    }
}
