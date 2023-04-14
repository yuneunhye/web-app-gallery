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
	
	//�α��� ���� ������
	public String createToken(String subject, long expTime) {
		if(expTime<=0) {
			throw new RuntimeException("����ð��� @���� Ŀ����");
		}
		
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //����� �˰�����
		
		byte[] secretKeyBytes=DatatypeConverter.parseBase64Binary(SECRET_KEY); //��Ʈ���� ����Ʈ�� ������ִ°� jaxb-api ������� �߰�
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
		
		return Jwts.builder()
				.setSubject(subject)
				.signWith(signingKey, signatureAlgorithm)
				.setExpiration(new Date(System.currentTimeMillis()+expTime)) //����ð��� +����ð�
				.compact();
	}
	//valid token ��ū �����ϴ� �޼��带 boolean���� return
	public String getSubject(String token) {
		Claims claims=Jwts.parserBuilder()  //claim= payload���� ���� ����
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}

	
	
	
	
}