package com.ssafy.happyhouse.model.service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.dto.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//@Slf4j
@Service("jwtService")
public class JwtServiceImpl implements JwtService{

    private static final String SECRET_KEY = "accessToken";

    // 토큰 발행
    @Override
    public String createToken(User subject, long time) {
        if (time <= 0) {
            throw new RuntimeException("Expiry time must be greater than Zero : ["+time+"] ");
        }
        // 토큰을 서명하기 위해 사용해야할 알고리즘 선택
        SignatureAlgorithm  signatureAlgorithm = SignatureAlgorithm.HS256;

        byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
        		.setSubject("login token")
                .claim("user",subject)
                .signWith(signatureAlgorithm, signingKey);
        long nowTime = System.currentTimeMillis();
        builder.setExpiration(new Date(nowTime + time));
        return builder.compact();
    }

    // 토큰 해독
    @Override
    public Map<String, Object> getSubject(String token) {
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(token);
        return claims.getBody();
    }

    @Override
    public boolean isUsable(String jwt) throws Exception {
        try{
        	Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                    .parseClaimsJws(jwt);
            return true;

        }catch (Exception e) {
            throw new RuntimeException("올바르지않은 토큰입니다.");
        }
    }
}