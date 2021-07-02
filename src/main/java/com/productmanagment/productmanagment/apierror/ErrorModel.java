package com.productmanagment.productmanagment.apierror;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class describe the error object model, which is a simple DTO that contains the rejected filedName, rejectedValue
 * and a messageError.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {
    private String fieldName;
    private Object rejectedValue;
    private  String messageError;
}
