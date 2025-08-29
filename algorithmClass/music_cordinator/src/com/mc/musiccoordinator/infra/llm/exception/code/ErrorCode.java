package com.mc.musiccoordinator.infra.llm.exception.code;

public enum ErrorCode {
    INVALID_API_KEY("LL4030", "유효하지 않은 API-KEY입니다."),
    BAD_REQUEST("LL400", "잘못된 요청입니다"),
    INTERNAL_SERVER_ERROR("LL5000", "서버에러입니다"),
    ;

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return code;
    }

    public String message() {
        return message;
    }
}
