package com.example.member.common.command.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpStatus;

public class CustomResponseUtils {

    public static <T> CustomResponse<T> success(T data) {
        return new CustomResponse<>("SUCCESS", HttpStatus.OK.value(), data);
    }

    public static <T> CustomResponse<T> success(T data, int statusCode) {
        return new CustomResponse<>("SUCCESS", statusCode, data);
    }

    public static CustomResponse<?> error(String message, int statusCode) {
        return new CustomResponse<>(message, statusCode, null);
    }

    @Getter
    @AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
    public static class CustomResponseError {

        private final String message;
        private final int statusCode;

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("message", message)
                    .append("statusCode", statusCode)
                    .toString();
        }
    }

    @Getter
    @AllArgsConstructor(access = lombok.AccessLevel.PROTECTED)
    public static class CustomResponse<T> {

        private final String message;
        private final int statusCode;
        private final T data;

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("message", message)
                    .append("statusCode", statusCode)
                    .append("data", data)
                    .toString();
        }
    }
}
