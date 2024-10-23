package com.deepl.translator.controllers;

import com.deepl.translator.responses.LanguageResponse;
import com.deepl.translator.services.TranslatorService;
import com.deepl.translator.utils.Languages;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping(value = "/language")
public class LanguageController {

    private final TranslatorService translatorService;

//    @GetMapping(path = "/getAll", produces = "application/json")
//    public HttpEntity<?> getAllLanguages() throws Exception {
//        List<LanguageResponse> list = new ArrayList<>();
//        Languages[] languages = Languages.values();
//
//        for (Languages language : languages){
//            LanguageResponse languageResponse = new LanguageResponse();
//            languageResponse.setIdLanguage(language.getIdLanguage());
//            languageResponse.setDescription(language.getDescription());
//            list.add(languageResponse);
//        }
//
//        return new HttpEntity<>(list);
//    }

    @GetMapping(path = "/getAll", produces = "application/json")
    public HttpEntity<?> getAllLanguages() throws Exception {
        List<LanguageResponse> list = new ArrayList<>();
        Languages[] languages = Languages.values();

        for (Languages language : languages){
            LanguageResponse languageResponse = new LanguageResponse();
            languageResponse.setIdLanguage(language.getIdLanguage());
            languageResponse.setDescription(language.getDescription());
            list.add(languageResponse);
        }

        return new HttpEntity<>(list);
    }


}
