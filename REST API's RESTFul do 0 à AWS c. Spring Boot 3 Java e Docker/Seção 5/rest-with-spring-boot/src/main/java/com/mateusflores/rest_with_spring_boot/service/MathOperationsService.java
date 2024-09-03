package com.mateusflores.rest_with_spring_boot.service;

import com.mateusflores.rest_with_spring_boot.converters.NumberConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathOperationsService {
    public static Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public static Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public static Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public static Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public static Double squareRoot(Double number) {
        return Math.sqrt(number);
    }

    public static Double mean(List<String> numbers) {
        return numbers.stream().mapToDouble(NumberConverter::convertToDouble).sum()
                / numbers.size();
    }
}
