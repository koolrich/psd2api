package com.kbc.psd2api.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.val;

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