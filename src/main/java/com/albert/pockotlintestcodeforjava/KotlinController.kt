package com.albert.pockotlintestcodeforjava

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KotlinController(private val kotlinService: KotlinService) {

    @GetMapping("hey-kotlin")
    fun sayHello(): String {
        return kotlinService.sayHello()
    }
}