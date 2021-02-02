package com.oriri.exception;

public interface ErrorInfo {
    String getCode();

    String getMessage(Object... params);
}
