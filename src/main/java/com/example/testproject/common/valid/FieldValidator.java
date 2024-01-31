package com.example.testproject.common.valid;

import com.example.testproject.common.annotation.ValidationAnnotation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// ConstraintValidator<어노테이션, 타입>를 가져와서 구현해야함
public class FieldValidator implements ConstraintValidator<ValidationAnnotation, String> {

    // 초기화 (초기화 할 값 없으면 안 써도 됨)
    @Override
    public void initialize(ValidationAnnotation constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    // 유효성 체크
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        return value != null && value.equals("hello");
    }

}
