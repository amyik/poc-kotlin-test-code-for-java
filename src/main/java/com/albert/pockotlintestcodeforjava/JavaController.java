package com.albert.pockotlintestcodeforjava;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JavaController {

    private final JavaService javaService;

    @GetMapping("hey-java")
    public String sayHello() {
        return javaService.sayHello();
    }
}
