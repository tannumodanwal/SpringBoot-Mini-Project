package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entity.Lead;

public interface LeadRepo extends JpaRepository<Lead,Long>{

	
}
