package com.atldy.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 唐多山
 * @create 2020-08-28 16:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    
    private Integer code; 
    private String  message;
    private T data;

    public  CommonResult(Integer code,String  message){
        this(code,message,null);
    }

    
}
