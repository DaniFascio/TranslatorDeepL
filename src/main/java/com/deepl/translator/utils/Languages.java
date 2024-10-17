package com.deepl.translator.utils;

import lombok.*;

@Getter
@AllArgsConstructor
public enum Languages {

    ARABO("AR", "Arabo"),
    BULGARO("BG", "Bulgaro"),
    CECO("CS", "Ceco"),
    DANESE("DA", "Danese"),
    TEDESCO("DE", "Tedesco"),
    GRECO("EL", "Greco"),
    INGLESE("EN", "Inglese"),
    SPAGNOLO("ES", "Spagnolo"),
    ESTONE("ET", "Estone"),
    FINLANDESE("FI", "Finlandese"),
    FRANCESE("FR", "Francese"),
    UNGARO("HU", "Ungaro"),
    INDONESIANO("ID", "Indonesiano"),
    ITALIANO("IT", "Italiano"),
    GIAPPONESE("JA", "Giapponese"),
    COREANO("KO", "Coreano"),
    LITUANO("LT", "Lituano"),
    LETTONE("LV", "Lettone"),
    NORVEGESE("NB", "Norvegese"),
    OLANDESE("NL", "Olandese"),
    POLACCO("PL", "Polacco"),
    PORTOGHESE("PT", "Portoghese"),
    RUMENO("RO", "Rumeno"),
    RUSSO("RU", "Russo"),
    SLOVACCO("SK", "Slovacco"),
    SLOVENO("SL", "Sloveno"),
    SVEDESE("SV", "Svedese"),
    TURCO("TR", "Turco"),
    UCRAINO("UK", "Ucraino"),
    CINESE("ZH", "Cinese");


    public final String idLanguage;
    public final String description;




}
