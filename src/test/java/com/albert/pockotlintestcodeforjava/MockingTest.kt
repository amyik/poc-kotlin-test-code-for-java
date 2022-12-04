package com.albert.pockotlintestcodeforjava

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify

class MockingTest {

    private val javaRepository: JavaRepository = mockk()
    private val javaService2: JavaService2 = JavaService2(javaRepository)

    @Test
    internal fun `Mocking 테스트`() {

        //given
        every { javaRepository.sayHello() } returns "Hello Mocking"

        //when
        val result = javaService2.sayHello();

        //then
        verify(exactly = 1) { javaRepository.sayHello() }
        assertThat(result).isEqualTo("Hello Mocking")
    }
}