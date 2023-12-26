package com.practiceproject.webshop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practiceproject.webshop.entities.Person;
import com.practiceproject.webshop.entities.principals.PersonPrincipal;
import com.practiceproject.webshop.repointerface.PersonRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	PersonRepository personRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Person person = personRepo.findByUsername(username).get();

		return new PersonPrincipal(person);
	}

}

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.practiceproject.webshop.entities.Person;
//import com.practiceproject.webshop.repointerface.UserRepository;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//	@Autowired
//	UserRepository userRepo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		System.out.println("in CustoUserDetails class");
//
////		Load user by username from the database
//		Person person = userRepo.findByUsername(username).get();
//		System.out.println(person);
//		return person;
//	}
//}
