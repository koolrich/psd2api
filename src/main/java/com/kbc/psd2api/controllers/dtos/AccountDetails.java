package com.kbc.psd2api.controllers.dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(Include.NON_NULL)
public class AccountDetails {

    private Map<String, Object> header = new HashMap<>();
    private List<Account> body = new ArrayList<>();
    
}