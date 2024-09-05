package com.example.productservice.advices;

import com.example.productservice.Dtos.ArithmeticExceptionDto;
import com.example.productservice.Dtos.ArrayIndexOutofBoundExceptionDto;
import com.example.productservice.Dtos.ExceptionDTO;
import com.example.productservice.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionHandlerAdvice {
    @ExceptionHandler(ArithmeticException.class)
    public  ResponseEntity<ArithmeticExceptionDto>  handleArithmeticException(){
        ArithmeticExceptionDto arithmeticExceptionDto=new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("Something went wrong");
        arithmeticExceptionDto.setDetails("abc");
        return new ResponseEntity<>(arithmeticExceptionDto, HttpStatus.BAD_REQUEST);

    }
    public ResponseEntity<ArrayIndexOutofBoundExceptionDto> handleAIOBException() {
        return null;


    }
    @ExceptionHandler(InvalidProductIdException.class)
        public ResponseEntity<ExceptionDTO> handleIvalidProductIdException(InvalidProductIdException exception){
            ExceptionDTO exceptionDTO=new ExceptionDTO();
            exceptionDTO.setProductId(exception.getId());
            exceptionDTO.setMessage("Invalid ProductId passed, please enter a valid ProductId");
            return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
        }
    }
