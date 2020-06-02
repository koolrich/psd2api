package com.kbc.psd2api.controllers.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(Include.NON_NULL)
public class Account {

    private String arrangementId;
    private String productId;
    private String accountTitle;
    private String nickName;
    private String accountType;
    private String currentBalance;
    private String accountIban;
    private String sortCode;
    private String availableBalance;
    private String acctNumber;
    private String accountDetails;
    private String currency;
    private Integer odLimit;
    private String accountTransRights;
    private String customer;   
}