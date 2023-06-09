package com.example.demo.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class SecurityService {
	
	private static final String SECRET_KEY="sfjkljeijfiojajdjdjdjdjdjjsekloeoeoodof;akfokkf";
	
	//로그인 서비스 던질때
	public String createToken(String subject, long expTime) {
		if(expTime<=0) {
			throw new RuntimeException("만료시간이 @보다 커야함");
		}
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //사용할 알고리즘
		
		byte[] secretKeyBytes=DatatypeConverter.parseBase64Binary(SECRET_KEY); //스트링을 바이트로 만들어주는거 jaxb-api 디펜던시 추가
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
		
		return Jwts.builder()
				.setSubject(subject)
				.signWith(signingKey, signatureAlgorithm)
				.setExpiration(new Date(System.currentTimeMillis()+expTime)) //현재시간에 +만료시간
				.compact();
	}
	//valid token 토큰 검증하는 메서드를 boolean으로 return
	public String getSubject(String token) {
		Claims claims=Jwts.parserBuilder()  //claim= payload내에 담기는 정보
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}

	
	
	
	
}
