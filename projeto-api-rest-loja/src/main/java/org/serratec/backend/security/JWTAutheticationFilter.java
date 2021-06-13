package org.serratec.backend.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.serratec.backend.entity.ClienteEntity;
import org.serratec.backend.logado.LogarCliente;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTAutheticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAutheticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		super();
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		
		try {
			System.out.println("oi");
			LogarCliente creds = new ObjectMapper().readValue(request.getInputStream(), LogarCliente.class);
			
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken
//					(creds.getUsername(), creds.getSenha(), new ArrayList<>());
					(creds.getEmail(), creds.getSenha(), new ArrayList<>());
			Authentication auth = authenticationManager.authenticate(authToken);
		
			return auth;
		}
		catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
//		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String usermail = ((UserSS) auth.getPrincipal()).getEmail();
		String id = ((UserSS) auth.getPrincipal()).getId().toString();
		String token = jwtUtil.generateToken(usermail);
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("id", id);
	}

}
