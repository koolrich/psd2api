package com.kbc.psd2api.controllers.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateErrorResponse {
    private String type = "about.blank";
    private String status = "401";
    private String title = "Unauthorized";
    private String detail = "Not authorized to use this service";  
}