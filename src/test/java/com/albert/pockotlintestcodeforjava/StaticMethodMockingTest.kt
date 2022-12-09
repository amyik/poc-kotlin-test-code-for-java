package com.albert.pockotlintestcodeforjava

import io.mockk.every
import io.mockk.mockkStatic
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StaticMethodMockingTest {

    @Test
    internal fun staticMethodNotMocked() {
        assertThat(StaticMethodHolder.staticMethod()).isEqualTo("I am not mocked")
    }

    @Test
    internal fun staticMock() {
        mockkStatic(StaticMethodHolder::class) {
            every { StaticMethodHolder.staticMethod() } returns "Now I am mocked"
            assertThat(StaticMethodHolder.staticMethod()).isEqualTo("Now I am mocked")
        }
    }
}