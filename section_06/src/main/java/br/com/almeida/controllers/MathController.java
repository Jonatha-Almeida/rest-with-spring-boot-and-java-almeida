package br.com.almeida.controllers;

import br.com.almeida.exceptions.UnsupportedMathOperationException;
import br.com.almeida.math.SimpleMath;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.almeida.request.converters.NumberConverter.isNumeric;
import static br.com.almeida.request.converters.NumberConverter.convertToDouble;

@RestController
@RequestMapping("/math")
public class MathController {

    private final SimpleMath simpleMath;

    public MathController(SimpleMath simpleMath) {
        this.simpleMath = simpleMath;
    }

    // http://localhost:8080/math/sum/2/3
    @RequestMapping(path = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        var one = convertToDouble(numberOne);
        var two = convertToDouble(numberTwo);
        return this.simpleMath.sum(one, two);
    }
    // http://localhost:8080/math/subtraction/2/3
    @RequestMapping(path = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        var one = convertToDouble(numberOne);
        var two = convertToDouble(numberTwo);
        return this.simpleMath.subtraction(one, two);
    }

    // http://localhost:8080/math/multiplication/2/3
    @RequestMapping(path = "/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        var one = convertToDouble(numberOne);
        var two = convertToDouble(numberTwo);
        return this.simpleMath.multiplication(one, two);
    }

    // http://localhost:8080/math/division/2/3
    @RequestMapping(path = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        var one = convertToDouble(numberOne);
        var two = convertToDouble(numberTwo);
        if(two == 0) throw new UnsupportedMathOperationException("cannot divide by zero");
        return this.simpleMath.division(one, two);
    }

    // http://localhost:8080/math/mean/3/3
    @RequestMapping(path = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value");
        var one = convertToDouble(numberOne);
        var two = convertToDouble(numberTwo);
        return this.simpleMath.mean(one, two);
    }

    // http://localhost:8080/math/squareRoot/81
    @RequestMapping(path = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable("number") String number
    ){
        if(!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value");
        var convertedNumber = convertToDouble(number);
        return this.simpleMath.squareRoot(convertedNumber);
    }
}
