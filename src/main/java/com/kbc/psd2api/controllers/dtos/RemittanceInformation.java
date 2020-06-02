package com.kbc.psd2api.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class RemittanceInformation {

    @JsonProperty("Unstructured")
    private String Unstructured;

    @JsonProperty("Reference")
    private String Reference;

    public RemittanceInformation(String unstructured, String reference) {
        Unstructured = unstructured;
        Reference = reference;
    }    
    
}