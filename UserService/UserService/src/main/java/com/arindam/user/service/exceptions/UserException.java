package com.arindam.user.service.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserException extends RuntimeException{

    private String message;
    private HttpStatus status;

}
