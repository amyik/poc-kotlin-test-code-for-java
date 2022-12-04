package com.albert.pockotlintestcodeforjava;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JavaService2 {

    private final JavaRepository javaRepository;

    public String sayHello(){
        return javaRepository.sayHello();
    }
}
