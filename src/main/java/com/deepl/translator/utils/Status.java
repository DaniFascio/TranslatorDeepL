package com.deepl.translator.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Status {

    OK(0, "OK"),
    ERROR(-1, "ERROR");

    public final Integer idStatus;
    public final String description;




}
