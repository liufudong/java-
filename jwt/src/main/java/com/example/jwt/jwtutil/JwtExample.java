package com.example.jwt.jwtutil;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtExample {

    public static final String SECRET_KEY = "your-256-bit-secret";

    /***
     * 加密
     * @param userId
     * @return
     */
    public static String createJwtToken(String userId) {
        // 设置JWT的过期时间
        Date expirationDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10); // 10小时

        // 创建一个Payload
        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("username", "张三");

        // 生成JWT
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }
    /***
     * 解密
     * @param token
     * @return
     */
    public static void validateJwtToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(JwtExample.SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println("JWT验证 User ID: " + claims.get("userId")+",username"+ claims.get("username"));
            // 可以在这里添加更多的验证逻辑，比如检查令牌是否过期等
        } catch (Exception e) {
            System.out.println("JWT验证失败: " + e.getMessage());
        }
    }
}