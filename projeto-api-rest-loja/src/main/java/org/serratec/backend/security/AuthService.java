package org.serratec.backend.security;

import org.serratec.backend.entity.ClienteEntity;
import org.serratec.backend.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService{

	@Autowired
	ClienteRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {//
		ClienteEntity cliente = repository.findByEmail(email); //*username
		System.out.println("email: " + email);
		if(cliente == null) {
			System.out.println("Email não existe");
			return null;
		}
		
		return new UserSS(cliente.getId(),cliente.getUsername(),cliente.getSenha(),cliente.getEmail());
	
	}

}
