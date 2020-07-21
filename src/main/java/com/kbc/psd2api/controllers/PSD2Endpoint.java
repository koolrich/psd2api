package com.kbc.psd2api.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
        validateAuthorisationResponse.setConsentScope("accounts");
        validateAuthorisationResponse.setTppApplicationName("Business Banking QA");
        validateAuthorisationResponse.setConsentId("CNS20112D98X59NM"); 
        
        return ResponseEntity.ok(validateAuthorisationResponse);
    }

    @GetMapping("/internal-access/consents/{consentId}")
    public ResponseEntity<ConsentResponse> getConsentDetails(@PathVariable String consentId) {

        System.out.println("Get consent called with consentId: " + consentId);

        ConsentDetails consentDetails = new ConsentDetails();
        //consentDetails.setStatus("AUTHORISED");
        consentDetails.setStatus("AWAITING.AUTHORISATION");
        InstructedAmount instructedAmount = new InstructedAmount("20.00", "EUR");
        //List<LinkedAccount> linkedAccounts = Arrays.asList(new LinkedAccount("CurrentAccount", "IE10ICON99027012173"), new LinkedAccount("SavingsAccount", "IE55ICON99027011885911"));
        CreditorAccount creditorAccount = new CreditorAccount("IE10ICON99027012173", "Bob Clements");
        RemittanceInformation remittanceInformation = new RemittanceInformation("Internal ops code 5120103", "FRESCO-037");

        //List<String> permissions = new ArrayList<>();
        //permissions.add("READ.BALANCES");
        //permissions.add("READ.TRANSACTIONS.BASIC");
        //permissions.add("READ.TRANSACTIONS.DETAIL");
        //permissions.add("READ.ACCOUNTS.BASIC");
        //permissions.add("READ.ACCOUNTS.DETAIL");
        //permissions.add("READ.PAN");
        //permissions.add("READ.TRANSACTIONS.CREDITS");
        //permissions.add("READ.TRANSACTIONS.DEBITS");

        //consentDetails.setPermissions(permissions);

        consentDetails.setInstructedAmount(instructedAmount);
        //consentDetails.setLinkedAccounts(linkedAccounts);
        consentDetails.setCreditorAccount(creditorAccount);
        consentDetails.setRemittanceInformation(remittanceInformation);

        ConsentResponse consentResponse = new ConsentResponse();
        consentResponse.setConsentDetails(consentDetails);

        return ResponseEntity.ok(consentResponse);

    }

    @PatchMapping("/internal-access/consents/{consentId}")
    public ResponseEntity<?> authoriseConsent(@RequestBody AuthoriseConsentRequest authoriseConsentRequest, @PathVariable String consentId) {
        System.out.println("Received request: " + authoriseConsentRequest.toString());
        return ResponseEntity.ok("received");
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

    @GetMapping("/corppymnt")
    public ResponseEntity<ValidatePaymentResponse> authoriseConsent() {
        ValidatePaymentResponse validatePaymentResponse = new ValidatePaymentResponse();
        ValidatePayment validatePayment = new ValidatePayment();
        validatePayment.setDailyLimitCheckPassed("YES");
        validatePayment.setMandateCheckPassed("YES");

        List<ValidatePayment> validatePayments = new ArrayList<>();
        validatePayments.add(validatePayment);

        Map<String, Object> header = new HashMap<>();
        Map <String, String> audit = new HashMap<>();

        audit.put("T24_time", "4043");
        audit.put("parse_time", "22");
        header.put("audit", audit);
        header.put("page_start", "1");
        header.put("page_token", "52e21c07-761a-43c4-818d-7c32bbf4f6c3");
        header.put("total_size", "2");
        header.put("page_size", "99");

        validatePaymentResponse.setHeader(header);
        validatePaymentResponse.setBody(validatePayments);
        
        return ResponseEntity.ok(validatePaymentResponse);
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