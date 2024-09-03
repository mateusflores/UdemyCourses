package com.mateusflores.rest_with_spring_boot.controllers;

import com.mateusflores.rest_with_spring_boot.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/math/", method = RequestMethod.GET)
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable(value="numberOne") String numberOne,
                              @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(@PathVariable(value="numberOne") String numberOne,
                              @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value="numberOne") String numberOne,
                                 @PathVariable(value="numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        if (convertToDouble(numberTwo) == 0D) {
            throw new Exception("It's impossible to divide by zero");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value="number") String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        if (convertToDouble(number) < 0) {
            throw new UnsupportedMathOperationException("Set a positive value");
        }
        return Math.sqrt(convertToDouble(number));
    }

    @RequestMapping(value = "/mean", method = RequestMethod.GET)
    public Double mean(@RequestParam("numbers") List<String> numbers) throws Exception {
        if (!numbers.stream().allMatch(this::isNumeric)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return numbers.stream().mapToDouble(this::convertToDouble).sum() / numbers.size();
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        String number = strNumber.replaceAll(",", ".");

        return isNumeric(number) ? Double.parseDouble(number) : 0D;
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
