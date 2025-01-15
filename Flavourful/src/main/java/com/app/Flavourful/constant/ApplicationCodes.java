package com.app.Flavourful.constant;

public enum ApplicationCodes {
    RECEIVED(0),
    ACCEPTED(1),
    REJECTED(2),
    PREPARING_ORDER(3),
    READY_FOR_PICKUP(4),
    ORDER_PICKED(5),
    DELIVERED(6),
    CANCELLED(7),
    NEW_ORDER(8);

    private final int statusCode;

    ApplicationCodes(int code) {
        this.statusCode = code;
    }

    public int getCode() {
        return statusCode;
    }
    public static ApplicationCodes fromCode(int code) {
        for (ApplicationCodes status : ApplicationCodes.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}
