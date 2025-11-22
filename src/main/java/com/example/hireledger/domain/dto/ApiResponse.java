package com.example.hireledger.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {

    private boolean success;

    private T result;

    public static <T> ApiResponse<T> error(T result) {
        return new ApiResponse<>(false, result);
    }

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse<>(true, result);
    }
}