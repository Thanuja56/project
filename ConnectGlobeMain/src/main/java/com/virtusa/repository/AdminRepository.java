package com.virtusa.repository;

import com.virtusa.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AdminRepository extends JpaRepository<AdminDetails,Long> {

}

