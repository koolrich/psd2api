package com.kbc.psd2api.controllers.dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidatePaymentResponse {

    private Map<String, Object> header = new HashMap<>();
    private List<ValidatePayment> body = new ArrayList<>(); 
}