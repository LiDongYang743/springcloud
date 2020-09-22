package com.atldy.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 唐多山
 * @create 2020-09-20 21:51
 */
//@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atldy", r -> r.path("/guoji")
                .uri("http://news.baidu.com/guoji"))
                .build();
        return routes.build();
    }

    @Bean
    public RouteLocator route(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_routeatzs", r -> r.path("/mil").
                uri("http://news.baidu.com/mil")).
                build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("path_route_atguigu", r -> r.path("/guonei").
                uri("http://news.baidu.com/guonei")).
                build();
        return routes.build();
    }
}
