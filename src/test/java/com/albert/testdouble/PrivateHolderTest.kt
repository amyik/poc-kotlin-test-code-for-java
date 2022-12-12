package com.albert.testdouble

import io.mockk.every
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.util.ReflectionTestUtils

@ExtendWith(MockKExtension::class)
class PrivateHolderTest {

    @SpyK(recordPrivateCalls = true)
    var privateHolder = PrivateHolder()

    @Test
    fun `private method stubbing`() {
        assertThat(privateHolder.callPrivateMethod()).isEqualTo("Not Stubbed")

        every{ privateHolder["getPrivateStringField"]() } returns "Now I am stubbed"

        assertThat(privateHolder.callPrivateMethod()).isEqualTo("Now I am stubbed")

        verify{ privateHolder["getPrivateStringField"]() }
    }

    @Test
    fun `private field stubbing`() {
        assertThat(privateHolder.callPrivateMethod()).isEqualTo("Not Stubbed")
        ReflectionTestUtils.setField(privateHolder, "privateStringField", "Now I am stubbed", String::class.java )
        assertThat(privateHolder.callPrivateMethod()).isEqualTo("Now I am stubbed")
    }
}