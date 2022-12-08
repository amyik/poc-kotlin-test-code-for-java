package com.albert.pockotlintestcodeforjava

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FinalClassTestWithKotlinMockk {

    @Test
    internal fun name() {

        val mock = mockk<FinalClass>()

        every { mock.aMethod() } returns "mocked result"

        val result = mock.aMethod()

        assertThat(result).isEqualTo("mocked result");
        // It works.
    }
}