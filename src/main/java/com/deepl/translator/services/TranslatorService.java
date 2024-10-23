package com.deepl.translator.services;

import com.deepl.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Usage getusage() throws Exception {
        Translator translator = new Translator(authKey);
        return translator.getUsage();
    }

    public List<Language> getLanguages() throws Exception {
        Translator translator = new Translator(authKey);
        return translator.getLanguages(LanguageType.Source);
    }


}