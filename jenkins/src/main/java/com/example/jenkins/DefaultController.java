package com.example.jenkins;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DefaultController {

    @GetMapping("/hello")
    private String DefaultStringApi() {
        return "Hello Jenkins!";
    }
}
