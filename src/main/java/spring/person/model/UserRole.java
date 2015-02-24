package spring.person.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
	USER,ADMIN;
	
	public SimpleGrantedAuthority getAuthority() {
		return new SimpleGrantedAuthority(getRoleStr());
	}

	public String getRoleStr() {
		return "ROLE_" + name();
	}	
	
}
