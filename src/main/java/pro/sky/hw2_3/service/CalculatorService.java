package pro.sky.hw2_3.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int plus(Integer a, Integer b) {
        return a + b;
    }

    public int minus(Integer a, Integer b) {
        return a - b;
    }

    public int multiply(Integer a, Integer b) {
        return a * b;
    }

    public Number divide(Integer a, Integer b) {
        return a.doubleValue()/b;
    }
}
