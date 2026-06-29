package com.aaruchalet.dto.common;

public record ApiResponse<T>(
        boolean success,
        String message,
        T data,
        Object error
) {

  public static <T> ApiResponse<T> success(String message, T data) {
    return new ApiResponse<>(true, message, data, null);
  }

  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(true, null, data, null);
  }

  public static ApiResponse<Void> failure(Object error) {
    return new ApiResponse<>(false, null, null, error);
  }

  public static ApiResponse<Void> success(String message) {
    return new ApiResponse<>(true, message, null, null);
  }
}
