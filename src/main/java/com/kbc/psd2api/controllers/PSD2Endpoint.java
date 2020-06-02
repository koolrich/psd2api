package com.kbc.psd2api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kbc.psd2api.controllers.dtos.*;

@RestController
@RequestMapping("/kbci/v1.0/internal")
public class PSD2Endpoint {

    @GetMapping("/internal-access-Validate-Authorisation-Request")
    public ResponseEntity<ValidateAuthorisationResponse> validateAuthorisation(HttpServletRequest httpServletRequest) {

        String responseType = httpServletRequest.getHeader("response_type");
        System.out.println("response_type" + responseType);
        String clientId = httpServletRequest.getHeader("client_id");
        System.out.println("client_id" + clientId);
        String redirectUrl = httpServletRequest.getHeader("redirect_uri");
        System.out.println("redirect_uri" + redirectUrl);
        String scope = httpServletRequest.getHeader("scope");
        System.out.println("scope" + scope);
        String state = httpServletRequest.getHeader("state");
        System.out.println("state" + state);
        String jwsToken = httpServletRequest.getHeader("request");
        System.out.println("request" + jwsToken);

        if (!isAllPresent(responseType, clientId, redirectUrl, scope, jwsToken)){
            System.out.println("Not all mandatory fields present");
            return ResponseEntity.badRequest().body(new ValidateAuthorisationResponse());
        }

        ValidateAuthorisationResponse validateAuthorisationResponse = new ValidateAuthorisationResponse();
        validateAuthorisationResponse.setClientId("2c7a008c946a11ea84800aee602f0000");
        validateAuthorisationResponse.setConsentScope("payments");
        validateAuthorisationResponse.setTppApplicationName("Business Banking QA");
        validateAuthorisationResponse.setConsentId("CNS20112D98X59NM"); 
        
        return ResponseEntity.ok(validateAuthorisationResponse);
    }

    @GetMapping("/internal-access/consents/{consentId}")
    public ResponseEntity<ConsentDetails> getConsentDetails(@PathVariable String consentId) {

        System.out.println("Get consent called with consentId: " + consentId);

        ConsentDetails consentDetails = new ConsentDetails();
        InstructedAmount instructedAmount = new InstructedAmount("20.00", "EUR");
        List<LinkedAccount> linkedAccounts = Arrays.asList(new LinkedAccount("CurrentAccount", "IE02ICON99027011885895"));
        CreditorAccount creditorAccount = new CreditorAccount("IE55ICON99027011885911", "Bob Clements");
        RemittanceInformation remittanceInformation = new RemittanceInformation("Internal ops code 5120103", "FRESCO-037");

        consentDetails.setInstructedAmount(instructedAmount);
        consentDetails.setLinkedAccounts(linkedAccounts);
        consentDetails.setCreditorAccount(creditorAccount);
        consentDetails.setRemittanceInformation(remittanceInformation);

        return ResponseEntity.ok(consentDetails);

    }

    @GetMapping("/accounts")
    public ResponseEntity<AccountDetails> getAccounts() {
        AccountDetails accountDetails = new AccountDetails();
        List<Account> accounts = new ArrayList<>();

        Account account = new Account();
        account.setArrangementId("AA19274DRMT8");
        account.setProductId("1007");
        account.setAccountTitle("KBC Basic Current Account");
        account.setNickName("MICKEY MOUSE");
        account.setAccountType("CA Basic");
        account.setCurrentBalance("6483.80");
        account.setAccountIban("IE60ICON99027013046");
        account.setSortCode("990270");
        account.setAvailableBalance("6423.80");
        account.setAcctNumber("13046038");
        account.setAccountDetails("13046038 MICKEY MOUSE");
        account.setCurrency("EUR");
        account.setOdLimit(0);
        account.setAccountTransRights("NO");
        account.setCustomer("1000000013");

        accounts.add(account);

        account = new Account();
        account.setArrangementId("AA15052635LH");
        account.setProductId("1002");
        account.setAccountTitle("KBC Current Account");
        account.setNickName("MICKEY MOUSE");
        account.setAccountType("Cur Acc with OD");
        account.setCurrentBalance("279.77");
        account.setAccountIban("IE33ICON99027081452");
        account.setSortCode("990270");
        account.setAvailableBalance("279.80");
        account.setAcctNumber("81452379");
        account.setAccountDetails("81452379 MICKEY MOUSE");
        account.setCurrency("EUR");
        account.setOdLimit(0);
        account.setAccountTransRights("NO");
        account.setCustomer("1000025769");

        accounts.add(account);

        Map<String, Object> header = new HashMap<>();
        Map <String, String> audit = new HashMap<>();

        audit.put("T24_time", "4043");
        audit.put("parse_time", "22");
        header.put("audit", audit);
        header.put("page_start", "1");
        header.put("page_token", "52e21c07-761a-43c4-818d-7c32bbf4f6c3");
        header.put("total_size", "2");
        header.put("page_size", "99");

        accountDetails.setHeader(header);
        accountDetails.setBody(accounts);

        return ResponseEntity.ok(accountDetails);

    }

    private boolean isAllPresent(String... values) {
        for (String value : values) {
            if (value == null || value == "null") {
                return false;
            }

            if (value.isEmpty()) {
                return false;
            }
        }
        return true;
    }

}