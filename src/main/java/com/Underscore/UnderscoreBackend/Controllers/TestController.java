package com.Underscore.UnderscoreBackend.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value = "/test")
    public String getData() {
        return "Underscore backend test endpoint is up and running!";
    }
}
