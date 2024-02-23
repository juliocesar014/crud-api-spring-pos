package com.example.api2.validators;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class EmailValidator implements
        ConstraintValidator<EmailValidation, String> {
    private String message;
    @Override
    public void initialize(EmailValidation constraintAnnotation) {
        message = constraintAnnotation.message();
    }


    @Override
    public boolean isValid(String nome, ConstraintValidatorContext constraintValidatorContext) {
        if(!nome.contains("@")) {
            return false;
        }
        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext
                .buildConstraintViolationWithTemplate(message + nome)//
                .addConstraintViolation();
        return false;
    }

}
