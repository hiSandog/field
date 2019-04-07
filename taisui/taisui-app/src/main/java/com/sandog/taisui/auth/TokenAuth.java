package com.sandog.taisui.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sandog on 2019/4/7.
 */
public class TokenAuth {

    private static final String KEY = "qwertyuiopasdfghjkl";
    private static final String AUDIENCE = "sandog";
    private static final long DEFAULT_TTLMILLIS = 24 * 3600 * 1000L;
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static String createJWT(Map<String, Object> params) {
        return createJWT(params, DEFAULT_TTLMILLIS);
    }

    public static String createJWT(Map<String, Object> params, long TTLMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成签名密钥
        Key signingKey = new SecretKeySpec(KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setClaims(params)
                .setAudience(AUDIENCE)
                .signWith(signatureAlgorithm, signingKey);
        //添加Token过期时间
        if (TTLMillis >= 0) {
            long expMillis = System.currentTimeMillis() + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        //生成JWT
        return builder.compact();
    }

    public static Claims parseJWT(String token) {
        try {
            Key signingKey = new SecretKeySpec(KEY.getBytes(), SignatureAlgorithm.HS256.getJcaName());
            Claims claims = Jwts.parser()
                    .setSigningKey(signingKey)
                    .parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    public static void main(String [] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "sandog");
        map.put("user_id", "1");
        String token = createJWT(map);
        System.out.println(token);
        Claims claims = parseJWT(token);
        System.out.println(claims.get("name"));
        System.out.println(claims.get("user_id"));
    }

}
