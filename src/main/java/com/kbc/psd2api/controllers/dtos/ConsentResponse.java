package com.kbc.psd2api.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsentResponse {

    @JsonProperty("Data")
    private ConsentDetails consentDetails;
    
}