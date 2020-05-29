package com.kbc.psd2api.controllers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(Include.NON_NULL)
public class ValidateAuthorisationResponse {

    @JsonProperty("ClientId")
    private String ClientId;

    @JsonProperty("ConsentScope")
    private String ConsentScope;

    @JsonProperty("TppApplicationName")
    private String TppApplicationName;

    @JsonProperty("ConsentId")
    private String ConsentId;   
}