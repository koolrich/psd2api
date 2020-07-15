package com.kbc.psd2api.controllers.dtos;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(Include.NON_NULL)
public class ConsentDetails {

    @JsonProperty("ClientId")
    private String ClientId = "2c7a008c946a11ea84800aee602f0000";

    @JsonProperty("ConsentId")
    private String ConsentId = "CNS2012032XDK3XW";

    @JsonProperty("ConsentScope")
    private String ConsentScope = "fundsconfirmations";

    @JsonProperty("TPPApplicationName")
    private String TPPApplicationName = "Business Banking QA";

    @JsonProperty("CreationDateTime")
    private String CreationDateTime = "2020-05-21T16:49:44Z";

    @JsonProperty("StatusUpdateDateTime")
    private String StatusUpdateDateTime = "2020-05-21T16:49:44Z";

    @JsonProperty("Status")
    private String Status = "AWAITING.AUTHORISATION";

    @JsonProperty("ExpirationDateTime")
    private String ExpirationDateTime = "2020-09-09T07:58:51Z";

    @JsonProperty("TransactionFromDateTime")
    private String TransactionFromDateTime = "2020-08-09T07:58:51Z";

    @JsonProperty("TransactionToDateTime")
    private String TransactionToDateTime = "2020-09-09T07:58:51Z";

    @JsonProperty("PaymentSubType")
    private String PaymentSubType = "DomesticSingle";

    @JsonProperty("InstructedAmount")
    private InstructedAmount instructedAmount;

    @JsonProperty("LinkedAccounts")
    private List<LinkedAccount> linkedAccounts;

    @JsonProperty("CreditorAccount")
    private CreditorAccount creditorAccount;

    @JsonProperty("RemittanceInformation")
    private RemittanceInformation remittanceInformation;

    @JsonProperty("Permissions")
    private List<String> permissions;
    
}