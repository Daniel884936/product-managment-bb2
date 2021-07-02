package com.productmanagment.productmanagment.apierror;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * This class holds a list of {@code ErrorModel} that describe the error raised on rejected validation
 * @author DANIEL TEJADA
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private List<ErrorModel> errorMessage;
}



