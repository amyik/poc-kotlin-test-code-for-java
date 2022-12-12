package com.albert.testdouble

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.impl.annotations.SpyK
import io.mockk.junit5.MockKExtension
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

import org.assertj.core.api.Assertions.assertThat


@ExtendWith(MockKExtension::class)
class CalculatorServiceMockKTest {

    @InjectMockKs
    lateinit var demoService: DemoService

    @MockK
    lateinit var calculatorServiceMock: CalculatorService

    @RelaxedMockK
    lateinit var calculatorServiceRelaxedMockK: CalculatorService

    @SpyK
    var calculatorServiceSpy = CalculatorService()



    @Test
    fun `stubbing과 함수 호출 여부 verify`() {
        every { calculatorServiceMock.sum(1,1) } returns 3
        val sum = demoService.sum(1,1)
        assertThat(sum).isEqualTo(3)
        verify{calculatorServiceMock.sum(1,1)}
    }

    @Test
    fun `argument capturing`() {

        val slot = slot<Int>()

        every { calculatorServiceMock.sum(capture(slot), any()) } answers {
            println(slot.captured)
            3;
        }

        demoService.sum(2, 2)
        demoService.sum(3, 3)

        verify(atLeast = 2) { calculatorServiceMock.sum(or(2, 3), any()) }
    }

    @Test
    fun `SpyK객체는 실제 로직을 타지만 stubbing도 가능하다`() {
        val ret1 = calculatorServiceSpy.sum(1, 1)
        assertThat(ret1).isEqualTo(2)

        every { calculatorServiceSpy.sum(1, 1) } returns 1
        val ret2 = calculatorServiceSpy.sum(1, 1)
        assertThat(ret2).isEqualTo(1)
    }

    @Test
    fun `MockK는 반드시 Stubbing을 해주어야 한다, 기본값을 원하면 RelaxedMockK를 사용하라`() {
        val sum = calculatorServiceMock.sum(1, 1) // no answer found 에러
        assertThat(sum).isEqualTo(0)
    }

    @Test
    fun `Relaxed MockK은 기본 리턴값이 정해져 있다 기존 Mockito-Mock과 유사`() {
        val sum = calculatorServiceRelaxedMockK.sum(1, 1)
        assertThat(sum).isEqualTo(0)
        verify { calculatorServiceRelaxedMockK.sum(1, 1) }
    }
}