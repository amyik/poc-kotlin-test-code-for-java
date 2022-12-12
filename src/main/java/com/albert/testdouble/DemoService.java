package com.albert.testdouble;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {

    private final CalculatorService calculatorService;

    public int sum(int first, int second) {
        return calculatorService.sum(first, second);
    }
}
