package com.virtusa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.model.UserDetails;



@Repository
public interface UserRepository extends JpaRepository<UserDetails, String> {
	List<UserDetails> findByReportto(UserDetails userdetails);
}