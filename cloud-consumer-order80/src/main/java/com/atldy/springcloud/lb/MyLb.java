package com.atldy.springcloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 唐多山
 * @create 2020-09-10 20:05
 */
@Slf4j
@Component
public class MyLb implements Loadbalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 获取第几次访问
     *
     * @return
     */
    public int getAndIncrement() {
        int current;
        int next;
//        自寻锁
        do {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current +1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("****第："+next+"次");
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
