package com.deepl.translator.utils;

import com.deepl.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TranslatorService {

    private final String authKey;

    public TranslatorService(@Value("${deepl.api.key}") String authKey) {
        this.authKey = authKey;
    }

    public String translateText(String text, String idCountry) throws Exception {
        Translator translator = new Translator(authKey);
        TextResult result = translator.translateText(text, "IT", idCountry);
        return (result.getText());
    }


}