package com.wollcorp.globales;

import java.util.Calendar;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.interfaces.DecodedJWT;

public class Token {
	
	private String uid;
	private Date iat;
	private Date exp;
	private String key;
	private String token;
	
	public void generaToken(String noUsua) {
		
		String token = null;
		uid = noUsua;
		iat = new Date();
		exp = null;
		key = "W0LLC0RP$GAC3L42019$";
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(iat);
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		exp = calendar.getTime();
		
		try {
			
		    Algorithm algorithm = Algorithm.HMAC256(key);
		    token = JWT.create()
		        .withClaim("uid", uid)
		        .withClaim("iat", iat)
		        .withClaim("exp", exp)
		        .sign(algorithm);
		    
		    DecodedJWT jwt = JWT.decode(token);
		    
		    System.out.println("Algoritmo: " + jwt.getAlgorithm());
		    System.out.println("Type: " + jwt.getType());
		    System.out.println("uid: " + jwt.getClaim("uid").asString());
		    System.out.println("iat: " + jwt.getClaim("iat").asDate());
		    System.out.println("exp: " + jwt.getClaim("exp").asDate());
		    
		    
		} catch (JWTCreationException exception){
			
			token = null;
			((Log)Globales.variablesGlobales.get("log")).setMensaje("ERROR AL GENERAR EL TOKEN PARA EL USUARIO: " + noUsua);
			((Log)Globales.variablesGlobales.get("log")).setException(null);
			((Log)Globales.variablesGlobales.get("log")).setCodigo(-1);
			((Log)Globales.variablesGlobales.get("log")).setEstado(null);
			((Log)Globales.variablesGlobales.get("log")).setNombreClase(this.getClass().getName());
			((Log)Globales.variablesGlobales.get("log")).registraError();
			
		}
		
		this.token = token;
	}
	
	
	
	public String getToken() {
		
		return this.token;
	}
	
	

}