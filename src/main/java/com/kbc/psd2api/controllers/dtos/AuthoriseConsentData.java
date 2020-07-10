package com.kbc.psd2api.controllers.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@JsonInclude(Include.NON_NULL)
public class AuthoriseConsentData {

    @JsonProperty("LinkedAccounts")
    private List<LinkedAccount> linkedAccounts = new ArrayList<>();

    @JsonProperty("CustomerId")
    private String customerId;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("ExternalUserId")
    private String externalUserId;

    @JsonProperty("Segment")
    private String segment;
    
}