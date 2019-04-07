package com.sandog.taisui.controller;

import com.sandog.taisui.auth.TokenAuth;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sandog on 2019/4/6.
 */
@RestController
public class TaisuiController {

    @RequestMapping("/")
    public String index(String token) {
        Claims claims = TokenAuth.parseJWT(token);
        return claims.get("name", String.class);
    }

}
