package com.deepl.translator.services;

import com.deepl.api.*;
import com.deepl.translator.utils.Languages;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageService {

    private final String authKey;

    public LanguageService(@Value("${deepl.api.key}") String authKey) {
        this.authKey = authKey;
    }

    public List<Language> getSourceLanguages() throws Exception {
        Translator translator = new Translator(authKey);
        return translator.getSourceLanguages();
    }

    public List<Language> getTargetLanguages() throws Exception {
        Translator translator = new Translator(authKey);
        return translator.getTargetLanguages();
    }

    public String checkLanguageAcronym(String langCode){
        Languages[] languages = Languages.values();
        for (Languages language : languages) {
            if (language.getCodeLang().equals(langCode))
                return language.getCodeFixed();
        }

        return "";
    }


}