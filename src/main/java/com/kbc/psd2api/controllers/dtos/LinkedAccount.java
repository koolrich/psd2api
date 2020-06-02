package com.kbc.psd2api.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class LinkedAccount {

    @JsonProperty("AccountSubtype")
    private String AccountSubtype;

    @JsonProperty("AccountIdentifier")
    private String AccountIdentifier;

    public LinkedAccount(String accountSubtype, String accountIdentifier) {
        AccountSubtype = accountSubtype;
        AccountIdentifier = accountIdentifier;
    }

    
    
}