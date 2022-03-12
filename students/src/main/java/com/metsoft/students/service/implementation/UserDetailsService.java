package com.metsoft.students.service.implementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.metsoft.students.repository.AttendantRepository;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private AttendantRepository attendantRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		var result =attendantRepository.findByUsername(username);
		if(result !=null) {
			return new User(username,result.getPassword(),new ArrayList<>());
		}
		
		throw new UsernameNotFoundException(username);
	}

}
