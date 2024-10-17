package com.deepl.translator.utils;

import com.deepl.api.*;

public class TranslatorUtil {
    Translator translator;

    public TranslatorUtil(String text, String idCountry) throws Exception {
        String authKey = "";  // Replace with your key
        translator = new Translator(authKey);

        TextResult result = translator.translateText(text, "it", idCountry);
        System.out.println(result.getText());

    }




}