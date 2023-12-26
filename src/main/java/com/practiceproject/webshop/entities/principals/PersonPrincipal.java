package com.practiceproject.webshop.entities.principals;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.practiceproject.webshop.entities.Person;
import com.practiceproject.webshop.entities.Role;

public class PersonPrincipal implements UserDetails {

	private Person person;

	public PersonPrincipal(Person person) {
		this.person = person;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<SimpleGrantedAuthority> userAuthority = new HashSet<SimpleGrantedAuthority>();

		Set<Role> role = person.getRole();

		for (Role r : role) {
			userAuthority.add(new SimpleGrantedAuthority(r.getRoleName()));
		}

		return userAuthority;
	}

	@Override
	public String getPassword() {
		return person.getPassword();
	}

	@Override
	public String getUsername() {
		return person.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
