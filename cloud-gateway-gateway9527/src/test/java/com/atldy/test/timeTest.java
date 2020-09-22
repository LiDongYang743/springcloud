package com.atldy.test;

import java.time.ZonedDateTime;

/**
 * @author 唐多山
 * @create 2020-09-21 10:12
 */
public interface timeTest {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println("zonedDateTime = " + zonedDateTime);
        // 2020-09-21T10:19:06.738+08:00[Asia/Shanghai]
    }
}
