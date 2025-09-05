package com.api.service;

import java.util.List;
import com.api.entity.Lead;

public interface LeadService {

	
	Lead saveLead(Lead lead);
    List<Lead> getAllLeads();
    Lead getLeadById(Long id);
    void deleteLead(Long id);
}
