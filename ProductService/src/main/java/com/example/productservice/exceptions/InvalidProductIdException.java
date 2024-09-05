package com.example.productservice.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class InvalidProductIdException extends Exception{
    private Long Id;
    public InvalidProductIdException(String message,Long Id){
        super(message);
        this.Id=Id;
    }
}
