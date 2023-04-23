package com.konrad_szydlowski.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourseNotFoundException extends Exception{

    public ResourseNotFoundException(String m){
        super(m);
    }
}
