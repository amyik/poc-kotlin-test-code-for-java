package com.albert.pockotlintestcodeforjava

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SimpleTest {

    private val javaService: JavaService = JavaService()
    private val kotlinService: KotlinService = KotlinService()

    @Test
    internal fun `자바코드를 코틀린으로 테스트`() {

        val ret: String = javaService.sayHello()
        assertEquals("Hello Java", ret)
        assertThat(ret).isEqualTo("Hello Java")
    }

    @Test
    internal fun `코틀린코드를 코틀린으로 테스트`() {

        val ret: String = kotlinService.sayHello()
        assertEquals("Hello Kotlin", ret)
    }
}