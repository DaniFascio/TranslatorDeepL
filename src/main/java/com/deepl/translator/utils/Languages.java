package com.deepl.translator.utils;

import lombok.*;

@Getter
@AllArgsConstructor
public enum Languages {

    ARABIAN("AR", "Arabian"),
    BULGARIAN("BG", "Bulgarian"),
    CZECH("CS", "Czech"),
    CHINESE("ZH-HANT", "Chinese"),
    KOREAN("KO", "Korean"),
    DANISH("DA", "Danish"),
    ESTONIAN("ET", "Estonian"),
    FINNISH("FI", "Finnish"),
    FRENCH("FR", "French"),
    JAPANESE("JA", "Japanese"),
    GREEK("EL", "Greek"),
    INDONESIAN("ID", "Indonesian"),
    ENGLISH("EN-GB", "English"),
    ITALIAN("IT", "Italian"),
    LATVIAN("LV", "Latvian"),
    LITHUANIAN("LT", "Lithuanian"),
    NORWEGIAN("NB", "Norwegian"),
    DUTCH("NL", "Dutch"),
    POLISH("PL", "Polish"),
    PORTUGUESE("PT-PT", "Portuguese"),
    ROMANIAN("RO", "Romanian"),
    RUSSIAN("RU", "Russian"),
    SLOVAK("SK", "Slovak"),
    SLOVENIAN("SL", "Slovenian"),
    SPANISH("ES", "Spanish"),
    SWEDISH("SV", "Swedish"),
    GERMAN("DE", "German"),
    TURKISH("TR", "Turkish"),
    UKRAINIAN("UK", "Ukrainian"),
    HUNGARIAN("HU", "Hungarian");


    public final String idLanguage;
    public final String description;


}
