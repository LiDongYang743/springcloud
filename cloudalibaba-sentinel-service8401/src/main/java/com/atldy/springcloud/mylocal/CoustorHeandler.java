package com.atldy.springcloud.mylocal;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atldy.springcloud.domain.CommonResult;

/**
 * @author 唐多山
 * @create 2020-09-25 16:07
 */
public class CoustorHeandler {

    public static CommonResult handleException1(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global handlerException----1\"\n");
    }

    public static CommonResult handleException2(BlockException exception) {
        return new CommonResult(444, "按客户自定义,global handlerException----2\"\n");
    }
}
