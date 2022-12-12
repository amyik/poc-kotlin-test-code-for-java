package com.albert.testdouble;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int sum(int first, int second) {
        return first + second;
    }
}
