package com.atldy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author 唐多山
 * @create 2020-09-24 19:24
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA() {
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("这个是线程嗯呢：" + Thread.currentThread().getName() + "-------testA");
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }


    @GetMapping("/testD")
    public String testD() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试RT");

        return "------testD";
    }

    @GetMapping("/testE")
    public String testE()
    {

        log.info("testE 测试异常比例");
        int age = 10/0;
        return "------testE";
    }

    @GetMapping("/testF")
    public String testF()
    {
        log.info("testF 测试异常数");
        int age = 10/0;
        return "------testF 测试异常数";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "----------testHotKey    热点-----";
    }

//    热点兜底方法
    public String deal_testHotKey(String p1, String p2, BlockException blockException){
        return "deal_testHotKey 热点兜底方法 p："+p1;
    }


}
