package com.albert.pockotlintestcodeforjava

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class MockingAnnotationTest {

    @MockK
    private lateinit var javaRepository: JavaRepository
    @InjectMockKs
    private lateinit var javaService2: JavaService2

    @Test
    internal fun `Mocking 테스트`() {

        //given
        every { javaRepository.sayHello() } returns "Hello Mocking"

        //when
        val result = javaService2.sayHello()

        //then
        verify(exactly = 1) { javaRepository.sayHello() }
        assertThat(result).isEqualTo("Hello Mocking")
    }
}