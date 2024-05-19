package com.atguigu.schedule.common;

/**
 * 业务含义和状态码对应关系的枚举
 * @author LiHongFei
 * @since 2024/5/19
 */
public enum ResultCodeEnum {
    SUCCESS(200,"success"),
    USERNAME(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notlogin"),
    USERNAME_USED(505,"usernameUsed");


    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
