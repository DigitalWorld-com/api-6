package com.digitalworlds.api6.base.controllers;
import com.digitalworlds.api6.base.services.MyApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyApiController {
    private final MyApiService myApiService;

    @Autowired
    public MyApiController(MyApiService myApiService) {
        this.myApiService = myApiService;
    }

    @GetMapping("/museos")
    public void consumeApi() {
        myApiService.consumirApi();
    }
}
