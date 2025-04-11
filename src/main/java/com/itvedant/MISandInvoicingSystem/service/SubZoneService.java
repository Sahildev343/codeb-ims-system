package com.itvedant.MISandInvoicingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.MISandInvoicingSystem.dao.AddSubZonesDAO;
import com.itvedant.MISandInvoicingSystem.dao.UpdateSubZoneDAO;
import com.itvedant.MISandInvoicingSystem.entity.SubZone;
import com.itvedant.MISandInvoicingSystem.repository.SubZoneRepository;

@Service
public class SubZoneService {

	
	@Autowired
	private SubZoneRepository subZoneRepository;
	
	
	public SubZone create(AddSubZonesDAO addSubZonesDAO) {
		
		SubZone subZone = new SubZone();
	    subZone.setName(addSubZonesDAO.getName());
	    
	    this.subZoneRepository.save(subZone);
	    
	    return subZone;
	}
	
	
	public SubZone getById(Integer id) {
		SubZone subZone = this.subZoneRepository.findById(id).orElseThrow(()-> {
			
			throw new RuntimeException("SubZone Record with this id not found");
		});
		
		return subZone;
	}
	
	
	public List<SubZone> getAll() {
		
		List<SubZone> li = new ArrayList<>();
		li = this.subZoneRepository.findAll();
		
		return li;
	}
	
	
	public SubZone update(UpdateSubZoneDAO updateSubZoneDAO, Integer id) {
		
		 SubZone subZone =  getById(id);
		 
		 if(updateSubZoneDAO.getName() != null) {
			 
			 subZone.setName(updateSubZoneDAO.getName());
		 }
		 
		 this.subZoneRepository.save(subZone);
		 
		 return subZone;
	}
	
	public String delete(Integer id) {
		
		this.subZoneRepository.deleteById(id);
		
		return "Record Deleted Successfully";
	}
}
