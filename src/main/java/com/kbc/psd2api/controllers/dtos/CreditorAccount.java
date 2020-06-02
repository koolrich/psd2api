package com.kbc.psd2api.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class CreditorAccount {

    @JsonProperty("Identification")
    private String Identification;

    @JsonProperty("Name")
    private String Name;

    public CreditorAccount(String identification, String name) {
        Identification = identification;
        Name = name;
    }

    
    
}