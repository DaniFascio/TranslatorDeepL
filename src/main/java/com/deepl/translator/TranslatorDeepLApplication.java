package com.deepl.translator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

@SpringBootApplication
public class TranslatorDeepLApplication {

    private final String urlApi = "https://api-free.deepl.com";

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TranslatorDeepLApplication.class, args);
    }


}
