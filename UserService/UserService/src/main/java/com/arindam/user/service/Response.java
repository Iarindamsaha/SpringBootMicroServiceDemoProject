package com.arindam.user.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
public class Response {

    private String message;
    private Object object;

}
