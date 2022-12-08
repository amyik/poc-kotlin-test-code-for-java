package com.albert.pockotlintestcodeforjava;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

public class FinalClassTestWithJava {

    FinalClass mock = Mockito.mock(FinalClass.class);

    @Test
    void name() {
        when(mock.aMethod()).thenReturn("mocked result");

        String result = mock.aMethod();

        assertThat(result).isEqualTo("mocked result");
        // This assertion fails. mockito can not mock final class
    }
}
