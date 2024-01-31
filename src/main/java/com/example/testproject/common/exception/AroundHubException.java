package com.example.testproject.common.exception;

import com.example.testproject.common.Constants;
import org.springframework.http.HttpStatus;

public class AroundHubException extends Exception{

    private static final long serialVersionUID = 4663380430591151694L; // 직렬화

    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    // 생성자
    public AroundHubException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message){
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass(){
        return exceptionClass;
    }

    public int getHttpStatusCode(){
        return httpStatus.value();
    }

    public String getHttpStatusType(){
        return httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }

}
