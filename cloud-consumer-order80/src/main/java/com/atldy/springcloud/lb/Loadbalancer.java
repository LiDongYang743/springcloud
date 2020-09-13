package com.atldy.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 唐多山
 * @create 2020-09-10 20:01
 */

public interface Loadbalancer {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}
