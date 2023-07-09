package com.arindam.electronic_devices.exceptions;

import com.arindam.electronic_devices.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalException extends Exception{

    @Autowired
    Response response;

    @ExceptionHandler
    public ResponseEntity<Response> globalExceptionHandler(UserException userException){

        response.setMessage(userException.getMessage());
        return new ResponseEntity<>(response,userException.getStatus());

    }
}
