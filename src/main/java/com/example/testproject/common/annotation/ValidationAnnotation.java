package com.example.testproject.common.annotation;

import com.example.testproject.common.valid.FieldValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = FieldValidator.class) // 어떤 validator를 따르는지
public @interface ValidationAnnotation {

    String message() default "Invalid Value. It should be 'hello'";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
