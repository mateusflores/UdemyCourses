package com.mateusflores.rest_with_spring_boot.service;

import com.mateusflores.rest_with_spring_boot.converters.NumberConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathOperationsService {
    public MathOperationsService() {
    }

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double squareRoot(Double number) {
        return Math.sqrt(number);
    }

    public Double mean(List<String> numbers) {
        return numbers.stream().mapToDouble(NumberConverter::convertToDouble).sum()
                / numbers.size();
    }
}
