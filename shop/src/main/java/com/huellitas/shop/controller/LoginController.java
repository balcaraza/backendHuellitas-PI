package com.huellitas.shop.controller;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;

import com.huellitas.shop.config.JwtFilter;
import com.huellitas.shop.dto.Token;
import com.huellitas.shop.model.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huellitas.shop.service.UsuarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path = "/api/login/")// http://localhost:8080/api/login/
public class LoginController {
	
	private final UsuarioService usuarioService;

	@Autowired
	public LoginController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	
	@PostMapping
	public Token loginUser (@RequestBody Usuarios usuario) throws ServletException {
		if (usuarioService.validateUser(usuario)) {
			System.out.println("Usuario valido " + usuario.getCorreo());
			return new Token(generateToken(usuario.getCorreo()));
		}//if
		throw new ServletException("Nombre de usuario o contraseña incorrectos "+usuario.getCorreo());
	}//loginUser
	
	private String generateToken(String username) {
		Calendar calendar = Calendar.getInstance();//Fecha hora actual
		calendar.add(Calendar.HOUR, 10); // Pruebas
		//calendar.add(Calendar.MINUTE, 30);// Producción
		return Jwts.builder().setSubject(username).claim("role", "user")
		.setIssuedAt(new Date())
		.setExpiration(calendar.getTime())
		.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
		.compact();
	}//generateToken
	

}
