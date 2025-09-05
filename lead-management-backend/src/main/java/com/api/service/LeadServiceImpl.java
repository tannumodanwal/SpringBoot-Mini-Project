package com.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entity.Lead;
import com.api.repository.LeadRepo;

@Service
public class LeadServiceImpl implements LeadService{
	
	@Autowired
    private LeadRepo leadRepository;


	@Override
	public Lead saveLead(Lead lead) {
		  return leadRepository.save(lead);
	}

	@Override
	public List<Lead> getAllLeads() {
        return leadRepository.findAll();

	}

	@Override
	public Lead getLeadById(Long id) {
	
		return leadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lead not found with id: " + id));
		
	}

	@Override
	public void deleteLead(Long id) {

        leadRepository.deleteById(id);

		
	}

}
