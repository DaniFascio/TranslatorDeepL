package com.deepl.translator.controllers;

import com.deepl.translator.responses.DataResponse;
import com.deepl.translator.services.LanguageService;
import com.deepl.translator.utils.FileUtil;
import com.deepl.translator.services.TranslatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@RestController
@Log4j2
@RequestMapping(value = "/translate")
public class TranslatorController {

    private final TranslatorService translatorService;

    private final LanguageService languageService;

    private static final Pattern KV_REGEX = Pattern.compile("^.*?\"(.*)\"\\s*:\\s*\"(.*)\".*?$");

    @PostMapping(path = "/file", produces = "application/json")
    public HttpEntity<?> translateFile(@RequestBody FileUtil fileUtil) throws Exception {
        StringBuilder responseBuilder = new StringBuilder();

        String fileName = fileUtil.getFileName().replace(".txt", "") + "_" + fileUtil.getLanguage() + ".txt";
        byte[] inputFileData = Base64.getDecoder().decode(fileUtil.getContent().replace("data:text/plain;base64,", ""));
        String temporaryFile = (System.getProperty("java.io.tmpdir") + fileName);
        String codeLang = languageService.checkLanguageAcronym(fileUtil.getLanguage());
        if (!codeLang.isEmpty())
            fileUtil.setLanguage(codeLang);

        try (OutputStream stream = new FileOutputStream(temporaryFile)) {
            stream.write(inputFileData);

            BufferedReader reader = new BufferedReader(new FileReader(temporaryFile));
            String fileLine = reader.readLine();

            log.info("TRANSLATION STARTED: IT --> {}", fileUtil.getFileName() + " " + fileUtil.getLanguage() + " ...");

            while (fileLine != null) {
                Matcher matcher = KV_REGEX.matcher(fileLine);
                fileLine = reader.readLine();

                if (!matcher.matches()) {
                    System.out.println("No match: " + fileLine);
                    continue;
                }

                String key = matcher.group(1);
                String value = matcher.group(2);

                String valueTranslated = translatorService.translateText(value, fileUtil.getLanguage()).replace("'", "\"");

                responseBuilder.append("\"").append(key).append("\"").append(": ").append("\"").append(valueTranslated).append("\"").append(",").append("\n");

            }

            log.info("TRANSLATION COMPLETED --> {}", fileName);
            return new HttpEntity<>(new DataResponse(fileName, responseBuilder.toString()));
        }
    }

    @GetMapping(path = "/getUsage")
    public HttpEntity<?> remainingChars() throws Exception {
        return new HttpEntity<>(translatorService.getUsage());
    }

}
