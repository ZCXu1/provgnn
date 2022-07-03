package com.xzc.provgnn.result;

/**
 * @Author: ZCXu1
 * @Date: 2022/7/3 15:31
 * @Version: 1.0.0
 * @Description:
 */
public enum Code {
    /**
     * Success
     */
    SUCCESS(20000),
    /**
     * Fail
     */
    FAILED(60204);
    private final int code;
    Code(int code){
        this.code = code;
    }
    public int getCode(){
        return this.code;
    }

}