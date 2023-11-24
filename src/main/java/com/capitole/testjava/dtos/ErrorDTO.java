package com.capitole.testjava.dtos;

import lombok.Data;
import lombok.experimental.Builder;

@Data
@Builder
public class ErrorDTO {
    private String code;
    private String message;

}
