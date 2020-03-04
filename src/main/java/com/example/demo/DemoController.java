package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class DemoController {
    @GetMapping("/error1")
    public void error1() {
        throw new NotFoundException(1);
    }

    @GetMapping("/error2")
    public void error2() {
        throw new SpecialException("Special business error");
    }

    @GetMapping("/error3")
    public void error3() throws BusinessException {
        throw new BusinessException(333, "some error");
    }

    @GetMapping("/error4")
    public void error4() {
        try {
            int i = 1 / 0;
        } catch (ArithmeticException e) {
            throw new InternalException("calculate error", e);
        }
    }

    @GetMapping("/error5")
    public void error5() {
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "validate fail");
    }

    @ResponseStatus(value= HttpStatus.INSUFFICIENT_STORAGE, reason="Not enough disk")
    @ExceptionHandler(SpecialException.class)
    public void handleSpecialException(SpecialException e){
        e.printStackTrace(); // log
        //returning 507 error code
    }
}
