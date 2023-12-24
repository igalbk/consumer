package com.bakshan.client.controllers;

import _com.bakshan_.client.ApiException;
import _com.bakshan_.client.controllers.HomeControllerApi;
import _com.bakshan_.client.models.ResponseRecord;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    HomeControllerApi client;
    public TestController(){
        client = new HomeControllerApi();
        client.setCustomBaseUrl("http://localhost:8080");
    }

    @Operation(summary = "Get Age next year", description = "I know the future")
    @GetMapping(path = "/test")
    public String getSomething() throws ApiException {

        ResponseRecord epochTimestamp = client.getSomething("Igal",40);
        return String.format("%s's age next year is: %d",epochTimestamp.getName(),epochTimestamp.getAgeNextYear());

    }

}
