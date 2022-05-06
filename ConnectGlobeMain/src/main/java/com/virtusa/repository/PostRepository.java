package com.virtusa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.model.Post;
import com.virtusa.model.UserDetails;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findByCreatedby(UserDetails userdetails);
	List<Post> findByHandleby(UserDetails userdetails);

}
