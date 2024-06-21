package com.example.qldl.exception;

public enum ErrorCode {
    STUDENT_EXISTED(1001, "Student existed"),
    STUDENT_NOT_EXIST(1002, "Student not exist"),
    USER_NOT_EXISTED(1003, "User not exist"),
    UNAUTHENTICATED(1004, "Unauthenticated");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
