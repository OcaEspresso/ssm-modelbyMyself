package com.company.utils;

public enum MessageCode {

    REQUEST_SUCCESS(0,"请求成功"),
    SYSTEM_ERROR(50000,"对不起，系统开小差了!"),
    SMS_EXPIRE(50005,"验证码失效!"),
    SMS_ERROR(50006,"验证码输入错误!"),
    NO_PERMISSION(50007,"你没有权限!"),
    NOT_EXISTS_TOKEN(50008,"未携带token"),
    INVALID_TOKEN(50009,"无效的token"),
    FAIL_LOGIN(50010,"用户名或密码不正确!");

    private Integer code;
    private String msg;

    private MessageCode(Integer code, String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}