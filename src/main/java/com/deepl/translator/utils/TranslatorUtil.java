package com.deepl.translator.utils;

import com.deepl.api.*;
import org.springframework.beans.factory.annotation.Value;

public class TranslatorUtil {

    @Value("${deepl.api.key}")
    private static String authKey;

    public static String translateText(String text, String idCountry) throws Exception {
        Translator translator = new Translator("");

        TextResult result = translator.translateText(text, "IT", idCountry);
        return (result.getText());
    }




}