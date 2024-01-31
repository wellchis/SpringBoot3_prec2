package com.example.testproject.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // RUNTIME이 대부분.
@Target(ElementType.FIELD) // 어디에서 적용할 것인지
public @interface FieldAnnotation {

    String name();
    String value();

}
