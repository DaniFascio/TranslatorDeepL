package com.deepl.translator.controllers;

import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import com.deepl.translator.responses.DataResponse;
import com.deepl.translator.utils.FileUtil;
import com.deepl.translator.utils.TranslatorUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@Log4j2
@RequestMapping(value = "/translate")
public class TranslatorController {

    @Autowired
    private HttpServletRequest request;

    private static final Pattern KV_REGEX = Pattern.compile("^.*?\"(.*)\"\\s*:\\s*\"(.*)\".*?$");

    @PostMapping(path = "/file", produces = "application/json")
    public HttpEntity<?> login(@RequestBody FileUtil fileUtil) throws Exception {
        HttpEntity<?> httpEntity;
        StringBuilder responseBuilder = new StringBuilder();

        String fileName = fileUtil.getFileName().replace(".txt", "") + "_" + fileUtil.getLanguage() + ".txt";
        byte[] inputFileData = Base64.getDecoder().decode(fileUtil.getContent().replace("data:text/plain;base64,", ""));
        String temporaryFile = (System.getProperty("java.io.tmpdir") + fileName);

        try (OutputStream stream = new FileOutputStream(temporaryFile)) {
            stream.write(inputFileData);

            BufferedReader reader = new BufferedReader(new FileReader(temporaryFile));
            String fileLine = reader.readLine();

            log.info("inizio traduzione...");

            while (fileLine != null) {
                Matcher matcher = KV_REGEX.matcher(fileLine);
                fileLine = reader.readLine();

                if (!matcher.matches()) {
                    System.out.println("No match");
                    continue;
                }

                String key = matcher.group(1);
                String value = matcher.group(2);

                String valueTranslated = TranslatorUtil.translateText(value, fileUtil.getLanguage());

                responseBuilder.append("\"").append(key).append("\"").append(": ").append("\"").append(valueTranslated).append("\"").append(",").append("\n");

            }

            log.info("fine traduzione");

//            File inputFile = new File(temporaryFile);
//            if (inputFile.delete()) {
//                System.out.println("File deleted: " + inputFile.getName());
//            } else {
//                System.out.println("Delete failed.");
//            }

            return new HttpEntity<>(new DataResponse(fileName, responseBuilder.toString()));
        }
    }

}
