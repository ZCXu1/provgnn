package com.xzc.provgnn.result;

/**
 * @Author: ZCXu1
 * @Date: 2022/7/3 15:31
 * @Version: 1.0.0
 * @Description:
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    private int code;
    private T data;
    public static <T> Result<T> success(T data){
        return new Result<T>(Code.SUCCESS.getCode(),data);
    }


    public static <T> Result<T> failed(T data){
        return new Result<T>(Code.FAILED.getCode(),data);
    }

}