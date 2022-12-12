package com.albert.testdouble;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TestDoubleMockitoTest {

    @InjectMocks DemoService demoService;
    @Mock CalculatorService calculatorServiceMock;
//    @Spy
    CalculatorService calculatorServiceSpy;

    @BeforeEach
    void setup(){
        calculatorServiceSpy = spy(CalculatorService.class);
    }

    @Test
    @DisplayName("stubbing과 함수 호출 여부 verify")
    void stubbing_verify() {
        when(calculatorServiceMock.sum(1,1)).thenReturn(3);
        int sum = demoService.sum(1, 1);
        assertThat(sum).isEqualTo(3);

        verify(calculatorServiceMock, times(1)).sum(1,1);
        verify(calculatorServiceMock).sum(1,1);
    }

    @Test
    @DisplayName("Mock객체는 실제 로직을 타지 않는다.")
    void mockWithoutStub() {
        int ret = calculatorServiceMock.sum(1, 1);
        assertThat(ret).isEqualTo(0);
    }

    @Test
    @DisplayName("Mock객체는 Stubbing이 가능하다.")
    void mockWithStub() {
        when(calculatorServiceMock.sum(1, 1)).thenReturn(3);
        int ret = calculatorServiceMock.sum(1, 1);
        assertThat(ret).isEqualTo(3);
    }

    @Test
    @DisplayName("Spy객체는 실제 로직을 탄다.")
    void spyWithoutStub() {
        int ret = calculatorServiceSpy.sum(1, 1);
        assertThat(ret).isEqualTo(2);
    }

    @Test
    @DisplayName("Spy객체는 실제 로직을 타지만 Stubing도 가능하다..")
    void spyWithStub() {
        doReturn(3).when(calculatorServiceSpy).sum(1,1);
        int ret = calculatorServiceSpy.sum(1, 1);
        assertThat(ret).isEqualTo(3);
    }
}