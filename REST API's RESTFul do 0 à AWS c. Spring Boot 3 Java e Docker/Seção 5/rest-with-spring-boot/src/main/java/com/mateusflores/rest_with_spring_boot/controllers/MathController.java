package com.mateusflores.rest_with_spring_boot.controllers;

import com.mateusflores.rest_with_spring_boot.converters.NumberConverter;
import com.mateusflores.rest_with_spring_boot.exceptions.UnsupportedMathOperationException;
import com.mateusflores.rest_with_spring_boot.service.MathOperationsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/math/", method = RequestMethod.GET)
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return MathOperationsService.sum(NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value="numberOne") String numberOne,
                              @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return MathOperationsService.subtraction(NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value="numberOne") String numberOne,
                              @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return MathOperationsService.multiplication(NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value="numberOne") String numberOne,
                                 @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        if (NumberConverter.convertToDouble(numberTwo) == 0D) {
            throw new Exception("It's impossible to divide by zero");
        }
        return MathOperationsService.division(NumberConverter.convertToDouble(numberOne),
                NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value="number") String number) throws Exception {
        if (!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        if (NumberConverter.convertToDouble(number) < 0) {
            throw new UnsupportedMathOperationException("Set a positive value");
        }
        return MathOperationsService.squareRoot(NumberConverter.convertToDouble(number));
    }

    @RequestMapping(value = "/mean", method = RequestMethod.GET)
    public Double mean(@RequestParam("numbers") List<String> numbers) throws Exception {
        if (!numbers.stream().allMatch(NumberConverter::isNumeric)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return MathOperationsService.mean(numbers);
    }
}
