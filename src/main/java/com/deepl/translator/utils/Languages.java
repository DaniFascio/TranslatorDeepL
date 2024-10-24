package com.deepl.translator.utils;

import lombok.*;

@Getter
@AllArgsConstructor
public enum Languages {

    ZH("zh", "ZH-HANT"),
    EN("en", "EN-GB"),
    PT("pt", "PT-PT");

    public final String codeLang;
    public final String codeFixed;


}
