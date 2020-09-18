package com.kbc.psd2api.controllers.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidatePayment {

    private String totalTxnWithCurrentTxn = "0";
    private String minimumSignatoryNo = "YES";
    private String companyDailyLimit = "5000.00";
    private String dailyLimitCheckPassed = "YES";
    private String mandateNoOfAuth = "1";
    private String mandateLimitAmount = "2500.00";
    private String mandateCheckPassed = "YES"; 
    
}