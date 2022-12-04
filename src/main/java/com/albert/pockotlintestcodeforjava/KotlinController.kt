package com.albert.pockotlintestcodeforjava

import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class KotlinController(private val kotlinService: KotlinService) {

    @GetMapping("hey-kotlin")
    fun sayHello(): String {
        return kotlinService.sayHello()
    }
}