package com.deepl.translator.utils;

import lombok.*;

@Getter
@AllArgsConstructor
public enum Languages {

    ARABO("AR", "Arabo"),
    BULGARO("BG", "Bulgaro"),
    CECO("CS", "Ceco"),
    CINESE("ZH-HANT", "Cinese"),
    COREANO("KO", "Coreano"),
    DANESE("DA", "Danese"),
    ESTONE("ET", "Estone"),
    FINLANDESE("FI", "Finlandese"),
    FRANCESE("FR", "Francese"),
    GIAPPONESE("JA", "Giapponese"),
    GRECO("EL", "Greco"),
    INDONESIANO("ID", "Indonesiano"),
    INGLESE("EN-GB", "Inglese"),
    ITALIANO("IT", "Italiano"),
    LETTONE("LV", "Lettone"),
    LITUANO("LT", "Lituano"),
    NORVEGESE("NB", "Norvegese"),
    OLANDESE("NL", "Olandese"),
    POLACCO("PL", "Polacco"),
    PORTOGHESE("PT-PT", "Portoghese"),
    RUMENO("RO", "Rumeno"),
    RUSSO("RU", "Russo"),
    SLOVACCO("SK", "Slovacco"),
    SLOVENO("SL", "Sloveno"),
    SPAGNOLO("ES", "Spagnolo"),
    SVEDESE("SV", "Svedese"),
    TEDESCO("DE", "Tedesco"),
    TURCO("TR", "Turco"),
    UCRAINO("UK", "Ucraino"),
    UNGARO("HU", "Ungaro");


    public final String idLanguage;
    public final String description;




}
