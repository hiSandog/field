package com.sandog.filter;

import com.sandog.auth.TokenAuth;
import io.jsonwebtoken.Claims;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * Created by sandog on 2019/4/7.
 */
public class LogFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, GatewayFilterChain gatewayFilterChain) {
        ServerHttpRequest request = serverWebExchange.getRequest();
        String token = request.getHeaders().getFirst("token");
        try {
            Claims claims = TokenAuth.parseJWT(token);
            String userName = claims.get("name", String.class);
            System.out.println(userName);
            ServerHttpRequest host = request.mutate().header("user_name", "ggg").build();
            serverWebExchange = serverWebExchange.mutate().request(host).build();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("log---" + request.getPath().toString());
        return gatewayFilterChain.filter(serverWebExchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
