package com.albert.pockotlintestcodeforjava

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(JavaController::class)
class WebMvcTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    lateinit var javaService: JavaService

    @Test
    internal fun `컨트롤러 테스트`() {

        //given
        every { javaService.sayHello() } returns "Hello WebMvcTest"

        mockMvc.perform(get("/hey-java"))
            .andExpect(status().isOk)
            .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
            .andExpect(content().string("Hello WebMvcTest"))
    }
}