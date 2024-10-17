package com.deepl.translator.controllers;

import com.deepl.translator.responses.LanguageResponse;
import com.deepl.translator.utils.Languages;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Log4j2
@RequestMapping(value = "/language")
public class LanguageController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping(path = "/getAll", produces = "application/json")
    public HttpEntity<?> login() throws Exception {
        HttpEntity<?> httpEntity;

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
