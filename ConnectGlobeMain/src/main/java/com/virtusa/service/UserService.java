package com.virtusa.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.model.UserDetails;
import com.virtusa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public void saveUserDetails(UserDetails userdetails) {
		repo.save(userdetails);
	}
	
	public UserDetails findById(String user_id) {
		return repo.getById(user_id);
	}
	public List<UserDetails> listall(){
		return repo.findAll();
	}
	
	public List<UserDetails> tusers(String user_id){
		return repo.findByReportto(repo.getById(user_id));
	}
	
	public UserDetails validate(String user_id,String password) {
		if(repo.existsById(user_id)) {
			UserDetails user=repo.getById(user_id);
			if(user.getPassword().equals(password))
				return user;
		}
		return null;
	}
}