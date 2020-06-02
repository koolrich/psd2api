package com.kbc.psd2api.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class InstructedAmount {

    @JsonProperty("Amount")
    public String Amount;

    @JsonProperty("Currency")
    public String Currency;

    public InstructedAmount(String amount, String currency) {
        Amount = amount;
        Currency = currency;
    }
    
    
    
}