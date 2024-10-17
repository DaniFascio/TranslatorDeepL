package com.deepl.translator.controllers;

import com.deepl.translator.responses.DataResponse;
import com.deepl.translator.utils.FileUtil;
import com.deepl.translator.utils.Status;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileOutputStream;
import java.io.OutputStream;

@RestController
@Log4j2
@RequestMapping(value = "/translate")
public class TranslatorController {

    @Autowired
    private HttpServletRequest request;

    @PostMapping(path = "/file", produces = "application/json")
    public HttpEntity<?> login(@RequestBody FileUtil fileUtil) throws Exception {
        HttpEntity<?> httpEntity;

        byte[] data = Base64.decodeBase64(fileUtil.getContent().replace("data:text/plain;base64,",""));
        StringBuilder sb = new StringBuilder();
        try (OutputStream stream = new FileOutputStream("src/main/resources/export.txt")) {
            stream.write(data);
            sb.append(fileUtil.getContent());
        }

        return new HttpEntity<>(new DataResponse(fileUtil.getFileName(), sb.toString().replace("data:text/plain;base64,","")));
    }



    //        // File path is passed as parameter
//        File file = new File("src/main/resources/test.txt");
//
//        // Note:  Double backquote is to avoid compiler
//        // interpret words
//        // like \test as \t (ie. as a escape sequence)
//
//        // Creating an object of BufferedReader class
//        BufferedReader br = new BufferedReader(new FileReader(file));
//
//        // Declaring a string variable
//        String st;
//        // Condition holds true till
//        // there is character in a string
//        while ((st = br.readLine()) != null)
//
//            // Print the string
//            System.out.println(st);


}
