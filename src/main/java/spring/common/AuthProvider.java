package spring.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.person.Person;
import spring.person.dao.PersonDao;
import spring.person.model.UserRole;

@Service
public class AuthProvider implements AuthenticationProvider {
	@Resource
	PersonDao personDao;
	
	@Override
	public Authentication authenticate(
			Authentication authentication)
			throws AuthenticationException {
		
		String login = authentication.getName();
		String password = authentication.getCredentials().toString();
		
		System.out.printf("Login : %s, pass : %s\n", login, password);
		
		Person user = personDao.findByLoginAndPassword(login, password);
		
		if (user == null ){
			throw new UsernameNotFoundException("Login failed");
		}
		
		List<GrantedAuthority> grantedAuths = new ArrayList<>(); 
		for (UserRole ur : user.getRoles()) {
			grantedAuths.add(ur.getAuthority());			
		}
		System.out.println("User roles : "+grantedAuths);
		return new UsernamePasswordAuthenticationToken(login,password,grantedAuths);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
