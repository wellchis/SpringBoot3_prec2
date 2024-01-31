package com.example.testproject.common.valid;

import com.example.testproject.common.annotation.ValidationAnnotation;
import lombok.Getter;

@Getter
public class TempDto {
    @ValidationAnnotation
    private String value;
}
